package com.hu.springMVC.service.impl;

import com.hu.springMVC.PageResult;
import com.hu.springMVC.QueryObject;
import com.hu.springMVC.service.IUserService;
import org.junit.Test;

public class UserServiceImplTest {
    @Test
    public void query() throws Exception {
        IUserService userService = new UserServiceImpl();
        QueryObject qo = new QueryObject();
        qo.setPageSize(2);
        qo.setCurrentPage(1);
        qo.setKeyword("1232");
        qo.setEndPass(40);
        qo.setBeginPass(30);
        PageResult query = userService.query(qo);
        for (Object o : query.getResult()) {
            System.out.println(o);
        }

    }

}