package top.fqq.familytree.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * 返回对象
 *
 * @author fitch
 * @date 2021/9/15 14:20
 */
@Data
public class MessageResult<T> implements Serializable {

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
    private T data;

    public MessageResult() {
    }

    public MessageResult(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public MessageResult(ErrorCodeEnum errorCodeEnum, T data) {
        this.code = errorCodeEnum.getCode();
        this.msg = errorCodeEnum.getMsg();
        this.data = data;
    }

    public static MessageResult success(Object result) {
        return new MessageResult(ErrorCodeEnum.SUCCESS, result);
    }
}
