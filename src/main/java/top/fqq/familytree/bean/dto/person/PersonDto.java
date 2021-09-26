package top.fqq.familytree.bean.dto.person;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import top.fqq.familytree.bean.dto.BaseDto;

import java.util.Date;

/**
 * @author fitch
 * @date 2021/9/26 16:09
 */
@Data
public class PersonDto extends BaseDto {
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
     * 出生时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date birthTime;

    /**
     * 死亡时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date deathTime;

    /**
     * 父编号
     */
    private String pid;

    /**
     * 配偶编号
     */
    private String mateId;

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
