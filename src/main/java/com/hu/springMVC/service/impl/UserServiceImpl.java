package com.hu.springMVC.service.impl;

import com.hu.springMVC.PageResult;
import com.hu.springMVC.QueryObject;
import com.hu.springMVC.User;
import com.hu.springMVC.UserMapper;
import com.hu.springMVC.Util.MyBatisUtil;
import com.hu.springMVC.service.IUserService;
import org.apache.ibatis.session.SqlSession;

import java.util.Collections;
import java.util.List;

public class UserServiceImpl implements IUserService {
    @Override
    public PageResult query(QueryObject qo) {
        SqlSession openSession = MyBatisUtil.getSqlSession();
        Long count = openSession.getMapper(UserMapper.class).queryByCount(qo);
        List<User> users = openSession.getMapper(UserMapper.class).query(qo);
        if (count == 0) {
            return new PageResult(count.intValue(), Collections.EMPTY_LIST);
        }
        return new PageResult(count.intValue(), users);
    }
}
