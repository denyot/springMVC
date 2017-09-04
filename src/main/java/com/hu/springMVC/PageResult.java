package com.hu.springMVC;

import lombok.Data;

import java.util.List;
@Data
public class PageResult {
    private Integer total;
    private List result;
    public PageResult(Integer total, List result) {
        this.total = total;
        this.result = result;
    }
}
