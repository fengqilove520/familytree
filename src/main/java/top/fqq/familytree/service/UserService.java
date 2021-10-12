package top.fqq.familytree.service;

import top.fqq.familytree.bean.dto.user.UserDto;

/**
 * @author fitch
 * @date 2021/10/12 14:46
 */
public interface UserService {

    /**
     * 保存
     *
     * @param userDto
     * @return
     */
    Integer save(UserDto userDto);

    /**
     * 新增
     *
     * @param userDto
     * @return
     */
    Integer insert(UserDto userDto);

    /**
     * 修改
     *
     * @param userDto
     * @return
     */
    Integer update(UserDto userDto);

    /**
     * 删除
     *
     * @param userDto
     * @return
     */
    Integer delete(UserDto userDto);

}
