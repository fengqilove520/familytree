package top.fqq.familytree.web;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.fqq.familytree.bean.MessageResult;
import top.fqq.familytree.exception.FqqException;

/**
 * @author fitch
 * @date 2021/9/15 14:13
 */
@RestController
@RequestMapping("/person")
public class PersonController {

    @PostMapping("test")
    public MessageResult<String> test() throws Exception {
        if(true){
            throw new Exception("测试错误信息");
        }
        return new MessageResult<>();
    }
}
