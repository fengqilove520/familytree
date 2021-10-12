package top.fqq.familytree.bean.po;

import lombok.Data;

import java.io.Serializable;

/**
 * menu
 *
 * @author
 */
@Data
public class MenuPo implements Serializable {
    /**
     * 菜单ID
     */
    private String id;

    /**
     * 菜单名称
     */
    private String name;

    /**
     * 菜单编码
     */
    private String code;

    /**
     * 菜单描述
     */
    private String desc;

    /**
     * 菜单类型
     */
    private Integer type;

    /**
     * 菜单链接
     */
    private String url;

    /**
     * 父菜单ID
     */
    private String pid;

    /**
     * 菜单路径
     */
    private String path;

    /**
     * 菜单显示顺序
     */
    private Integer order;

    /**
     * 菜单图标
     */
    private String icon;

    private static final long serialVersionUID = 1L;
}
