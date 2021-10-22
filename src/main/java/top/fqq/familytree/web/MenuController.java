package top.fqq.familytree.web;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.fqq.familytree.bean.ErrorCodeEnum;
import top.fqq.familytree.bean.MessageResult;
import top.fqq.familytree.bean.Subject;
import top.fqq.familytree.bean.SubjectContext;
import top.fqq.familytree.bean.dto.menu.MenuDto;
import top.fqq.familytree.bean.dto.menu.MenuListDto;
import top.fqq.familytree.bean.vo.MenuVo;
import top.fqq.familytree.service.IMenuService;

import java.util.List;

/**
 * @author fitch
 * @date 2021/9/19 13:46
 */
@RestController
@RequestMapping("/api/menu")
public class MenuController {

    @Autowired
    private IMenuService menuService;

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

    @PostMapping("getList")
    public MessageResult<List<MenuVo>> getList(@RequestBody MenuListDto userListDto) {
        Subject subject = SubjectContext.get();
        userListDto.setUserId(subject.getUserId());
        List<MenuVo> menuVoList = menuService.getList(userListDto);
        return MessageResult.success(menuVoList);
    }


    @PostMapping("delete")
    public MessageResult<PageInfo<Integer>> delete(@RequestBody MenuDto menuDto) {
        Integer result = menuService.delete(menuDto);
        return MessageResult.success(result);
    }

    /**
     * 用户菜单树
     *
     * @return
     */
    @PostMapping("getMenuTreeByUser")
    public MessageResult getMenuTreeByUser() {
        Subject subject = SubjectContext.get();
        List<MenuVo> menuVoList = menuService.getMenuTreeByUser(subject.getUserId());
        return new MessageResult<>(ErrorCodeEnum.SUCCESS, menuVoList);
    }

    /**
     * 用户菜单列表
     *
     * @return
     */
    @PostMapping("getMenuListByUser")
    public MessageResult getMenuListByUser() {
        Subject subject = SubjectContext.get();
        List<MenuVo> menuVoList = menuService.getMenuListByUser(subject.getUserId());
        return new MessageResult<>(ErrorCodeEnum.SUCCESS, menuVoList);
    }

}
