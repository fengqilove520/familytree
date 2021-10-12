package top.fqq.familytree.dao;

import org.apache.ibatis.annotations.Mapper;
import top.fqq.familytree.bean.po.UserPo;

@Mapper
public interface UserDao {
    int deleteByPrimaryKey(String id);

    int insert(UserPo record);

    int insertSelective(UserPo record);

    UserPo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(UserPo record);

    int updateByPrimaryKey(UserPo record);
}
