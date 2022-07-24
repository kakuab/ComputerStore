package com.cy.store.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component //将当前类的对象交给spring容器维护
@Aspect //标记为切入类
public class TimerAspect {

    @Around("execution(* com.cy.store.service.impl.*.*(..))")//指定切入点
    public Object around(ProceedingJoinPoint point) throws Throwable {
        //先记录当前时间
        long start = System.currentTimeMillis();
        Object proceed = point.proceed();
        //后记录当前时间
        long end=System.currentTimeMillis();
        System.out.println("耗时："+(end-start));
        return proceed;
    }
}
