package com.shequ.controller.api;

import com.alibaba.fastjson.JSON;
import com.shequ.pojo.Goods;
import com.shequ.pojo.Message;
import com.shequ.service.GoodsService;
import com.shequ.service.MessageService;
import com.shequ.service.RepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
public class GoodsApi {
    @Autowired
    GoodsService goodsService;
    /*
    微信小程序端提供json接口的。显示所有二手数据
     */
    @ResponseBody
    @RequestMapping(value = "/findAllGoods",produces="application/json;charset=UTF-8")
    public String findAllGoods(){
        List<Goods> goods = goodsService.findAllGoods();
        String result = JSON.toJSONString(goods);
        System.out.println(result);
        return result;
    }

    @ResponseBody
    @RequestMapping(value = "/findGoodsById",produces="application/json;charset=UTF-8")
    public String findGoodsById(String id){
        Goods goods = goodsService.findGoodsById(id);
        String result = JSON.toJSONString(goods);
        System.out.println(result);
        return result;
    }
}
