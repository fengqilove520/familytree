package top.fqq.familytree.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.fqq.familytree.bean.po.PersonPo;
import top.fqq.familytree.bean.vo.PersonVo;
import top.fqq.familytree.dao.PersonDao;
import top.fqq.familytree.service.PersonService;

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
        PersonPo personPo=dao.selectByPrimaryKey(id);
        return null;
    }
}
