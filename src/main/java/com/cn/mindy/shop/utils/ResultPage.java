package com.cn.mindy.shop.utils;

import java.util.List;

public class ResultPage {

    private List<?> rows;


    private Integer total;

    public List<?> getRows() {
        return rows;
    }

    public void setRows(List<?> rows) {
        this.rows = rows;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
