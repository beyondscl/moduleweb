package com.bird.util;

import org.junit.Test;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Logger;

/**
 * author: 牛虻.
 * time:2018/2/28
 * email:pettygadfly@gmail.com
 * doc:
 * 加载配置文件
 */
public class ResourceUtil {

    private static Logger logger = Logger.getLogger(ResourceUtil.class.getName());
    private static ResourceBundle config = ResourceBundle.getBundle("config", Locale.CHINA);

    public static String getConfigValue(String key) {
        if (!config.containsKey(key)) {
            return config.getString(key);
        }
        logger.info("config.properties not containsKey " + key);
        return "";
    }

    @Test
    public void getConfigValue() {
        ResourceBundle config = ResourceBundle.getBundle("config", Locale.CHINA);
        logger.info(config.getString("tokenAuth"));
    }
}
