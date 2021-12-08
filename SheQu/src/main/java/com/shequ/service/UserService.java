package com.shequ.service;

import com.shequ.pojo.Admin;

import java.util.Map;

public interface UserService {
    int insertUser(Map map);
    String findUidByPNumAndPwd(Map map);
}
