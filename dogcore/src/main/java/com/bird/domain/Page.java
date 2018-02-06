package com.bird.domain;

import lombok.Data;

/**
 * author: 牛虻.
 * time:2018/1/29
 * email:pettygadfly@gmail.com
 * doc:
 * setCurrentPage,setRowCount在分页显示的时候需要手动设置一次
 */
@Data
public class Page extends Log {


    //当前页码
    private int currentPage;

    //请手动调用一次
    public void setCurrentPage(int currentPage) {
        if (currentPage < 1)
            currentPage = 1;
        this.currentPage = currentPage;
        this.startRow = (currentPage - 1) * rowPage;
        this.endRow = currentPage * rowPage - 1;
    }

    //总页数
    private int pageCount;
    //总行数
    private int rowCount;

    //请手动调用一次
    public void setRowCount(int rowCount) {
        this.rowCount = rowCount;

        int m = rowCount / rowPage; //取整
        int s = rowCount % rowPage;//取余
        pageCount = m + s > 0 ? 1 : 0;
    }
    //每页条数
    private int rowPage = 15;

    //用于查询-------------------------------------------------------------------
    //开始行,start with 0
    private int startRow;
    //结束行
    private int endRow;
}
