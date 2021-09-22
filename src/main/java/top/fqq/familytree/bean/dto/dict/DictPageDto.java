package top.fqq.familytree.bean.dto.dict;

import lombok.Data;
import top.fqq.familytree.bean.dto.BaseDto;

import java.io.Serializable;
import java.util.Date;

/**
 * @author fitch
 * @date 2021/9/16 16:05
 */
@Data
public class DictPageDto extends BaseDto implements Serializable {

    /**
     * 主键
     */
    private String id;

    /**
     * 编码类型
     */
    private String type;

    /**
     * 编码类型名称
     */
    private String typeName;

    /**
     * 编码
     */
    private String code;

    /**
     * 中文名称
     */
    private String name;

    /**
     * 英文名称
     */
    private String nameEn;

    /**
     * 排序
     */
    private Short orders;

    /**
     * 父编码类型
     */
    private String parType;

    /**
     * 父编码
     */
    private String parCode;

    /**
     * 删除状态(0:未启用;1:已启用)
     */
    private Boolean deleted;

    /**
     * 创建人员ID
     */
    private String createUser;

    /**
     * 创建时间,默认当前时间
     */
    private Date createTime;

    private static final long serialVersionUID = 1L;

}
