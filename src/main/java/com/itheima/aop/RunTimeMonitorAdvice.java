package com.itheima.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class RunTimeMonitorAdvice {
  @Pointcut("execution(* com.itheima.service.*Service.find*(..))")
    public void pt(){
    }
@Around("pt()")
    public Object runtimeAround(ProceedingJoinPoint pjp) throws Throwable{
    Signature signature = pjp.getSignature();
    String className=signature.getDeclaringTypeName();
    String methodName=signature.getName();
    long sum=0L;
    for (int i = 0; i < 10000; i++) {
        long startTime=System.currentTimeMillis();
        pjp.proceed(pjp.getArgs());
        long endTime=System.currentTimeMillis();
        sum+=endTime-startTime;
    }
        System.out.println(className+":"+methodName+"(万次)run:"+sum+"ms");

//    long startTime=System.currentTimeMillis();
//    Object ret=pjp.proceed(pjp.getArgs());
//    long endTime=System.currentTimeMillis();
//    System.out.println(className+":"+methodName+"(一次)run:"+(endTime-startTime)+"ms");
        return null;
    }
}