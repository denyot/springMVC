package com.hu.springMVC.many2one;

import com.hu.springMVC.Util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class EmployeeMapperTest {
    @Test
    public void save() throws Exception {
        SqlSession openSession = MyBatisUtil.getSqlSession();
        EmployeeMapper employeeMapper = openSession.getMapper(EmployeeMapper.class);
        DepartmentMapper departmentMapper = openSession.getMapper(DepartmentMapper.class);
        Department department = new Department();
        Employee employee = new Employee();
        department.setName("开发部");
        employee.setName("王五");
        employee.setDept(department);
        departmentMapper.save(department);
        employeeMapper.save(employee);
        openSession.commit();
        openSession.close();
    }

    @Test
    public void delete() throws Exception {
    }

    @Test
    public void update() throws Exception {
    }

    @Test
    public void get() throws Exception {
        SqlSession openSession = MyBatisUtil.getSqlSession();
        EmployeeMapper employeeMapper = openSession.getMapper(EmployeeMapper.class);
        Employee employee = employeeMapper.get(22l);
        System.out.println(employee.getDept());
        openSession.close();
    }

    @Test
    public void query() throws Exception {
        SqlSession openSession = MyBatisUtil.getSqlSession();
        EmployeeMapper employeeMapper = openSession.getMapper(EmployeeMapper.class);
        List<Employee> employeeList = employeeMapper.query();
        for (Employee employee : employeeList) {
            System.out.println(employee.getDept());
        }
        openSession.close();

    }

}