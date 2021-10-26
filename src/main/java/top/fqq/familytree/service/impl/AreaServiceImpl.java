package top.fqq.familytree.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.fqq.familytree.bean.SysConst;
import top.fqq.familytree.bean.dto.area.AreaDto;
import top.fqq.familytree.bean.vo.AreaVo;
import top.fqq.familytree.dao.IAreaDao;
import top.fqq.familytree.service.IAreaService;

import java.util.List;

/**
 * @author fitch
 * @date 2021/10/26 10:49
 */
@Service
public class AreaServiceImpl implements IAreaService {

    @Autowired
    private IAreaDao dao;

    @Override
    public List<AreaVo> getProvinceList() {
        AreaDto areaDto = new AreaDto();
        areaDto.setPcode(SysConst.ROOT_VALUE);
        List<AreaVo> areaVos = dao.getList(areaDto);
        return areaVos;
    }

    @Override
    public List<AreaVo> getList(AreaDto areaDto) {
        List<AreaVo> areaVos = dao.getList(areaDto);
        return areaVos;
    }
}
