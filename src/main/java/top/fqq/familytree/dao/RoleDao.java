package top.fqq.familytree.dao;

import org.apache.ibatis.annotations.Mapper;
import top.fqq.familytree.bean.po.RolePo;

@Mapper
public interface RoleDao {
    int deleteByPrimaryKey(String id);

    int insert(RolePo record);

    int insertSelective(RolePo record);

    RolePo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(RolePo record);

    int updateByPrimaryKey(RolePo record);
}
