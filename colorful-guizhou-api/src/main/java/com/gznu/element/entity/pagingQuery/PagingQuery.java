package com.gznu.element.entity.pagingQuery;

import lombok.ToString;

@ToString
public class PagingQuery {
    /**
     * 当前页
     */
    private int currentPage;
    /**
     * 一页多少条记录
     */
    private int pageSize;
    /**
     * 从哪一行开始
     */
    private int startIndex;
    /**
     * 从哪一行结束
     */
    private int endIndex;

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public int getEndIndex() {
        return endIndex;
    }

    public void setEndIndex(int endIndex) {
        this.endIndex = endIndex;
    }

    /**
     * 根据当前所在页数和每页显示记录数计算出startIndex和endIndex
     */
    public void setStartIndexEndIndex() {
        this.startIndex = (this.getCurrentPage() - 1) * this.getPageSize();
        this.endIndex = (this.getCurrentPage() - 1) * this.getPageSize() + this.getPageSize();
    }
}
