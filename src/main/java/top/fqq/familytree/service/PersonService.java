package top.fqq.familytree.service;

import top.fqq.familytree.bean.vo.PersonVo;

public interface PersonService {

    /**
     * 查询人员详情
     * @return
     */
    PersonVo getById(String id);
}
