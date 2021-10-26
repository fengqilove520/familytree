package top.fqq.familytree.service;

import top.fqq.familytree.bean.dto.area.AreaDto;
import top.fqq.familytree.bean.vo.AreaVo;

import java.util.List;

/**
 * @author fitch
 */
public interface IAreaService {

    /**
     * 获取所有省份
     *
     * @return
     */
    List<AreaVo> getProvinceList();

    /**
     * 条件查询区域信息
     *
     * @param areaDto
     * @return
     */
    List<AreaVo> getList(AreaDto areaDto);
}
