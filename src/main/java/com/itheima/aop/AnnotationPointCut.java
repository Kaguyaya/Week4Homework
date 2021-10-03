package com.itheima.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
public class AnnotationPointCut {
    @Before("execution(* com.itheima.service..*(..))")
    public void before(){
        System.out.println("==before==");
    }
    @After("execution(* com.itheima.service..*(..))")
    public void after(){
        System.out.println("==after==");
    }
}
