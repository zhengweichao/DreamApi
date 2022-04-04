package top.vchao.dream.v1.data;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * 频繁访问数据存储类
 * （后续可改为 redis 实现）
 */
@Data
@Component
public class FrequentIpData {

    /**
     * ip访问记录 （ip\访问次数、初次访问时间（开始计数的时间））
     */
    Map<String, Long[]> ipMap = new HashMap<>();

    /**
     * 黑名单 （ip\封禁结束时间）
     */
    Map<String, Long> limitedIpMap = new HashMap<>();

    /**
     * 默认限制时间（单位：ms）
     * 1h => 60 * 60 * 1000
     */
    private static final long LIMITED_TIME_MILLIS = 5 * 1000;

    /**
     * 用户连续访问最高阀值，超过该值则认定为恶意操作
     */
    private static final int LIMIT_NUMBER = 10;

    /**
     * 用户访问最小安全时间，在该时间内如果访问次数大于阀值，则记录为恶意IP
     */
    private static final int MIN_SAFE_TIME = 1000;

    /**
     * 更新受限 IP 列表
     * 剔除已经到期的限制IP
     */
    public void updateFilterList() {
        Set<String> keys = limitedIpMap.keySet();
        Iterator<String> keyIt = keys.iterator();
        long currentTimeMillis = System.currentTimeMillis();
        while (keyIt.hasNext()) {
            long expireTimeMillis = limitedIpMap.get(keyIt.next());
            if (expireTimeMillis <= currentTimeMillis) {
                keyIt.remove();
            }
        }
    }

    /**
     * 判断 - 是否是被限制的IP
     *
     * @param ip 校验ip
     * @return true : 被限制 | false : 正常
     */
    public boolean isLimitedIP(String ip) {
        if (limitedIpMap == null || ip == null) {
            // 没有被限制
            return false;
        }
        Set<String> keys = limitedIpMap.keySet();
        for (String key : keys) {
            if (key.equals(ip)) {
                // 被限制的IP
                return true;
            }
        }
        return false;
    }

    /**
     * 获取剩余限制时间
     *
     * @param ip ip
     * @return 剩余时间
     */
    public long getLimitTime(String ip) {
        return limitedIpMap.get(ip) - System.currentTimeMillis();
    }

    /**
     * 增加限制 ip (封禁某 IP)
     *
     * @param ip ip
     */
    public void addLimitIp(String ip) {
        long currentTimeMillis = System.currentTimeMillis();
        limitedIpMap.put(ip, currentTimeMillis + LIMITED_TIME_MILLIS);
    }

    /**
     * 获取 ip 连接次数
     *
     * @param ip ip
     */
    public Long getIpAccessNumber(String ip) {
        Long[] ipInfo = ipMap.get(ip);
        return ipInfo[0];
    }

    /**
     * 获取 ip 开始计数的连接时间
     *
     * @param ip ip
     */
    public Long getAccessTime(String ip) {
        Long[] ipInfo = ipMap.get(ip);
        return ipInfo[1];
    }

    /**
     * 增加 ip 访问记录
     *
     * @param ip ip
     */
    public void addAccessLog(String ip) {
        Long[] ipInfo;// 初次访问时间
        long currentTimeMillis = System.currentTimeMillis();

        if (ipMap.containsKey(ip)) {
            // 记录过
            ipInfo = ipMap.get(ip);
            if (currentTimeMillis - getAccessTime(ip) >= MIN_SAFE_TIME) {
                // 已过安全事件 ===> 重置
                ipInfo[0] = 1L;
                ipInfo[1] = currentTimeMillis;// 初次访问时间
            } else {
                // 未过安全事件 ===> 计数+1
                ipInfo[0] += 1;// 访问次数
            }
        } else {
            // 没记录过
            ipInfo = new Long[2];
            ipInfo[0] = 1L;// 访问次数
            ipInfo[1] = currentTimeMillis;// 初次访问时间
        }
        ipMap.put(ip, ipInfo);
    }

    /**
     * 是否频繁
     *
     * @param ip ip
     */
    public boolean isFrequent(String ip) {
        if (ipMap == null || ip == null) {
            return false;
        }

        Long ipAccessNumber = getIpAccessNumber(ip);

        // 判断存储器中是否存在当前IP，如果没有则为初次访问，初始化该ip
        // 如果存在当前ip，则验证当前ip的访问次数
        // 如果大于限制阀值，判断达到阀值的时间，如果不大于[用户访问最小安全时间]则视为恶意访问
        if (ipMap.containsKey(ip)) {
            if (ipAccessNumber > LIMIT_NUMBER) {
                Long ipAccessTime = getAccessTime(ip);
                Long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ipAccessTime <= MIN_SAFE_TIME) {
                    addLimitIp(ip);
                    return true;
                } else {
                    addAccessLog(ip);
                }
            }
        } else {
            addAccessLog(ip);
        }
        return false;
    }

}
