package top.fqq.familytree.service;

import com.github.pagehelper.PageInfo;
import top.fqq.familytree.bean.dto.menu.MenuDto;
import top.fqq.familytree.bean.dto.menu.MenuListDto;
import top.fqq.familytree.bean.vo.MenuVo;

/**
 * @author fitch
 * @date 2021/10/12 14:46
 */
public interface MenuService {

    /**
     * 保存
     *
     * @param menuDto
     * @return
     */
    Integer save(MenuDto menuDto);

    /**
     * 新增
     *
     * @param menuDto
     * @return
     */
    Integer insert(MenuDto menuDto);

    /**
     * 修改
     *
     * @param menuDto
     * @return
     */
    Integer update(MenuDto menuDto);

    /**
     * 删除
     *
     * @param menuDto
     * @return
     */
    Integer delete(MenuDto menuDto);

    /**
     * 查询分页信息
     *
     * @param userListDto
     * @return
     */
    PageInfo<MenuVo> getPageList(MenuListDto userListDto);
}
