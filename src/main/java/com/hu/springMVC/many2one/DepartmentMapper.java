package com.hu.springMVC.many2one;

public interface DepartmentMapper {
    void save(Department department);

    Department get(Long id);
    ////
}
