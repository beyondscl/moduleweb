package com.bird.service;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * author: 牛虻.
 * time:2018/4/16
 * email:pettygadfly@gmail.com
 * doc:
 */
//注解之后需要在xml中配置当前bean或者注解使其生效
@Component
@Aspect
public class UserAopTest {

    @Pointcut("execution(* com.bird.service..*ServiceImpl.testTx(..))")
    public void AopTest(){
    }

    @After("AopTest()")
    public void afterMethod(){
        System.out.println("afterMethod===>");

    }
    @Around("AopTest()")
    public void aroundMethod(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("aroundMethod===>be");
        pjp.proceed();//不然目标方法不会执行,before也不会执行
        System.out.println("aroundMethod===>af");

    }
    @Before("AopTest()")
    public void beforeMethod(){
        System.out.println("beforeMethod===>");

    }
}
