package top.fqq.familytree.web;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.fqq.familytree.bean.ErrorCodeEnum;
import top.fqq.familytree.bean.MessageResult;

import java.util.HashMap;
import java.util.Map;

/**
 * @author fitch
 * @date 2021/9/19 13:46
 */
@RestController
@RequestMapping("/api/user")
public class UserController {

    /**
     * 用户信息
     *
     * @param token
     * @return
     */
    @PostMapping("getDetail")
    public MessageResult getDetail(@RequestBody String token) {
        Map<String, Object> userMap = new HashMap<>();
        userMap.put("roles", "admin".split(","));
        userMap.put("introduction", "aI am a super administrator");
        userMap.put("avatar", "https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        userMap.put("name", "Super Admin");
        return new MessageResult<>(ErrorCodeEnum.SUCCESS, userMap);
    }

}
