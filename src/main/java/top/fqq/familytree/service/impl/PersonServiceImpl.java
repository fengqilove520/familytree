package top.fqq.familytree.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.lang.UUID;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.fqq.familytree.bean.dto.person.PersonDeleteDto;
import top.fqq.familytree.bean.dto.person.PersonDto;
import top.fqq.familytree.bean.dto.person.PersonListDto;
import top.fqq.familytree.bean.po.PersonPo;
import top.fqq.familytree.bean.vo.PersonVo;
import top.fqq.familytree.dao.PersonDao;
import top.fqq.familytree.service.PersonService;
import top.fqq.familytree.util.StringUtil;

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
        PersonVo personVo = dao.selectByPrimaryKey(id);
        return personVo;
    }

    @Override
    public PageInfo<PersonVo> getPageList(PersonListDto personListDto) {
        PageHelper.startPage(personListDto);
        List<PersonVo> personVos = dao.select(personListDto);
        PageInfo<PersonVo> pageInfo = new PageInfo<>(personVos);
        return pageInfo;
    }

    @Override
    public Integer save(PersonDto personDto) {
        Integer result;
        if (StringUtil.isEmpty(personDto.getId())) {
            result = this.insert(personDto);
        } else {
            result = this.update(personDto);
        }
        return result;
    }

    private Integer update(PersonDto personDto) {
        PersonPo personPo = new PersonPo();
        BeanUtil.copyProperties(personDto, personPo);
        Integer result = dao.updateByPrimaryKeySelective(personPo);
        return result;
    }

    private Integer insert(PersonDto personDto) {
        PersonPo personPo = new PersonPo();
        personDto.setId(UUID.fastUUID().toString());
        BeanUtil.copyProperties(personDto, personPo);
        Integer result = dao.insert(personPo);
        return result;
    }


    @Override
    public Integer delete(PersonDeleteDto personDeleteDto) {
        Integer result = dao.deleteByPrimaryKey(personDeleteDto.getId());
        return result;
    }

    @Override
    public List<PersonVo> getList(PersonListDto personListDto) {
        List<PersonVo> personVos = dao.select(personListDto);
        return personVos;
    }
}
