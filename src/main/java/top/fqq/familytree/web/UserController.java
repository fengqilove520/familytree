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
import top.fqq.familytree.service.IUserService;

/**
 * @author fitch
 * @date 2021/9/19 13:46
 */
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private IUserService userService;

    /**
     * 用户信息
     *
     * @return
     */
    @PostMapping("getAuth")
    public MessageResult<UserVo> getAuth() {
        Subject subject = SubjectContext.get();
        UserVo userVo = userService.getAuthByUserId(subject.getUserId());
        return new MessageResult<>(ErrorCodeEnum.SUCCESS, userVo);
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
