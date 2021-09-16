package top.fqq.familytree.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.fqq.familytree.bean.dto.person.PersonListDto;
import top.fqq.familytree.bean.po.PersonPo;
import top.fqq.familytree.bean.vo.PersonVo;
import top.fqq.familytree.dao.PersonDao;
import top.fqq.familytree.service.PersonService;

import java.util.List;

/**
 * @author fitch
 * @date 2021/9/16 10:20
 */
@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonDao dao;

    @Override
    public PersonVo getById(String id) {
        PersonVo personPo=dao.selectByPrimaryKey(id);
        return null;
    }

    @Override
    public PageInfo<PersonVo> getPageList(PersonListDto personListDto) {
        PageHelper.startPage(1, 5);
        List<PersonVo> personVos =dao.select(personListDto);
        PageInfo<PersonVo> pageInfo =PageInfo.of(personVos);
        return pageInfo;
    }
}
