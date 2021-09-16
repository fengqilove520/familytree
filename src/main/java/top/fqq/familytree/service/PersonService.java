package top.fqq.familytree.service;

import com.github.pagehelper.PageInfo;
import top.fqq.familytree.bean.dto.person.PersonListDto;
import top.fqq.familytree.bean.vo.PersonVo;

public interface PersonService {

    /**
     * 查询人员详情
     * @return
     */
    PersonVo getById(String id);

    /**
     * 查询分页数据
     * @param personListDto
     * @return
     */
    PageInfo<PersonVo> getPageList(PersonListDto personListDto);
}