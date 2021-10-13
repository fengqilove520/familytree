package top.fqq.familytree.dao;

import org.apache.ibatis.annotations.Mapper;
import top.fqq.familytree.bean.dto.user.UserListDto;
import top.fqq.familytree.bean.po.UserPo;
import top.fqq.familytree.bean.vo.UserVo;

import java.util.List;

@Mapper
public interface UserDao {
    int deleteByPrimaryKey(String id);

    int insert(UserPo record);

    int insertSelective(UserPo record);

    UserPo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(UserPo record);

    int updateByPrimaryKey(UserPo record);

    /**
     * 列表查询
     *
     * @param userListDto
     * @return
     */
    List<UserVo> select(UserListDto userListDto);
}
