package com.shequ.service.impl;

import com.shequ.mapper.VoteMapper;
import com.shequ.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class VoteServiceImpl implements VoteService {
    @Autowired
    VoteMapper voteMapper;

    @Override
    public int insertVote(Map map) {
        return voteMapper.insertVote(map);
    }
}
