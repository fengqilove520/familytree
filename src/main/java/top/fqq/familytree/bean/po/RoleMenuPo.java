package top.fqq.familytree.bean.po;

import lombok.Data;

import java.io.Serializable;

/**
 * menu
 *
 * @author
 */
@Data
public class RoleMenuPo implements Serializable {
    /**
     * 业务角色ID
     */
    private String roleId;

    /**
     * 菜单ID
     */
    private String menuId;


    private static final long serialVersionUID = 1L;
}
