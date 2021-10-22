package top.fqq.familytree.dao;

import org.apache.ibatis.annotations.Mapper;
import top.fqq.familytree.bean.po.UserRolePo;

@Mapper
public interface IUserRoleDao {

    int deleteByPrimaryKey(String id);

    int insert(UserRolePo record);

    int insertSelective(UserRolePo record);
}
