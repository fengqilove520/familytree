package top.fqq.familytree.service.impl;

import cn.hutool.core.bean.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.fqq.familytree.bean.dto.role.RoleDto;
import top.fqq.familytree.bean.po.RolePo;
import top.fqq.familytree.dao.RoleDao;
import top.fqq.familytree.service.RoleService;
import top.fqq.familytree.util.IdUtil;
import top.fqq.familytree.util.StringUtil;

/**
 * @author fitch
 * @date 2021/10/12 15:09
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao dao;

    @Override
    public Integer save(RoleDto roleDto) {
        Integer result;
        if (StringUtil.isEmpty(roleDto.getId())) {
            result = this.insert(roleDto);
        } else {
            result = this.update(roleDto);
        }
        return result;
    }

    @Override
    public Integer insert(RoleDto roleDto) {
        RolePo rolePo = new RolePo();
        BeanUtil.copyProperties(roleDto, rolePo);
        rolePo.setId(IdUtil.generate());
        Integer result = dao.insert(rolePo);
        return result;
    }

    @Override
    public Integer update(RoleDto roleDto) {
        RolePo rolePo = new RolePo();
        BeanUtil.copyProperties(roleDto, rolePo);
        Integer result = dao.updateByPrimaryKey(rolePo);
        return result;
    }

    @Override
    public Integer delete(RoleDto roleDto) {
        Integer result = dao.deleteByPrimaryKey(roleDto.getId());
        return result;
    }
}
