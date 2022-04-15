package top.vchao.dream.v1.task;

import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.quartz.QuartzJobBean;

import javax.annotation.Resource;
import java.util.Map;

/**
 * 定时执行sql Job
 * 适用场景： 定时统计、定时去重 等
 */
@Slf4j
public class SqlExecJob extends QuartzJobBean {

    @Resource
    JdbcTemplate jdbcTemplate;

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) {
//        String userName = (String) jobExecutionContext.getJobDetail().getJobDataMap().get("sqlName");
//        String sql = (String) jobExecutionContext.getJobDetail().getJobDataMap().get("sql");
//
//        Map<String, Object> map = jdbcTemplate.queryForMap(sql);
//        log.info(userName + " ---> " + map.toString());
    }

}