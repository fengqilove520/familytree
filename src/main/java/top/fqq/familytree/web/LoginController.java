package top.fqq.familytree.web;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.fqq.familytree.bean.MessageResult;
import top.fqq.familytree.bean.dto.login.LoginDto;
import top.fqq.familytree.bean.dto.login.LoginVo;

/**
 * @author fitch
 * @date 2021/9/17 17:06
 */
@RestController
@RequestMapping("/api/login")
public class LoginController {

    @PostMapping("login")
    public MessageResult<String> login(@RequestBody LoginDto loginDto) {
        LoginVo loginVo = new LoginVo();
        loginVo.setToken(loginDto.getUsername());
        return MessageResult.success(loginVo);
    }

}
