package com.shequ.controller;

import com.alibaba.fastjson.JSON;
import com.shequ.pojo.Goods;
import com.shequ.pojo.Message;
import com.shequ.service.GoodsService;
import com.shequ.util.Layui;
import com.shequ.util.RandNum;
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
public class GoodsController {
    @Autowired
    GoodsService goodsService;

    @ResponseBody
    @RequestMapping(value = "/findAllGoodsByPages",produces="application/json;charset=UTF-8")
    public String findAllGoodsByPages(@RequestParam("limit") String limit, @RequestParam("page") String page){
        int start = (Integer.parseInt(page) - 1)*Integer.parseInt(limit);
        int pageSize = Integer.parseInt(limit);
        List<Goods> goods = goodsService.findAllGoodsByPages(start,pageSize);
        List<Goods> goodsAll = goodsService.findAllGoods();
        Layui l = Layui.data(goodsAll.size(), goods);
        String result = JSON.toJSONString(l);
        System.out.println(result);
        return result;
    }

    @ResponseBody
    @RequestMapping(value = "/deleteGoodsById")
    public String deleteGoodsById(@RequestParam("goods_id") String goods_id){
        int n = goodsService.deleteGoodsById(goods_id);
        if(n>0){
            return "success";
        }
        return "failure";
    }

    @ResponseBody
    @RequestMapping(value = "/updateGoodsById")
    public String updateGoodsById(@RequestBody Map map){
        Date date = new Date();
        map.put("publish_time",date);
        System.out.println("map:"+map.toString());
        int n = goodsService.updateGoodsById(map);
        if(n>0){
            return "success";
        }
        return "failure";
    }

    @ResponseBody
    @RequestMapping(value = "/insertGoods")
    public String insertGoods(@RequestBody Map map){
        Date date = new Date();
        map.put("publish_time",date);
        String goods_id = RandNum.getGUID();
        map.put("goods_id",goods_id);
        System.out.println("map:"+map.toString());
        int n = goodsService.insertGoods(map);
        if(n>0){
            return "success";
        }
        return "failure";
    }
}

