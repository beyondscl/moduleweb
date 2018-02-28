package com.bird.util;

import java.util.UUID;

/**
 * author: 牛虻.
 * time:2018/2/2 0002
 * email:pettygadfly@gmail.com
 * doc:
 */
public class IdGen {
    /**
     * 获取32位ID
     */
    public static String getId() {
        String uuid = UUID.randomUUID().toString();
        return uuid.replaceAll("-", "");
    }
}
