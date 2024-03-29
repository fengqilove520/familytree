package top.fqq.familytree.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.fqq.familytree.bean.MessageResult;
import top.fqq.familytree.bean.dto.login.LoginDto;
import top.fqq.familytree.bean.dto.login.LoginVo;
import top.fqq.familytree.service.IUserService;

import javax.servlet.http.HttpServletResponse;

/**
 * @author fitch
 * @date 2021/9/17 17:06
 */
@RestController
@RequestMapping("/api/login")
public class LoginController {

    @Autowired
    private IUserService userService;

    @PostMapping("/igAuth/login")
    public MessageResult<String> login(@RequestBody LoginDto loginDto, HttpServletResponse response) {
        LoginVo loginVo = new LoginVo();
        String token = userService.authUser(loginDto, response);
        loginVo.setToken(token);
        return MessageResult.success(loginVo);
    }

    @PostMapping("/logout")
    public MessageResult<String> logout(HttpServletResponse httpServletResponse) {
        userService.logout(httpServletResponse);
        return MessageResult.success("退出成功！");
    }


}
