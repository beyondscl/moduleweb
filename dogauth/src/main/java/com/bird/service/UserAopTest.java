package com.bird.service;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
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
    @Before("AopTest()")
    public void beforeMethod(){
        System.out.println("");
    }
}
