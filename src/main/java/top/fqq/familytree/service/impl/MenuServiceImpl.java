package top.fqq.familytree.service.impl;

import cn.hutool.core.bean.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.fqq.familytree.bean.dto.menu.MenuDto;
import top.fqq.familytree.bean.po.MenuPo;
import top.fqq.familytree.dao.MenuDao;
import top.fqq.familytree.service.MenuService;
import top.fqq.familytree.util.IdUtil;
import top.fqq.familytree.util.StringUtil;

/**
 * @author fitch
 * @date 2021/10/12 15:09
 */
@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuDao dao;

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
}
