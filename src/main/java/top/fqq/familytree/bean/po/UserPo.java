package top.fqq.familytree.bean.po;

import lombok.Data;

import java.io.Serializable;

/**
 * menu
 *
 * @author
 */
@Data
public class UserPo implements Serializable {
    /**
     * 用户ID
     */
    private String id;

    /**
     * 用户名
     */
    private String name;

    /**
     * 用户密码
     */
    private String pwd;

    /**
     * 用户姓名
     */
    private String fullName;

    /**
     * 用户类型
     */
    private Integer type;

    /**
     * 用户性别
     */
    private Integer sex;

    /**
     * 用户身份证号
     */
    private String card;

    /**
     * 用户手机号
     */
    private String phone;

    /**
     * 用户邮箱
     */
    private String email;

    /**
     * 用户图片
     */
    private String image;
    private static final long serialVersionUID = 1L;
}
