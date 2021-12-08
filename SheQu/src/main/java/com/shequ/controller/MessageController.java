package com.shequ.controller;

import com.alibaba.fastjson.JSON;
import com.shequ.pojo.Message;
import com.shequ.service.MessageService;
import com.shequ.util.Layui;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class MessageController {
    @Autowired
    MessageService messageService;


    @ResponseBody
    @RequestMapping(value = "/findAllMessageByPage",produces="application/json;charset=UTF-8")
    public String findAllMessageByPage(@RequestParam("limit") String limit, @RequestParam("page") String page){
        int start = (Integer.parseInt(page) - 1)*Integer.parseInt(limit);
        int pageSize = Integer.parseInt(limit);
        List<Message> message = messageService.findAllMessageByPage(start,pageSize);
        List<Message> messageAll = messageService.findAllMessage();
        Layui l = Layui.data(messageAll.size(), message);
        String result = JSON.toJSONString(l);
        return result;
    }

    @ResponseBody
    @RequestMapping(value = "/insertMessage")
    public String insertMessage(@RequestBody Map map){
        Date date = new Date();
        map.put("time",date);
        System.out.println("map:"+map.toString());
        int n = messageService.insertMessage(map);
        if(n>0){
            return "success";
        }
        return "failure";
    }

    @ResponseBody
    @RequestMapping(value = "/deleteNotices")
    public String deleteNotices(@RequestParam("id") int id){
        int n = messageService.deleteNotices(id);
        if(n>0){
            return "success";
        }
        return "failure";
    }

    @ResponseBody
    @RequestMapping(value = "/updateMessage")
    public String updateMessage(@RequestBody Map map){
        Date date = new Date();
        map.put("time",date);
        System.out.println("map:"+map.toString());
        int n = messageService.updateMessage(map);
        if(n>0){
            return "success";
        }
        return "failure";
    }
}
