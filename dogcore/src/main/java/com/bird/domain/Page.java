package com.bird.domain;

import lombok.Data;

/**
 * author: 牛虻.
 * time:2018/1/29
 * email:pettygadfly@gmail.com
 * doc:
 */
@Data
public class Page extends Log {


    //当前需要显示的页码
    private int currentPage;

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
    //每页条数
    private int rowPage = 15;

    //开始行,start with 0
    private int startRow;
    //结束行
    private int endRow;
}
