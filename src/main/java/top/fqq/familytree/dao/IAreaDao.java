package top.fqq.familytree.dao;

import org.apache.ibatis.annotations.Mapper;
import top.fqq.familytree.bean.dto.area.AreaDto;
import top.fqq.familytree.bean.vo.AreaVo;

import java.util.List;

@Mapper
public interface IAreaDao {

    /**
     * 获取列表
     *
     * @return
     */
    List<AreaVo> getList(AreaDto areaDto);
}
