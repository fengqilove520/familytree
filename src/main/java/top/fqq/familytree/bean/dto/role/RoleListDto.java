package top.fqq.familytree.bean.dto.role;

import lombok.Data;
import top.fqq.familytree.bean.dto.BaseDto;

import java.io.Serializable;

/**
 * menu
 *
 * @author
 */
@Data
public class RoleListDto extends BaseDto implements Serializable {

    /**
     * 角色ID
     */
    private String id;

    /**
     * 名称
     */
    private String name;

    /**
     * 编码
     */
    private String code;

    /**
     * 描述
     */
    private String desc;

    /**
     * 类型
     */
    private Integer type;

    private static final long serialVersionUID = 1L;
}
