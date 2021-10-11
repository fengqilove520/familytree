package top.fqq.familytree.bean.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import top.fqq.familytree.annotation.Dict;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author fitch
 * @date 2021/9/16 10:23
 */
@Data
public class PersonVo implements Serializable {

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
    private Integer sex;

    /**
     * 性别
     */
    @Dict(codeFiled = "sex", type = "sex")
    private String sexValue;

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

    /**
     * 子孙
     */
    private List<PersonVo> children;

    /**
     * 配偶
     */
    private List<PersonVo> mate;

    private static final long serialVersionUID = 1L;

    private String imageUrl;
}
