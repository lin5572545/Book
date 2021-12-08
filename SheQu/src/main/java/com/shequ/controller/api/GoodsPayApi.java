package com.shequ.controller.api;

import com.alibaba.fastjson.JSON;
import com.shequ.mapper.GoodsPayMapper;
import com.shequ.pojo.Goods;
import com.shequ.service.GoodsPayService;
import com.shequ.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;


@Controller
public class GoodsPayApi {
    @Autowired
    GoodsPayService goodsPayService;
    /*
    微信小程序端提供json接口的。记录商品购买
     */
    @ResponseBody
    @RequestMapping(value = "/insertBuyGoods")
    public String insertBuyGoods(@RequestBody Map map){
        int n = goodsPayService.insertBuyGoods(map);
        if(n>0){
            return "success";
        }
        return "failure";
    }

    @ResponseBody
    @RequestMapping(value = "/findMyGoods",produces="application/json;charset=UTF-8")
    public String findMyGoods(@RequestParam("uid")String uid){
        List<Goods> goods = goodsPayService.findMyGoods(uid);
        String result = JSON.toJSONString(goods);
        System.out.println(result);
        return result;
    }
}
