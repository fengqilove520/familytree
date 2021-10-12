package top.fqq.familytree.service.impl;

import cn.hutool.core.bean.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.fqq.familytree.bean.dto.user.UserDto;
import top.fqq.familytree.bean.po.UserPo;
import top.fqq.familytree.dao.UserDao;
import top.fqq.familytree.service.UserService;
import top.fqq.familytree.util.IdUtil;
import top.fqq.familytree.util.StringUtil;

/**
 * @author fitch
 * @date 2021/10/12 15:09
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao dao;

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
}
