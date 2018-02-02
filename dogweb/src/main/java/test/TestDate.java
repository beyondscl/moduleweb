package test;

import org.joda.time.DateTime;
import org.junit.Test;

/**
 * author: 牛虻.
 * time:2018/1/18
 * email:pettygadfly@gmail.com
 * doc:
 * 单元测试无法使用线程
 */
public class TestDate {
    @Test
    public void testTime() {
        System.out.println(DateTime.now());
    }
}
