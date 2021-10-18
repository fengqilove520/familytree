package top.fqq.familytree.util;

/**
 * @author fitch
 * @date 2021/9/22 13:41
 */
public class StringUtil {

    /**
     * 字符串是否为空
     *
     * @param str 被检测的字符串
     * @return 是否为空
     */
    public static boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }

    /**
     * 字符串是否为非空白
     *
     * @param str 被检测的字符串
     * @return 是否为非空
     */
    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

}
