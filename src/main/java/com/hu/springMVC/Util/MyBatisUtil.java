package com.hu.springMVC.Util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.util.Properties;

public class MyBatisUtil {
    private static SqlSessionFactory sessionFactory;

    static {
        try {
            Properties p = new Properties();
            p.load(Resources.getResourceAsStream("jdbc.properties"));
            sessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis.cfg.xml"),p);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取sqlSession
     *
     * @return
     * @throws IOException
     */
    public static SqlSession getSqlSession() {

        return sessionFactory.openSession();
    }

    private MyBatisUtil() {
    }
}
