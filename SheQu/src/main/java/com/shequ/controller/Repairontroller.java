package com.shequ.controller;

import com.alibaba.fastjson.JSON;
import com.shequ.pojo.Goods;
import com.shequ.pojo.Repair;
import com.shequ.service.GoodsPayService;
import com.shequ.service.RepairService;
import com.shequ.util.Layui;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
public class Repairontroller {
    @Autowired
    RepairService repairService;

    @ResponseBody
    @RequestMapping(value = "/findAllRepairByPage",produces="application/json;charset=UTF-8")
    public String findAllRepairByPage(@RequestParam("limit") String limit, @RequestParam("page") String page){
        int start = (Integer.parseInt(page) - 1)*Integer.parseInt(limit);
        int pageSize = Integer.parseInt(limit);
        List<Repair> repairs = repairService.findAllRepairByPage(start,pageSize);
        List<Repair> repairsAll = repairService.findAllRepair();
        Layui l = Layui.data(repairsAll.size(), repairs);
        String result = JSON.toJSONString(l);
        System.out.println(result);
        return result;
    }


}

