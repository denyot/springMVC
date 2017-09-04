package com.hu.springMVC.one2many;

import java.util.List;

public interface EmployeeMapper {
    void save(Employee employee);

    void delete(Long id);

    void update(Employee employee);

    Employee get(Long id);

    List<Employee> query();

}
