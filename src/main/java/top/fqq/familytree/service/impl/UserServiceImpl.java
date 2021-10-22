package top.fqq.familytree.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.fqq.familytree.bean.ErrorCodeEnum;
import top.fqq.familytree.bean.UserClaim;
import top.fqq.familytree.bean.dto.login.LoginDto;
import top.fqq.familytree.bean.dto.user.UserDto;
import top.fqq.familytree.bean.dto.user.UserListDto;
import top.fqq.familytree.bean.po.UserPo;
import top.fqq.familytree.bean.vo.MenuVo;
import top.fqq.familytree.bean.vo.RoleVo;
import top.fqq.familytree.bean.vo.UserVo;
import top.fqq.familytree.dao.IUserDao;
import top.fqq.familytree.exception.BizException;
import top.fqq.familytree.service.IMenuService;
import top.fqq.familytree.service.IRoleService;
import top.fqq.familytree.service.IUserService;
import top.fqq.familytree.util.HttpUtil;
import top.fqq.familytree.util.IdUtil;
import top.fqq.familytree.util.JwtUtil;
import top.fqq.familytree.util.StringUtil;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author fitch
 * @date 2021/10/12 15:09
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao dao;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private IMenuService menuService;

    @Autowired
    private IRoleService roleService;

    @Override
    public Integer save(UserDto userDto) {
        Integer result;
        if (StringUtil.isEmpty(userDto.getId())) {
            result = this.insert(userDto);
        } else {
            result = this.update(userDto);
        }
        return result;
    }

    @Override
    public Integer insert(UserDto userDto) {
        UserPo userPo = new UserPo();
        BeanUtil.copyProperties(userDto, userPo);
        userPo.setId(IdUtil.generate());
        Integer result = dao.insert(userPo);
        return result;
    }

    @Override
    public Integer update(UserDto userDto) {
        UserPo userPo = new UserPo();
        BeanUtil.copyProperties(userDto, userPo);
        Integer result = dao.updateByPrimaryKey(userPo);
        return result;
    }

    @Override
    public Integer delete(UserDto userDto) {
        Integer result = dao.deleteByPrimaryKey(userDto.getId());
        return result;
    }

    @Override
    public PageInfo<UserVo> getPageList(UserListDto userListDto) {
        PageHelper.startPage(userListDto);
        List<UserVo> userVos = dao.select(userListDto);
        PageInfo<UserVo> pageInfo = new PageInfo<>(userVos);
        return pageInfo;
    }

    @Override
    public UserVo getUserById(String userId) {
        UserVo userVo = dao.selectByPrimaryKey(userId);
        return userVo;
    }

    @Override
    public String authUser(LoginDto loginDto, HttpServletResponse response) {
        UserVo userVo = dao.authUser(loginDto);
        if (null != userVo) {
            UserClaim userClaim = new UserClaim(userVo.getName(), userVo.getFullName());
            String token = jwtUtil.createToken(userVo.getId(), userClaim);
            HttpUtil.writeCookie(response, HttpUtil.TOKEN, token);
            return token;
        }
        throw new BizException(ErrorCodeEnum.USER_ERROR.getCode(), ErrorCodeEnum.USER_ERROR.getMsg());
    }

    @Override
    public void logout(HttpServletResponse response) {
        HttpUtil.writeCookie(response, HttpUtil.TOKEN, null);
    }

    @Override
    public UserVo getAuthByUserId(String userId) {
        UserVo userVo = this.getUserById(userId);
        List<RoleVo> roleVos = roleService.getListByUser(userId);
        userVo.setRoles(roleVos);
        List<MenuVo> menuVos = menuService.getMenuTreeByUser(userId);
        userVo.setMenus(menuVos);
        return userVo;
    }
}
