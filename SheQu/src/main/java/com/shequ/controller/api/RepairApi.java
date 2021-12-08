package com.shequ.controller.api;

import com.shequ.service.RepairService;
import com.shequ.util.MyTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class RepairApi {
    @Autowired
    RepairService repairService;
    /*
   接受微信小程序发过来的图片，进行保存
    */
    @RequestMapping(value = "/uploadWxImg", method = RequestMethod.POST)
    public @ResponseBody Object uploadWxImg(@RequestParam("img") MultipartFile file, HttpServletRequest request)
            throws IllegalStateException, IOException {
        Map<String, Object> map = new HashMap<String, Object>();
        String name = file.getOriginalFilename();
        String imgAbsolutePath = MyTool.SaveImg(file, MyTool.getImg(), name);
        map.put("code", 0);
        map.put("message", "上传成功");
        map.put("data", name);
        System.out.println(map.toString());
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/insertRepair", method = RequestMethod.POST)
    public String insertMessage(@RequestBody Map map){
        System.out.println("reparjson:"+map.toString());
        List<String> Pics = (List<String>) map.get("imageUrl");
        for (int i=0;i<Pics.size();i++){
            String imgName = Pics.get(i).substring(11);
            map.put("pic"+i,imgName);
        }
        map.remove("imageUrl");
        System.out.println(map.toString());
        int n = repairService.insertRepair(map);
        if(n>0){
            return "success";
        }
        return "failure";
    }
}
