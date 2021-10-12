package top.fqq.familytree.service;

import top.fqq.familytree.bean.dto.role.RoleDto;

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

}
