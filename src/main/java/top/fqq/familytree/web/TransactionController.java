package top.fqq.familytree.web;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.fqq.familytree.bean.ErrorCodeEnum;
import top.fqq.familytree.bean.MessageResult;
import top.fqq.familytree.bean.vo.PersonVo;

/**
 * @author fitch
 * @date 2021/9/19 13:57
 */
@RestController
@RequestMapping("/api/transaction")
public class TransactionController {

    @PostMapping("list")
    public MessageResult list(@RequestBody String id) {
        PersonVo personVo = new PersonVo();
        return new MessageResult<>(ErrorCodeEnum.SUCCESS, personVo);
    }


}
