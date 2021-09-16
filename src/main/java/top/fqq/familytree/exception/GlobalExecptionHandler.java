package top.fqq.familytree.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import top.fqq.familytree.bean.ErrorCodeEnum;
import top.fqq.familytree.bean.MessageResult;

/**
 * 全局异常处理
 * @author fitch
 * @date 2021/9/15 14:18
 */
@Slf4j
@ResponseBody
@ControllerAdvice
public class GlobalExecptionHandler {

    @ExceptionHandler(value = Exception.class)
    public MessageResult<Object> errorHandle(Exception e) {
        log.error(e.getMessage(), e);
        MessageResult<Object> result = new MessageResult<>();
        result.setCode(ErrorCodeEnum.ERROR.getCode());
        result.setMsg(ErrorCodeEnum.ERROR.getMsg());
        return result;
    }

    @ExceptionHandler(value = BizException.class)
    public MessageResult<Object> errorHandle(BizException e) {
        MessageResult<Object> result = new MessageResult<>();
        result.setCode(e.getCode());
        result.setMsg(e.getMessage());
        return result;
    }

}
