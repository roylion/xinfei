package cn.roylion.pro.xinfei.pojo.dto;

/**
 * @Author: Roylion
 * @Description:
 * @Date: Created in 17:16 2018/11/15
 */
public class BaseDto {

    protected Integer pageNum;
    protected Integer pageSize;

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
