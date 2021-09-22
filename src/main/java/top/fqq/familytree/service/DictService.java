package top.fqq.familytree.service;

import com.github.pagehelper.PageInfo;
import top.fqq.familytree.bean.dto.dict.DictPageDto;
import top.fqq.familytree.bean.vo.DictVo;

import java.util.List;

/**
 * @author fitch
 */
public interface DictService {

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
}
