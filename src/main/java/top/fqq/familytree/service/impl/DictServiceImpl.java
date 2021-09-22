package top.fqq.familytree.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.fqq.familytree.bean.dto.dict.DictPageDto;
import top.fqq.familytree.bean.vo.DictVo;
import top.fqq.familytree.dao.DictDao;
import top.fqq.familytree.service.DictService;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fitch
 * @date 2021/9/16 16:34
 */
@Service
public class DictServiceImpl implements DictService {

    @Autowired
    private DictDao dao;

    @Override
    public List<DictVo> getDictListByTypes(List<String> types) {
        List<DictVo> dictVos = new ArrayList<>();
        if (CollUtil.isNotEmpty(types)) {
            dictVos = dao.getDictListByTypes(types);
        }
        return dictVos;
    }

    @Override
    public PageInfo<DictVo> getPageList(DictPageDto dictPageDto) {
        PageHelper.startPage(dictPageDto);
        List<DictVo> personVos = dao.select(dictPageDto);
        PageInfo<DictVo> pageInfo = new PageInfo<>(personVos);
        return pageInfo;
    }
}
