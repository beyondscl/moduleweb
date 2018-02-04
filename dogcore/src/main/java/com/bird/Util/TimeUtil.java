package com.bird.Util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * author: 牛虻.
 * time:2018/2/2 0002
 * email:pettygadfly@gmail.com
 * doc:
 */
public class TimeUtil {

    private static String datePattern = "yyyy-MM-dd HH:mm:ss";

    /**
     * 获取当前时间的string
     *
     * @return
     */
    public static String getDateStr() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(datePattern);
        return simpleDateFormat.format(Calendar.getInstance().getTime());
    }
}
