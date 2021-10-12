package top.fqq.familytree.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.fqq.familytree.bean.dto.dict.DictCodeDto;
import top.fqq.familytree.bean.dto.dict.DictDto;
import top.fqq.familytree.bean.dto.dict.DictPageDto;
import top.fqq.familytree.bean.po.DictPo;
import top.fqq.familytree.bean.vo.DictCodeVo;
import top.fqq.familytree.bean.vo.DictTypeVo;
import top.fqq.familytree.bean.vo.DictVo;
import top.fqq.familytree.dao.DictDao;
import top.fqq.familytree.service.DictService;
import top.fqq.familytree.util.IdUtil;
import top.fqq.familytree.util.StringUtil;

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

    @Override
    public List<DictTypeVo> getTypeList() {
        List<DictTypeVo> dictTypeVos = dao.selectType();
        return dictTypeVos;
    }

    @Override
    public Integer save(DictDto dictDto) {
        Integer result;
        if (StringUtil.isEmpty(dictDto.getId())) {
            result = this.insert(dictDto);
        } else {
            result = this.update(dictDto);
        }
        return result;
    }

    @Override
    public Integer delete(String id) {
        Integer result = dao.deleteByPrimaryKey(id);
        return result;
    }

    @Override
    public List<DictCodeVo> getCodeList(DictCodeDto dictCodeDto) {
        return dao.getCodeList(dictCodeDto);
    }

    private Integer update(DictDto dictDto) {
        DictPo dictPo = new DictPo();
        BeanUtil.copyProperties(dictDto, dictPo);
        return dao.updateByPrimaryKeySelective(dictPo);
    }

    private Integer insert(DictDto dictDto) {
        DictPo dictPo = new DictPo();
        dictDto.setId(IdUtil.generate());
        dictDto.setDeleted(false);
        BeanUtil.copyProperties(dictDto, dictPo);
        return dao.insert(dictPo);
    }
}
