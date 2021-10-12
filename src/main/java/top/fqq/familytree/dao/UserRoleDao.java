package top.fqq.familytree.dao;

import top.fqq.familytree.bean.po.UserRolePo;

public interface UserRoleDao {

    int deleteByPrimaryKey(String id);

    int insert(UserRolePo record);

    int insertSelective(UserRolePo record);

    UserRolePo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(UserRolePo record);

    int updateByPrimaryKey(UserRolePo record);
}
