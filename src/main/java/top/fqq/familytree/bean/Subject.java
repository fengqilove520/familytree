package top.fqq.familytree.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * @author fitch
 * @date 2021/10/18 14:47
 */
@Data
public class Subject implements Serializable {

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 用户名称
     */
    private String userName;

    /**
     * 用户全称
     */
    private String fullName;


}
