package com.hu.springMVC;

import lombok.Data;

@Data
public class QueryObject {
    private String keyword;
    private Integer beginPass;
    private Integer endPass;
    private Integer currentPage;
    private Integer pageSize;
    public Integer getStart() {
        return (this.currentPage - 1) * pageSize;
    }
}
