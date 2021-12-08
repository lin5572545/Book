package com.shequ.mapper;

import com.shequ.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper {
   int insertUser(Map map);
   String findUidByPNumAndPwd(Map map);
}
