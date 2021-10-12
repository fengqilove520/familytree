package top.fqq.familytree.bean.po;

import lombok.Data;

import java.io.Serializable;

/**
 * menu
 *
 * @author
 */
@Data
public class UserRolePo implements Serializable {
    /**
     * 用户ID
     */
    private String userId;

    /**
     * 业务角色ID
     */
    private String roleId;

    private static final long serialVersionUID = 1L;
}
