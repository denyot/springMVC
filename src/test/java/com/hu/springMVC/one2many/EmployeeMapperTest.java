package com.hu.springMVC.one2many;

import com.hu.springMVC.Util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class EmployeeMapperTest {
    @Test
    public void save() throws Exception {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
        DepartmentMapper departmentMapper = sqlSession.getMapper(DepartmentMapper.class);
        Employee employee = new Employee();
        Department department = new Department();
        employee.setName("张三");
        department.setName("设计");
        List<Employee> employees = department.getEmployees();
        employees.add(employee);
        employeeMapper.save(employee);
        departmentMapper.save(department);
        for (Employee employee1 : employees) {
            departmentMapper.updateRelation(department.getId(),employee1.getId());
        }
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void delete() throws Exception {
    }

    @Test
    public void update() throws Exception {
    }

    @Test
    public void get() throws Exception {
    }

    @Test
    public void query() throws Exception {
    }

}