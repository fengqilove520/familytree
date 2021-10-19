package top.fqq.familytree.bean;

/**
 * @author fitch
 * @date 2021/9/15 14:22
 */
public enum ErrorCodeEnum {

    SUCCESS("成功", 20000), ERROR("系统异常", 50000), BIZ_ERROR("业务异常", 50001), USER_ERROR("用户名或密码不存在！", 50001),
    TOKEN_ERROR("token解析异常！", 50001), LOGIN_TIMEOUT_ERROR("登录超时，请重新登录", 50001);

    private String msg;

    private Integer code;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    ErrorCodeEnum() {
    }

    ErrorCodeEnum(String msg, Integer code) {
        this.msg = msg;
        this.code = code;
    }
}
