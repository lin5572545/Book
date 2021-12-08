package com.shequ.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface VoteMapper {
    int insertVote(Map map);
}
