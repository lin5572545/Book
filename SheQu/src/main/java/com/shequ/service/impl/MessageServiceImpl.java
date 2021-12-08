package com.shequ.service.impl;

import com.shequ.mapper.MessageMapper;
import com.shequ.pojo.Message;
import com.shequ.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    MessageMapper messageMapper;
    @Override
    public List<Message> findAllMessage() {
        return messageMapper.findAllMessage();
    }

    @Override
    public List<Message> findAllMessageByPage(int satrt, int pagesize) {
        return messageMapper.findAllMessageByPage(satrt,pagesize);
    }

    @Override
    public int insertMessage(Map map) {
        return messageMapper.insertMessage(map);
    }

    @Override
    public int deleteNotices(int id) {
        return messageMapper.deleteNotices(id);
    }

    @Override
    public int updateMessage(Map map) {
        return messageMapper.updateMessage(map);
    }

}
