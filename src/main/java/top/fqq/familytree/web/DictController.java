package top.fqq.familytree.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.fqq.familytree.bean.MessageResult;
import top.fqq.familytree.bean.vo.DictVo;
import top.fqq.familytree.service.DictService;

import java.util.List;

/**
 * @author fitch
 * @date 2021/9/15 14:13
 */
@RestController
@RequestMapping("/api/dict")
public class DictController {

    @Autowired
    private DictService dictService;


    /**
     * 根据字典类型查询字典列表
     *
     * @param types
     * @return
     */
    @PostMapping("/getDictListByTypes")
    public MessageResult<List<DictVo>> getDictListByTypes(@RequestBody List<String> types) {
        List<DictVo> dictVos = dictService.getDictListByTypes(types);
        return MessageResult.success(dictVos);
    }
}
