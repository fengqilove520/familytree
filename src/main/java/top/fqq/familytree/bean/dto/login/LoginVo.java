package top.fqq.familytree.bean.dto.login;

import lombok.Data;

import java.io.Serializable;

/**
 * @author fitch
 * @date 2021/9/17 17:08
 */
@Data
public class LoginVo implements Serializable {
    private String token;
}

