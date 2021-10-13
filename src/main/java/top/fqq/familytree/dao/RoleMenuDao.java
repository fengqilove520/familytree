package top.fqq.familytree.dao;

import org.apache.ibatis.annotations.Mapper;
import top.fqq.familytree.bean.po.RoleMenuPo;

@Mapper
public interface RoleMenuDao {
    int deleteByPrimaryKey(String id);

    int insert(RoleMenuPo record);

    int insertSelective(RoleMenuPo record);
}
