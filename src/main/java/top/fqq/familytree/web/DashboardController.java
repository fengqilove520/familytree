package top.fqq.familytree.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.fqq.familytree.bean.MessageResult;
import top.fqq.familytree.bean.dto.login.LoginVo;
import top.fqq.familytree.service.IUserService;

/**
 * @author fitch
 * @date 2021/10/22 10:20
 */
@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {

    @Autowired
    private IUserService userService;

    /**
     * 获取人员数量统计
     *
     * @return
     */
    @PostMapping("/getPersonnelStatistics")
    public MessageResult<String> getPersonnelStatistics() {
        LoginVo loginVo = new LoginVo();
        return MessageResult.success(loginVo);
    }
}
