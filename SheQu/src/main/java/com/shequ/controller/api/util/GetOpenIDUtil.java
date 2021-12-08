package com.shequ.controller.api.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;


import java.util.HashMap;
import java.util.Map;

/**
 * 微信小程序获取openid
 * @author Mr.Lin
 */
public class GetOpenIDUtil {
    // 网页授权接口
//    public final static String GetPageAccessTokenUrl = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";//
//    public final static String GetPageAccessTokenUrl = "https://api.weixin.qq.com/sns/jscode2session?appid=APPID&secret=SECRET&js_code=CODE&grant_type=authorization_code";
    public final static String GetPageAccessTokenUrl = "https://api.weixin.qq.com/sns/jscode2session?appid=APPID&secret=SECRET&js_code=CODE&grant_type=authorization_code";
    public  static Map<String,Object> oauth2GetOpenid(String appid,String code,String appsecret) {
        String requestUrl = GetPageAccessTokenUrl.replace("APPID", appid).replace("SECRET", appsecret).replace("CODE", code);
        DefaultHttpClient client = null;
        Map<String,Object> result =new HashMap<String,Object>();
        try {
            client = new DefaultHttpClient();
            HttpGet httpget = new HttpGet(requestUrl);
            ResponseHandler<String> responseHandler = new BasicResponseHandler();
            String response = client.execute(httpget, responseHandler);
            //JSONObject.fromObject(response);
            JSONObject OpenidJSONO= JSON.parseObject(response);
            String openid =String.valueOf(OpenidJSONO.get("openid"));
            String session_key=String.valueOf(OpenidJSONO.get("session_key"));
            String unionid=String.valueOf(OpenidJSONO.get("unionid"));
            String errcode=String.valueOf(OpenidJSONO.get("errcode"));
            String errmsg=String.valueOf(OpenidJSONO.get("errmsg"));

            result.put("openid", openid);
            result.put("sessionKey", session_key);
            result.put("unionid", unionid);
            result.put("errcode", errcode);
            result.put("errmsg", errmsg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            client.getConnectionManager().shutdown();
        }
        System.out.println(result);
        return result;
    }
}
