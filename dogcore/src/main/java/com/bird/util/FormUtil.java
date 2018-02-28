package com.bird.util;

import java.util.ArrayList;
import java.util.List;

/**
 * author: 牛虻.
 * time:2018/2/5
 * email:pettygadfly@gmail.com
 * doc:
 * 防止form重复提交
 */
public class FormUtil {
    final private static List<String> formrandom = new ArrayList<String>();

    public static void setFormrandom(String value) {
        formrandom.add(value);
    }

    public static void removeFormrandom(String value) {
        if (checkFormrandom(value))
            formrandom.remove(value);
    }

    public static boolean checkFormrandom(String value) {
        return formrandom.contains(value);
    }
}
