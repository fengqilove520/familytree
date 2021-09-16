package top.fqq.familytree.dao;

import org.apache.ibatis.annotations.Mapper;
import top.fqq.familytree.bean.po.PersonPo;

@Mapper
public interface PersonDao {

    int deleteByPrimaryKey(String id);

    int insert(PersonPo record);

    int insertSelective(PersonPo record);

    PersonPo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(PersonPo record);

    int updateByPrimaryKey(PersonPo record);
}
