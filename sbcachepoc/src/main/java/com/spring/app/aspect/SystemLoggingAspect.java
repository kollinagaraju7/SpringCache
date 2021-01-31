package com.spring.app.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class SystemLoggingAspect {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Pointcut("execution(* com.spring.app.controller.*.*(..))")
    public void controller() {
    }

    @Pointcut("execution(* com.spring.app.*.*.*(..))")
    public void services() {
    }

    @Pointcut("execution(* com.spring.app.*.*.*.*(..))")
    public void allMethods() {
    }

    @Before("controller() || services()")
    public void logBefore(JoinPoint joinPoint) {
        logger.info("Entering into method: " + joinPoint.getSignature().getName() + " from class " + joinPoint.getSignature().getDeclaringTypeName());
        logger.info("Arguments : " + Arrays.toString(joinPoint.getArgs()));
    }

    @After("controller() || services()")
    public void logAfter(JoinPoint joinPoint) {
        logger.info("Exit from method: " + joinPoint.getSignature().getName() + " from class " + joinPoint.getSignature().getDeclaringTypeName());
        logger.info("Arguments : " + Arrays.toString(joinPoint.getArgs()));
    }


}
