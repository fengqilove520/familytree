package top.fqq.familytree.service.impl;

import cn.hutool.core.collection.CollUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
}
