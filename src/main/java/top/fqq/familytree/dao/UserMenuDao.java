package top.fqq.familytree.dao;

import top.fqq.familytree.bean.po.UserMenu;

public interface UserMenuDao {
    int deleteByPrimaryKey(String id);

    int insert(UserMenu record);

    int insertSelective(UserMenu record);

    UserMenu selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(UserMenu record);

    int updateByPrimaryKey(UserMenu record);
}
