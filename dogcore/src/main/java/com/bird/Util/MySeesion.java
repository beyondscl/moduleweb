package com.bird.Util;

import org.json.JSONObject;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;


/**
 * author: 牛虻.
 * time:2018/1/18
 * email:pettygadfly@gmail.com
 * doc:
 * 获取token,解决的问题是session和cookies的问题，而不是安全性的问题
 */
public class MySeesion {
    private static HashMap<String, JSONObject> map = new HashMap<String, JSONObject>();

    public static JSONObject getUserByToken(String token) {
        return map.get(token);
    }

    public static void setUserByToken(String token, JSONObject user) {
        map.put(token, user);
    }

    public static void setToken(HttpServletRequest request) {
        String token = request.getParameter("token");
        if (StringUtil.notEmpty(token))
            request.setAttribute("token", token);
    }

    public static Object getUserValue(HttpServletRequest request, String key) {
        return getUserByToken(request.getParameter("token")).get(key);
    }
}
