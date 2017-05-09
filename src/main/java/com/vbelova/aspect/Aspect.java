package com.vbelova.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StopWatch;

@org.aspectj.lang.annotation.Aspect
public class Aspect {
    private static final Logger logger = LoggerFactory.getLogger(Aspect.class);
    private static final String POINTCUT = "execution(* com.vbelova.aspect.ElectionService.vote(..))";

    @Before(POINTCUT)
    public void before(JoinPoint joinPoint){
        String name = (String) joinPoint.getArgs()[0];
        logger.info("Before voting for {}", name);
    }

    @After(POINTCUT)
    public void after(){
        logger.info("Voting completed");
    }

    @AfterReturning(POINTCUT)
    public void afterReturning(){
        logger.info("Voting completed with result");
    }

    @AfterThrowing(POINTCUT)
    public void afterThrowing(){
        logger.info("Exception during voting");
    }

    @Around(POINTCUT)
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Object result = joinPoint.proceed();
        stopWatch.stop();
        logger.info("method call {} took {} ms", joinPoint.getSignature().toShortString(), stopWatch.getTotalTimeMillis());
        return result;
    }

}
