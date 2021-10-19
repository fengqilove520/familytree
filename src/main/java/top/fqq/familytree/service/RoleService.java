package top.fqq.familytree.service;

import com.github.pagehelper.PageInfo;
import top.fqq.familytree.bean.dto.role.RoleDto;
import top.fqq.familytree.bean.dto.role.RoleListDto;
import top.fqq.familytree.bean.vo.RoleVo;

import java.util.List;

/**
 * @author fitch
 * @date 2021/10/12 14:46
 */
public interface RoleService {

    /**
     * 保存
     *
     * @param roleDto
     * @return
     */
    Integer save(RoleDto roleDto);

    /**
     * 新增
     *
     * @param roleDto
     * @return
     */
    Integer insert(RoleDto roleDto);

    /**
     * 修改
     *
     * @param roleDto
     * @return
     */
    Integer update(RoleDto roleDto);

    /**
     * 删除
     *
     * @param roleDto
     * @return
     */
    Integer delete(RoleDto roleDto);

    /**
     * 分页查询
     *
     * @param roleListDto
     * @return
     */
    PageInfo<RoleVo> getPageList(RoleListDto roleListDto);

    /**
     * 查询用户角色信息
     *
     * @param userId
     * @return
     */
    List<RoleVo> getListByUser(String userId);
}
