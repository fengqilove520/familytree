package top.fqq.familytree.dao;

import org.apache.ibatis.annotations.Mapper;
import top.fqq.familytree.bean.dto.menu.MenuListDto;
import top.fqq.familytree.bean.po.MenuPo;
import top.fqq.familytree.bean.vo.MenuVo;

import java.util.List;

@Mapper
public interface MenuDao {
    int deleteByPrimaryKey(String id);

    int insert(MenuPo record);

    int insertSelective(MenuPo record);

    MenuVo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(MenuPo record);

    int updateByPrimaryKey(MenuPo record);

    /**
     * 查询
     *
     * @param userListDto
     * @return
     */
    List<MenuVo> select(MenuListDto userListDto);

    /**
     * 查询用户权限内的菜单
     *
     * @param userId
     * @return
     */
    List<MenuVo> getMenuByUser(String userId);
}
