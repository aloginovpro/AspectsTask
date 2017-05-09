package com.vbelova.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StopWatch;

public class Aspect {
    private static final Logger logger = LoggerFactory.getLogger(Aspect.class);

    public void before(JoinPoint joinPoint){
        String name = (String) joinPoint.getArgs()[0];
        logger.info("Before voting for {}", name);
    }
    public void after(){
        logger.info("Voting completed");
    }

    public void afterReturning(){
        logger.info("Voting completed with result");
    }

    public void afterThrowing(){
        logger.info("Exception during voting");
    }

    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Object result = joinPoint.proceed();
        stopWatch.stop();
        logger.info("method call {} took {} ms", joinPoint.getSignature().toShortString(), stopWatch.getTotalTimeMillis());
        return result;
    }
}
