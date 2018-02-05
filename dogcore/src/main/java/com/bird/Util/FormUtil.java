package com.bird.Util;

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
    final private static List<Double> formrandom = new ArrayList<Double>();

    public static void setFormrandom(Double value) {
        formrandom.add(value);
    }

    public static void removeFormrandom(Double value) {
        if (checkFormrandom(value))
            formrandom.remove(value);
    }

    public static boolean checkFormrandom(Double value) {
        return formrandom.contains(value);
    }
}
