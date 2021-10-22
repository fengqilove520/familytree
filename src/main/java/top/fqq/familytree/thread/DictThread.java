package top.fqq.familytree.thread;

import lombok.Data;
import top.fqq.familytree.bean.vo.DictVo;
import top.fqq.familytree.dao.IDictDao;

import java.util.List;

/**
 * @author fitch
 * @date 2021/10/18 17:58
 */
@Data
public class DictThread extends Thread {

    private IDictDao dictDao;

    private List<String> types;

    private List<DictVo> dictVos;

    @Override
    public void run() {
        dictVos = dictDao.getDictListByTypes(types);
    }
}
