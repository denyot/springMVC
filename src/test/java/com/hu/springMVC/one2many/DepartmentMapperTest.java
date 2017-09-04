package com.hu.springMVC.one2many;

import com.hu.springMVC.Util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class DepartmentMapperTest {
    @Test
    public void save() throws Exception {
    }

    @Test
    public void delete() throws Exception {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        DepartmentMapper mapper = sqlSession.getMapper(DepartmentMapper.class);
        mapper.deleteRelation(29l);
        mapper.delete(29l);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void updateRelation() throws Exception {
    }

    @Test
    public void get() throws Exception {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        Department department = sqlSession.getMapper(DepartmentMapper.class).get(29l);
        for (Object o :  department.getEmployees()) {
            System.out.println(o);
        }
        sqlSession.close();
    }

    @Test
    public void query() throws Exception {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        List<Department> query = sqlSession.getMapper(DepartmentMapper.class).query();
        for (Department department : query) {
            System.out.println(department);
            for (Employee e : department.getEmployees()) {
                System.out.println(e);
            }
        }
        sqlSession.close();
    }

}