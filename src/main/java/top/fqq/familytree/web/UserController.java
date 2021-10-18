package top.fqq.familytree.web;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.fqq.familytree.bean.ErrorCodeEnum;
import top.fqq.familytree.bean.MessageResult;
import top.fqq.familytree.bean.Subject;
import top.fqq.familytree.bean.SubjectContext;
import top.fqq.familytree.bean.dto.user.UserDto;
import top.fqq.familytree.bean.dto.user.UserListDto;
import top.fqq.familytree.bean.vo.UserVo;
import top.fqq.familytree.service.UserService;

import java.util.HashMap;
import java.util.Map;

/**
 * @author fitch
 * @date 2021/9/19 13:46
 */
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 用户信息
     *
     * @return
     */
    @PostMapping("getDetail")
    public MessageResult getDetail() {
        Subject subject = SubjectContext.get();
        Map<String, Object> userMap = new HashMap<>();
        userMap.put("roles", "admin".split(","));
        userMap.put("introduction", "aI am a super administrator");
        userMap.put("avatar", "https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        userMap.put("name", subject.getFullName());
        return new MessageResult<>(ErrorCodeEnum.SUCCESS, userMap);
    }

    /**
     * 用户信息
     *
     * @param userDto
     * @return
     */
    @PostMapping("save")
    public MessageResult save(@RequestBody UserDto userDto) {
        Integer result = userService.save(userDto);
        return new MessageResult<>(ErrorCodeEnum.SUCCESS, result);
    }

    @PostMapping("getPage")
    public MessageResult<PageInfo<UserVo>> getPage(@RequestBody UserListDto userListDto) {
        PageInfo<UserVo> pageInfo = userService.getPageList(userListDto);
        return MessageResult.success(pageInfo);
    }


    @PostMapping("delete")
    public MessageResult<PageInfo<Integer>> delete(@RequestBody UserDto userDto) {
        Integer result = userService.delete(userDto);
        return MessageResult.success(result);
    }
}
