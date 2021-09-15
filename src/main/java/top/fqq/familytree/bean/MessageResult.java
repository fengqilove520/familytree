package top.fqq.familytree.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * 返回对象
 * @author fitch
 * @date 2021/9/15 14:20
 */
@Data
public class MessageResult<T>  implements Serializable {

    /**
     * 错误码
     */
    private Integer code;

    /**
     * 描述
     */
    private String msg;

    /**
     * 数据结果
     */
    private T result;
}
