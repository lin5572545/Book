package com.shequ.controller;

import com.alibaba.fastjson.JSON;
import com.shequ.pojo.Goods;
import com.shequ.service.GoodsPayService;
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
public class GoodsPayController {
    @Autowired
    GoodsPayService goodsPayService;

    @ResponseBody
    @RequestMapping(value = "/findAllGoodsPayByPage",produces="application/json;charset=UTF-8")
    public String findAllGoodsPayByPage(@RequestParam("limit") String limit, @RequestParam("page") String page){
        int start = (Integer.parseInt(page) - 1)*Integer.parseInt(limit);
        int pageSize = Integer.parseInt(limit);
        List<Goods> goods = goodsPayService.findAllGoodsPayByPage(start,pageSize);
        List<Goods> goodsAll = goodsPayService.findAllGoodsPay();
        Layui l = Layui.data(goodsAll.size(), goods);
        String result = JSON.toJSONString(l);
        System.out.println(result);
        return result;
    }


}

