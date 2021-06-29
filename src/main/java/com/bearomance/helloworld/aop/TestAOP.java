package com.bearomance.helloworld.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TestAOP {

    @Pointcut("@annotation(org.springframework.web.bind.annotation.GetMapping)")
    public void pointcut() {

    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {

        Object result = point.proceed();

        System.out.println("test GetMapping aop");
        return result;
    }
}
