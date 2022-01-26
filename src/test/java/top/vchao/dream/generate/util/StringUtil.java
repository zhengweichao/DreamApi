package top.vchao.dream.generate.util;

/**
 * String 工具类
 */
public class StringUtil {
    // 首字母大写
    public static String firstUp(String name) {
        char[] cs = name.toCharArray();
        cs[0] -= 32;
        return String.valueOf(cs);
    }

    // 首字母小写
    public static String firstDown(String name) {
        char[] cs = name.toCharArray();
        cs[0] += 32;
        return String.valueOf(cs);
    }

}
