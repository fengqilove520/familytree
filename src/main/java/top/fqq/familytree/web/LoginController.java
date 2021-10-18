package top.fqq.familytree.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.fqq.familytree.bean.MessageResult;
import top.fqq.familytree.bean.dto.login.LoginDto;
import top.fqq.familytree.bean.dto.login.LoginVo;
import top.fqq.familytree.bean.vo.UserVo;
import top.fqq.familytree.service.UserService;

import javax.servlet.http.HttpServletResponse;

/**
 * @author fitch
 * @date 2021/9/17 17:06
 */
@RestController
@RequestMapping("/api/login")
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping("/igAuth/login")
    public MessageResult<String> login(@RequestBody LoginDto loginDto, HttpServletResponse response) {
        LoginVo loginVo = new LoginVo();
        loginVo.setToken(loginDto.getUsername());
        UserVo userVo = userService.authUser(loginDto, response);
        return MessageResult.success(loginVo);
    }

}
