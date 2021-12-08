package com.shequ.service.impl;

import com.shequ.mapper.UserMapper;
import com.shequ.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public int insertUser(Map map) {
        return userMapper.insertUser(map);
    }

    @Override
    public String findUidByPNumAndPwd(Map map) {
        return userMapper.findUidByPNumAndPwd(map);
    }
}
