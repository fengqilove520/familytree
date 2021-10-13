package top.fqq.familytree.dao;

import org.apache.ibatis.annotations.Mapper;
import top.fqq.familytree.bean.po.UserMenuPo;

@Mapper
public interface UserMenuDao {
    int deleteByPrimaryKey(String id);

    int insert(UserMenuPo record);

    int insertSelective(UserMenuPo record);

}
