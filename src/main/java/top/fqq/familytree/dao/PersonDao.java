package top.fqq.familytree.dao;

import org.apache.ibatis.annotations.Mapper;
import top.fqq.familytree.bean.dto.person.PersonListDto;
import top.fqq.familytree.bean.po.PersonPo;
import top.fqq.familytree.bean.vo.PersonVo;

import java.util.List;

@Mapper
public interface PersonDao {

    int deleteByPrimaryKey(String id);

    int insert(PersonPo record);

    int insertSelective(PersonPo record);

    PersonVo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(PersonPo record);

    int updateByPrimaryKey(PersonPo record);

    /**
     * 条件查询
     * @param personListDto
     * @return
     */
    List<PersonVo> select(PersonListDto personListDto);
}
