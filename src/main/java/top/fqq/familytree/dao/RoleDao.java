package top.fqq.familytree.dao;

import org.apache.ibatis.annotations.Mapper;
import top.fqq.familytree.bean.dto.role.RoleListDto;
import top.fqq.familytree.bean.po.RolePo;
import top.fqq.familytree.bean.vo.RoleVo;

import java.util.List;

@Mapper
public interface RoleDao {
    int deleteByPrimaryKey(String id);

    int insert(RolePo record);

    int insertSelective(RolePo record);

    RoleVo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(RolePo record);

    int updateByPrimaryKey(RolePo record);

    /**
     * 分页查询
     *
     * @param roleListDto
     * @return
     */
    List<RoleVo> select(RoleListDto roleListDto);

    /**
     * 查询用户角色信息
     *
     * @param userId
     * @return
     */
    List<RoleVo> getListByUser(String userId);
}
