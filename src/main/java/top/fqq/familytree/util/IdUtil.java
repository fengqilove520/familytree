package top.fqq.familytree.util;

import cn.hutool.core.lang.UUID;

/**
 * @author fitch
 * @date 2021/10/12 15:15
 */
public class IdUtil {

    /**
     * 生成Id
     *
     * @return
     */
    public static String generate() {
        return UUID.fastUUID().toString();
    }
}
