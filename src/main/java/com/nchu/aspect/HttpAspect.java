package com.nchu.aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author laixiaoxing
 * Created by user12 on 2017/12/13.
 */
@Aspect
@Component
public class HttpAspect {

    private final static Logger logger= LoggerFactory.getLogger(HttpAspect.class);

    @Pointcut("execution(public * com.nchu.controller.UserComtroller.*(..))")
    public void log() {

    }

    @Before("log()")
    public void doBefore(){

        logger.info("拦截所有的userComtroller里的方法");

    }

    @AfterReturning(returning = "object",pointcut = "log()")
    public void doAfter(Object object){

        logger.info("返回{}",object);


    }



}
