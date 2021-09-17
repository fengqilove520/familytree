package top.fqq.familytree.dao;

import org.apache.ibatis.annotations.Mapper;
import top.fqq.familytree.bean.dto.person.PersonListDto;
import top.fqq.familytree.bean.po.PersonPo;
import top.fqq.familytree.bean.vo.PersonVo;

import java.util.List;

@Mapper
public interface PersonDao {

    /**
     * 主键删除
     *
     * @param id
     * @return
     */
    int deleteByPrimaryKey(String id);

    /**
     * 新增
     *
     * @param record
     * @return
     */
    int insert(PersonPo record);

    /**
     * 主键查询
     *
     * @param id
     * @return
     */
    PersonVo selectByPrimaryKey(String id);

    /**
     * 选择更新
     *
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(PersonPo record);

    /**
     * 更新
     *
     * @param record
     * @return
     */
    int updateByPrimaryKey(PersonPo record);

    /**
     * 条件查询
     *
     * @param personListDto
     * @return
     */
    List<PersonVo> select(PersonListDto personListDto);
}
