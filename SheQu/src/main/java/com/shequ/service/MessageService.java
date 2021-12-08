package com.shequ.service;

import com.shequ.pojo.Message;

import java.util.List;
import java.util.Map;

public interface MessageService {
    List<Message> findAllMessage();
    List<Message>findAllMessageByPage(int satrt,int pagesize);
    int insertMessage(Map map);
    int deleteNotices(int id);
    int updateMessage(Map map);
}
