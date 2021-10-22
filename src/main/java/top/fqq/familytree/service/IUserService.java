package top.fqq.familytree.service;

import com.github.pagehelper.PageInfo;
import top.fqq.familytree.bean.dto.login.LoginDto;
import top.fqq.familytree.bean.dto.user.UserDto;
import top.fqq.familytree.bean.dto.user.UserListDto;
import top.fqq.familytree.bean.vo.UserVo;

import javax.servlet.http.HttpServletResponse;

/**
 * @author fitch
 * @date 2021/10/12 14:46
 */
public interface IUserService {

    /**
     * 保存
     *
     * @param userDto
     * @return
     */
    Integer save(UserDto userDto);

    /**
     * 新增
     *
     * @param userDto
     * @return
     */
    Integer insert(UserDto userDto);

    /**
     * 修改
     *
     * @param userDto
     * @return
     */
    Integer update(UserDto userDto);

    /**
     * 删除
     *
     * @param userDto
     * @return
     */
    Integer delete(UserDto userDto);

    /**
     * 查询用户分页数据
     *
     * @param userListDto
     * @return
     */
    PageInfo<UserVo> getPageList(UserListDto userListDto);

    /**
     * 查询用户详情
     *
     * @param userId
     * @return
     */
    UserVo getUserById(String userId);

    /**
     * 验证用户登录
     *
     * @param loginDto
     * @return
     */
    String authUser(LoginDto loginDto, HttpServletResponse response);

    /**
     * 退出
     *
     * @param httpServletResponse
     * @return
     */
    void logout(HttpServletResponse httpServletResponse);

    /**
     * 查询用户权限
     *
     * @param userId
     * @return
     */
    UserVo getAuthByUserId(String userId);
}
