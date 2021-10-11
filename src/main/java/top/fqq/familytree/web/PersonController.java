package top.fqq.familytree.web;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.fqq.familytree.bean.ErrorCodeEnum;
import top.fqq.familytree.bean.MessageResult;
import top.fqq.familytree.bean.dto.person.PersonDeleteDto;
import top.fqq.familytree.bean.dto.person.PersonDto;
import top.fqq.familytree.bean.dto.person.PersonListDto;
import top.fqq.familytree.bean.vo.PersonVo;
import top.fqq.familytree.service.PersonService;

import java.util.List;

/**
 * @author fitch
 * @date 2021/9/15 14:13
 */
@RestController
@RequestMapping("/api/person")
public class PersonController {

    @Autowired
    private PersonService personService;


    @PostMapping("getDetail")
    public MessageResult<PersonVo> getDetail(@RequestBody String id) {
        PersonVo personVo = personService.getById(id);
        return new MessageResult<>(ErrorCodeEnum.SUCCESS, personVo);
    }

    @PostMapping("getPage")
    public MessageResult<PageInfo<PersonVo>> getPage(@RequestBody PersonListDto personListDto) {
        PageInfo<PersonVo> pageInfo = personService.getPageList(personListDto);
        return MessageResult.success(pageInfo);
    }

    @PostMapping("save")
    public MessageResult<Integer> save(@RequestBody PersonDto personDto) {
        Integer result = personService.save(personDto);
        return new MessageResult<>(ErrorCodeEnum.SUCCESS, result);
    }

    @PostMapping("delete")
    public MessageResult<Integer> delete(@RequestBody PersonDeleteDto personDeleteDto) {
        Integer result = personService.delete(personDeleteDto);
        return new MessageResult<>(ErrorCodeEnum.SUCCESS, result);
    }

    @PostMapping("getList")
    public MessageResult<List<PersonVo>> getList(@RequestBody PersonListDto personListDto) {
        List<PersonVo> pageInfo = personService.getList(personListDto);
        return MessageResult.success(pageInfo);
    }

    @PostMapping("getChild")
    public MessageResult<List<PersonVo>> getChild(@RequestBody PersonListDto personListDto) {
        List<PersonVo> pageInfo = personService.getChild(personListDto);
        return MessageResult.success(pageInfo);
    }

    @PostMapping("getParent")
    public MessageResult<List<PersonVo>> getParent(@RequestBody PersonListDto personListDto) {
        List<PersonVo> pageInfo = personService.getParent(personListDto);
        return MessageResult.success(pageInfo);
    }

    @PostMapping("getTree")
    public MessageResult<PersonVo> getTree(@RequestBody PersonListDto personListDto) {
        PersonVo personVo = personService.getTree(personListDto);
        return MessageResult.success(personVo);
    }


}
