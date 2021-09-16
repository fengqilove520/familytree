package top.fqq.familytree.bean.vo;

import lombok.Data;

/**
 * @author fitch
 * @date 2021/9/16 10:23
 */
@Data
public class PersonVo {

    /**
     * 编号
     */
    private String id;

    /**
     * 名称
     */
    private String name;

    /**
     * 性别
     */
    private Boolean sex;

    /**
     * 户籍地址
     */
    private String domicilePlace;

    /**
     * 居住地址
     */
    private String residentialAddress;
}
