package top.fqq.familytree.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 转义标识
 *
 * @author fitch
 * @date 2021/9/16 14:36
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Dict {

    /**
     * 转义code对应的属性名称
     *
     * @return
     */
    String codeFiled();

    /**
     * 字典类型
     *
     * @return
     */
    String type();
}
