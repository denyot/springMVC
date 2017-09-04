package com.hu.springMVC.one2many;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DepartmentMapper {
    void save(Department department);

    void delete(Long id);

    void updateRelation(@Param("deptId") Long deptId, @Param("emplId") Long emplId);

    Department get(Long id);

    List<Department> query();
    void deleteRelation(Long id);
}
