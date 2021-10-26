package top.fqq.familytree.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.fqq.familytree.bean.MessageResult;
import top.fqq.familytree.bean.dto.area.AreaDto;
import top.fqq.familytree.bean.vo.AreaVo;
import top.fqq.familytree.service.IAreaService;

import java.util.List;

/**
 * @author fitch
 * @date 2021/10/26 10:48
 */
@RestController
@RequestMapping("/api/area")
public class AreaController {

    @Autowired
    private IAreaService areaService;

    /**
     * 获取所有省份
     *
     * @return
     */
    @PostMapping("/getProvinceList")
    public MessageResult<List<AreaVo>> getProvinceList() {
        List<AreaVo> areaVos = areaService.getProvinceList();
        return MessageResult.success(areaVos);
    }

    /**
     * 获取所有省份
     *
     * @return
     */
    @PostMapping("/getList")
    public MessageResult<List<AreaVo>> getList(@RequestBody AreaDto areaDto) {
        List<AreaVo> areaVos = areaService.getList(areaDto);
        return MessageResult.success(areaVos);
    }
}
