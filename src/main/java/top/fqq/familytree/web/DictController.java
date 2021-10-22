package top.fqq.familytree.web;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.fqq.familytree.bean.ErrorCodeEnum;
import top.fqq.familytree.bean.MessageResult;
import top.fqq.familytree.bean.dto.dict.DictCodeDto;
import top.fqq.familytree.bean.dto.dict.DictDto;
import top.fqq.familytree.bean.dto.dict.DictPageDto;
import top.fqq.familytree.bean.vo.DictCodeVo;
import top.fqq.familytree.bean.vo.DictTypeVo;
import top.fqq.familytree.bean.vo.DictVo;
import top.fqq.familytree.service.IDictService;

import java.util.List;

/**
 * @author fitch
 * @date 2021/9/15 14:13
 */
@RestController
@RequestMapping("/api/dict")
public class DictController {

    @Autowired
    private IDictService dictService;


    /**
     * 根据字典类型查询字典列表
     *
     * @param types
     * @return
     */
    @PostMapping("/igAuth/getDictListByTypes")
    public MessageResult<List<DictVo>> getDictListByTypes(@RequestBody List<String> types) {
        List<DictVo> dictVos = dictService.getDictListByTypes(types);
        return MessageResult.success(dictVos);
    }

    /**
     * 根据字典类型查询字典列表
     *
     * @param dictPageDto
     * @return
     */
    @PostMapping("/getPage")
    public MessageResult<PageInfo<DictVo>> getPage(@RequestBody DictPageDto dictPageDto) {
        PageInfo<DictVo> dictVos = dictService.getPageList(dictPageDto);
        return MessageResult.success(dictVos);
    }

    /**
     * 查询类型列表
     *
     * @return
     */
    @PostMapping("/getTypeList")
    public MessageResult<List<DictTypeVo>> getTypeList() {
        List<DictTypeVo> result = dictService.getTypeList();
        return MessageResult.success(result);
    }

    /**
     * 查询类型列表
     *
     * @return
     */
    @PostMapping("/getCodeList")
    public MessageResult<List<DictCodeVo>> getCodeList(@RequestBody DictCodeDto dictCodeDto) {
        List<DictCodeVo> result = dictService.getCodeList(dictCodeDto);
        return MessageResult.success(result);
    }

    @PostMapping("save")
    public MessageResult<Integer> save(@RequestBody DictDto dictDto) {
        Integer result = dictService.save(dictDto);
        return new MessageResult<>(ErrorCodeEnum.SUCCESS, result);
    }

    @PostMapping("delete")
    public MessageResult<Integer> delete(@RequestBody String id) {
        Integer result = dictService.delete(id);
        return new MessageResult<>(ErrorCodeEnum.SUCCESS, result);
    }
}
