package com.shequ.controller;

import com.alibaba.fastjson.JSON;
import com.shequ.pojo.Admin;
import com.shequ.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
public class AdminController {
    @Autowired
    AdminService adminService;

    @ResponseBody
    @RequestMapping("/login")
    public String findOneAdmin(String account, String pwd, HttpServletRequest request ){
        HttpSession session = request.getSession(true);//新建session对象
        Admin admin = adminService.findOneAdmin(account,pwd);
        session.setAttribute("admin",admin);
        if(admin!=null){
            return "success";
        }
        return "failure";
    }

    @ResponseBody
    @RequestMapping(value = "/findAllAccount",produces="application/json;charset=UTF-8")
    public String findAllAccount(){
        List<Admin> accounts = adminService.findAllAccount();
        String result = JSON.toJSONString(accounts);
        System.out.println(result);
        return result;
    }


    @ResponseBody
    @RequestMapping(value = "/updateAdminPwd" )
    public String updateAdminPwd(@RequestBody Map map, HttpServletRequest request){
        HttpSession session = request.getSession(true);//新建session对象
        Admin admin = (Admin) session.getAttribute("admin");  //将对应数据存入session中
        String account = admin.getAccount();
        System.out.println(map);
        String pwd = map.get("pwd").toString();
        System.out.println("pwd:"+pwd);
        int n = adminService.updateAdminPwd(pwd,account);
        if(n>0){
            return "success";
        }
        return "failure";
    }


}
