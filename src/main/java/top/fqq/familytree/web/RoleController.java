package top.fqq.familytree.web;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.fqq.familytree.bean.ErrorCodeEnum;
import top.fqq.familytree.bean.MessageResult;
import top.fqq.familytree.bean.dto.role.RoleDto;
import top.fqq.familytree.bean.dto.role.RoleListDto;
import top.fqq.familytree.bean.vo.RoleVo;
import top.fqq.familytree.service.IRoleService;

/**
 * @author fitch
 * @date 2021/9/19 13:46
 */
@RestController
@RequestMapping("/api/role")
public class RoleController {

    @Autowired
    private IRoleService roleService;

    /**
     * 保存
     *
     * @param roleDto
     * @return
     */
    @PostMapping("save")
    public MessageResult save(@RequestBody RoleDto roleDto) {
        Integer result = roleService.save(roleDto);
        return new MessageResult<>(ErrorCodeEnum.SUCCESS, result);
    }

    @PostMapping("getPage")
    public MessageResult<PageInfo<RoleVo>> getPage(@RequestBody RoleListDto roleListDto) {
        PageInfo<RoleVo> pageInfo = roleService.getPageList(roleListDto);
        return MessageResult.success(pageInfo);
    }


    @PostMapping("delete")
    public MessageResult<PageInfo<Integer>> delete(@RequestBody RoleDto roleDto) {
        Integer result = roleService.delete(roleDto);
        return MessageResult.success(result);
    }
}
