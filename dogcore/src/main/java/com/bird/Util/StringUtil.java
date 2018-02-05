package com.bird.Util;

import java.io.UnsupportedEncodingException;

/**
 * author: 牛虻.
 * time:2018/1/31
 * email:pettygadfly@gmail.com
 * doc:
 */
public class StringUtil {


    public static String firstCharToUpper(String str) {
        String firstChar = String.valueOf(str.charAt(0)).toUpperCase();
        str = str.replaceFirst("\\w", firstChar);
        return str;
    }

    public static String firstCharToLower(String str) {
        String firstChar = String.valueOf(str.charAt(0)).toLowerCase();
        str = str.replaceFirst("\\w", firstChar);
        return str;
    }
    public static String getContentSubject(byte[] bytes){
        try {
            String s = new String(bytes, "utf-8");
            if (s.length()>100)
                return s.substring(0,99);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static boolean notEmpty(String v) {
        if (v == null || v.length() == 0)
            return false;
        return true;
    }
}
