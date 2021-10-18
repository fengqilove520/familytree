package top.fqq.familytree.aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.springframework.beans.factory.annotation.Autowired;
import top.fqq.familytree.service.DictService;

import java.util.Arrays;

/**
 * @author fitch
 * @date 2021/9/17 10:07
 */
//@Aspect
//@Configuration
//@Component
public class DictAspect {

    @Autowired
    private DictService dictService;

    @AfterReturning(returning = "result", pointcut = "execution(* top.fqq.familytree.dao.*.*(..))")
    public void doAfterReturing(Object result) {
        dictService.getDictListByTypes(Arrays.asList("sex".split(",")));
        System.out.println("------------------- DictAspect ----------------------");
    }
}
