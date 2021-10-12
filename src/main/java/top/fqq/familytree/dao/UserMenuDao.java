package top.fqq.familytree.dao;

import org.apache.ibatis.annotations.Mapper;
import top.fqq.familytree.bean.po.UserMenu;

@Mapper
public interface UserMenuDao {
    int deleteByPrimaryKey(String id);

    int insert(UserMenu record);

    int insertSelective(UserMenu record);

    UserMenu selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(UserMenu record);

    int updateByPrimaryKey(UserMenu record);
}
