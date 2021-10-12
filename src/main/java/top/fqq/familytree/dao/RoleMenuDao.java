package top.fqq.familytree.dao;

import top.fqq.familytree.bean.po.RoleMenuPo;

public interface RoleMenuDao {
    int deleteByPrimaryKey(String id);

    int insert(RoleMenuPo record);

    int insertSelective(RoleMenuPo record);

    RoleMenuPo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(RoleMenuPo record);

    int updateByPrimaryKey(RoleMenuPo record);
}
