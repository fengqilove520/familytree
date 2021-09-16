package top.fqq.familytree.exception;

import lombok.Data;
import top.fqq.familytree.bean.ErrorCodeEnum;

/**
 * @author fitch
 * @date 2021/9/15 14:29
 */
@Data
public class BizException extends RuntimeException {
    /**
     * 错误码
     */
    private Integer code;

    /**
     * 描述
     */
    private String message;

    public BizException() {
        super();
    }

    public BizException(String message) {
        super(message);
        this.code = ErrorCodeEnum.BIZ_ERROR.getCode();
        this.message = message;
    }

    public BizException(Integer code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    /**
     * 直接打印简单信息和异常堆栈
     *
     * @param msg
     * @param exception
     */
    public BizException(String msg, Throwable exception) {
        super(msg);
        exception.printStackTrace();
    }

    /**
     * 直接打印异常堆栈
     *
     * @param exception
     */
    public BizException(Throwable exception) {
        super(exception);
        exception.printStackTrace();
    }

}
