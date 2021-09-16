package top.fqq.familytree.bean.dto;

/**
 * @author fitch
 * @date 2021/9/16 13:34
 */
public class BaseDto {

    private Integer pageNum;

    private Integer pageSize;

    public Integer getPageNum() {
        return pageNum==null?0:pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize==null?0:pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
