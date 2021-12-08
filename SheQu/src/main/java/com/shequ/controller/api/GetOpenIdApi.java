package com.shequ.controller.api;

import com.shequ.controller.api.util.Constant;
import com.shequ.controller.api.util.GetOpenIDUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class GetOpenIdApi {
    @ResponseBody
    @RequestMapping("/getOpenid")
    public Map getOpenId(@RequestParam("code")String code){
        Map map = GetOpenIDUtil.oauth2GetOpenid(Constant.APPID,code,Constant.SECRET);
        return map;
    }
}
