package top.fqq.familytree.web;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.fqq.familytree.bean.ErrorCodeEnum;
import top.fqq.familytree.bean.MessageResult;
import top.fqq.familytree.bean.dto.menu.MenuDto;
import top.fqq.familytree.bean.dto.menu.MenuListDto;
import top.fqq.familytree.bean.vo.MenuVo;
import top.fqq.familytree.service.MenuService;

/**
 * @author fitch
 * @date 2021/9/19 13:46
 */
@RestController
@RequestMapping("/api/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    /**
     * 保存
     *
     * @param menuDto
     * @return
     */
    @PostMapping("save")
    public MessageResult save(@RequestBody MenuDto menuDto) {
        Integer result = menuService.save(menuDto);
        return new MessageResult<>(ErrorCodeEnum.SUCCESS, result);
    }

    @PostMapping("getPage")
    public MessageResult<PageInfo<MenuVo>> getPage(@RequestBody MenuListDto userListDto) {
        PageInfo<MenuVo> pageInfo = menuService.getPageList(userListDto);
        return MessageResult.success(pageInfo);
    }


    @PostMapping("delete")
    public MessageResult<PageInfo<Integer>> delete(@RequestBody MenuDto menuDto) {
        Integer result = menuService.delete(menuDto);
        return MessageResult.success(result);
    }
}
