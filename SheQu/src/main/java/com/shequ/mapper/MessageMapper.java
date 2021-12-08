package com.shequ.mapper;

import com.shequ.pojo.Message;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface MessageMapper {
    List<Message>findAllMessage();
    List<Message>findAllMessageByPage(int satrt,int pagesize);
    int insertMessage(Map map);
    int deleteNotices(int id);
    int updateMessage(Map map);
}
