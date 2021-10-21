package top.fqq.familytree.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.fqq.familytree.bean.SysConst;
import top.fqq.familytree.bean.dto.menu.MenuDto;
import top.fqq.familytree.bean.dto.menu.MenuListDto;
import top.fqq.familytree.bean.po.MenuPo;
import top.fqq.familytree.bean.vo.MenuVo;
import top.fqq.familytree.bean.vo.UserVo;
import top.fqq.familytree.dao.MenuDao;
import top.fqq.familytree.service.MenuService;
import top.fqq.familytree.service.UserService;
import top.fqq.familytree.util.IdUtil;
import top.fqq.familytree.util.StringUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

/**
 * @author fitch
 * @date 2021/10/12 15:09
 */
@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuDao dao;

    @Autowired
    private UserService userService;

    @Override
    public Integer save(MenuDto menuDto) {
        Integer result;
        if (StringUtil.isEmpty(menuDto.getId())) {
            result = this.insert(menuDto);
        } else {
            result = this.update(menuDto);
        }
        return result;
    }

    @Override
    public Integer insert(MenuDto menuDto) {
        MenuPo menuPo = new MenuPo();
        BeanUtil.copyProperties(menuDto, menuPo);
        menuPo.setId(IdUtil.generate());
        Integer result = dao.insert(menuPo);
        return result;
    }

    @Override
    public Integer update(MenuDto menuDto) {
        MenuPo menuPo = new MenuPo();
        BeanUtil.copyProperties(menuDto, menuPo);
        Integer result = dao.updateByPrimaryKey(menuPo);
        return result;
    }

    @Override
    public Integer delete(MenuDto menuDto) {
        Integer result = dao.deleteByPrimaryKey(menuDto.getId());
        return result;
    }

    @Override
    public PageInfo<MenuVo> getPageList(MenuListDto userListDto) {
        PageHelper.startPage(userListDto);
        List<MenuVo> userVos = dao.select(userListDto);
        PageInfo<MenuVo> pageInfo = new PageInfo<>(userVos);
        return pageInfo;
    }

    @Override
    public List<MenuVo> getMenuTreeByUser(String userId) {
        List<MenuVo> menuVoList = this.getMenuByUser(userId);
        menuVoList.forEach(item -> {
            if (StringUtil.isEmpty(item.getPid())) {
                item.setPid(SysConst.ROOT_VALUE);
            }
        });
        menuVoList = this.createTree(SysConst.ROOT_VALUE, menuVoList.stream().collect(groupingBy(MenuVo::getPid)));
        return menuVoList;
    }

    @Override
    public List<MenuVo> getList(MenuListDto userListDto) {
        List<MenuVo> menuVoList = this.getMenuTreeByUser(userListDto.getUserId());
        return menuVoList;
    }

    @Override
    public List<MenuVo> getMenuListByUser(String userId) {
        return this.getMenuByUser(userId);
    }

    private List<MenuVo> getMenuByUser(String userId) {
        UserVo userVo = userService.getUserById(userId);
        List<MenuVo> menuVoList;
        if (SysConst.SUPER_ADMIN_CODE.equals(userVo.getType())) {
            menuVoList = dao.select(new MenuListDto());
        } else {
            menuVoList = dao.getMenuByUser(userId);
        }
        return menuVoList;
    }

    private List<MenuVo> createTree(String pid, Map<String, List<MenuVo>> map) {
        return Optional.ofNullable(map.get(pid)).orElseGet(() -> new ArrayList<>()).stream().filter(item -> item.getPid().equals(pid)).map(item -> {
            MenuVo menuVo = new MenuVo();
            BeanUtil.copyProperties(item, menuVo);
            menuVo.setChildren(createTree(item.getId(), map));
            return menuVo;
        }).collect(Collectors.toList());
    }
}
