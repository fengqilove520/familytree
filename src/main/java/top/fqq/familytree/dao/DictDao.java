package top.fqq.familytree.dao;

import org.apache.ibatis.annotations.Mapper;
import top.fqq.familytree.bean.vo.DictVo;

import java.util.List;

@Mapper
public interface DictDao {

    int deleteByPrimaryKey(String id);

    int insert(DictVo record);

    int insertSelective(DictVo record);

    DictVo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DictVo record);

    int updateByPrimaryKey(DictVo record);

    /**
     * 根据 类型集合查询字典数据
     *
     * @param types
     * @return
     */
    List<DictVo> getDictListByTypes(List<String> types);
}
