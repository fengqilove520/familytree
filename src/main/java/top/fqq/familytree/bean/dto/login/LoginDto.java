package top.fqq.familytree.bean.dto.login;

import lombok.Data;

import java.io.Serializable;

/**
 * @author fitch
 * @date 2021/9/17 17:08
 */
@Data
public class LoginDto implements Serializable {

    private static final long serialVersionUID = -1242493306307174690L;
    private String username;

    private String password;
}
