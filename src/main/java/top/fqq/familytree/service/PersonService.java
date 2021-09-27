package top.fqq.familytree.service;

import com.github.pagehelper.PageInfo;
import top.fqq.familytree.bean.dto.person.PersonDeleteDto;
import top.fqq.familytree.bean.dto.person.PersonDto;
import top.fqq.familytree.bean.dto.person.PersonListDto;
import top.fqq.familytree.bean.vo.PersonVo;

import java.util.List;

public interface PersonService {

    /**
     * 查询人员详情
     *
     * @return
     */
    PersonVo getById(String id);

    /**
     * 查询分页数据
     *
     * @param personListDto
     * @return
     */
    PageInfo<PersonVo> getPageList(PersonListDto personListDto);

    /**
     * 保存
     *
     * @param personDto
     * @return
     */
    Integer save(PersonDto personDto);

    /**
     * 删除
     *
     * @param personDeleteDto
     * @return
     */
    Integer delete(PersonDeleteDto personDeleteDto);

    /**
     * 列表查询
     *
     * @param personListDto
     * @return
     */
    List<PersonVo> getList(PersonListDto personListDto);

    /**
     * 查询自己及子孙编号
     *
     * @param id
     * @return
     */
    String getChildIds(String id);

    /**
     * 查询自己及祖先编号
     *
     * @param id
     * @return
     */
    String getParentIds(String id);

    /**
     * 查询子孙
     *
     * @param personListDto
     * @return
     */
    List<PersonVo> getChild(PersonListDto personListDto);

    /**
     * 查询祖先
     *
     * @param personListDto
     * @return
     */
    List<PersonVo> getParent(PersonListDto personListDto);

    /**
     * 查询人员树
     *
     * @return
     */
    List<PersonVo> getTree(PersonListDto personListDto);
}
