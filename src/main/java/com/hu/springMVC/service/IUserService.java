package com.hu.springMVC.service;

import com.hu.springMVC.PageResult;
import com.hu.springMVC.QueryObject;

public interface IUserService {
    PageResult query(QueryObject qo);
}
