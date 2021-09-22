package top.fqq.familytree.dao;

import org.apache.ibatis.annotations.Mapper;
import top.fqq.familytree.bean.dto.dict.DictCodeDto;
import top.fqq.familytree.bean.dto.dict.DictPageDto;
import top.fqq.familytree.bean.po.DictPo;
import top.fqq.familytree.bean.vo.DictCodeVo;
import top.fqq.familytree.bean.vo.DictTypeVo;
import top.fqq.familytree.bean.vo.DictVo;

import java.util.List;

@Mapper
public interface DictDao {

    int deleteByPrimaryKey(String id);

    int insert(DictPo record);

    int insertSelective(DictPo record);

    DictVo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DictPo record);

    int updateByPrimaryKey(DictPo record);

    /**
     * 根据 类型集合查询字典数据
     *
     * @param types
     * @return
     */
    List<DictVo> getDictListByTypes(List<String> types);

    /**
     * 列表查询
     *
     * @param dictPageDto
     * @return
     */
    List<DictVo> select(DictPageDto dictPageDto);

    /**
     * 列表查询
     *
     * @return
     */
    List<DictTypeVo> selectType();

    /**
     * 根据类型查询字典值
     *
     * @param dictCodeDto
     * @return
     */
    List<DictCodeVo> getCodeList(DictCodeDto dictCodeDto);
}
