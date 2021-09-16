package top.fqq.familytree.bean.po;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * person
 * @author
 */
@Data
public class PersonPo implements Serializable {
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

    /**
     * 删除标记
     */
    private Boolean deleted;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 创建人
     */
    private String createUser;

    private static final long serialVersionUID = 1L;
}
