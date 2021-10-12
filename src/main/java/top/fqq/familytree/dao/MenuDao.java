package top.fqq.familytree.dao;

import org.apache.ibatis.annotations.Mapper;
import top.fqq.familytree.bean.po.MenuPo;

@Mapper
public interface MenuDao {
    int deleteByPrimaryKey(String id);

    int insert(MenuPo record);

    int insertSelective(MenuPo record);

    MenuPo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(MenuPo record);

    int updateByPrimaryKey(MenuPo record);
}
