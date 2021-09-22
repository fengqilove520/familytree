package top.fqq.familytree.web;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.fqq.familytree.bean.ErrorCodeEnum;
import top.fqq.familytree.bean.MessageResult;
import top.fqq.familytree.bean.dto.person.PersonListDto;
import top.fqq.familytree.bean.vo.PersonVo;
import top.fqq.familytree.service.PersonService;

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


    @PostMapping("test")
    public MessageResult<String> test() throws Exception {
        if (true) {
            throw new Exception("测试错误信息");
        }
        return new MessageResult<>();
    }

}
