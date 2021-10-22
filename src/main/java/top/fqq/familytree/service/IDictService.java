package top.fqq.familytree.service;

import com.github.pagehelper.PageInfo;
import top.fqq.familytree.bean.dto.dict.DictCodeDto;
import top.fqq.familytree.bean.dto.dict.DictDto;
import top.fqq.familytree.bean.dto.dict.DictPageDto;
import top.fqq.familytree.bean.vo.DictCodeVo;
import top.fqq.familytree.bean.vo.DictTypeVo;
import top.fqq.familytree.bean.vo.DictVo;

import java.util.List;

/**
 * @author fitch
 */
public interface IDictService {

    /**
     * 根据字典类型查询字典列表
     *
     * @param types
     * @return
     */
    List<DictVo> getDictListByTypes(List<String> types);

    /**
     * 查询分页数据
     *
     * @param dictPageDto
     * @return
     */
    PageInfo<DictVo> getPageList(DictPageDto dictPageDto);

    /**
     * 查询类型列表
     *
     * @return
     */
    List<DictTypeVo> getTypeList();

    /**
     * 保存字典数据
     *
     * @param dictDto
     * @return
     */
    Integer save(DictDto dictDto);

    /**
     * 删除字典数据
     *
     * @param id
     * @return
     */
    Integer delete(String id);

    /**
     * 查询字典数据
     *
     * @param dictCodeDto
     * @return
     */
    List<DictCodeVo> getCodeList(DictCodeDto dictCodeDto);
}
