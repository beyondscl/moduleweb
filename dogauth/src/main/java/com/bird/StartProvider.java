package com.bird;

import com.bird.service.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * author: 牛虻.
 * time:2018/3/18 0018
 * email:pettygadfly@gmail.com
 * doc:
 */
public class StartProvider {
    public static void main(String[] args) throws IOException {

        ClassPathXmlApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        applicationContext.start();
        UserService userService = (UserService) applicationContext.getBean("userServiceImpl");
        userService.testTx(null);
        System.out.println("dog-login-provider started");
        System.out.println("press any key to exit:");
        System.in.read();
    }
}
