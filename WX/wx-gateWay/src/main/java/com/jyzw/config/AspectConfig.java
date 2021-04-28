package com.jyzw.config;


import com.jyzw.util.IPUtils;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Component
@Aspect
@Slf4j
public class AspectConfig {
    @Pointcut("execution(public * com.jyzw.web.*.*(..))")
    public void controllerLog(){}
    @Pointcut("execution(public * com.jyzw.web.*.*())")
    public void controllerNoArgs(){}
   @Autowired
   private HttpServletRequest request;
    @Before("controllerLog() || controllerNoArgs()")
    public void logBeforeWeb(JoinPoint joinPoint){
       /* RequestAttributes requestAttributes= RequestContextHolder.getRequestAttributes();
        HttpServletRequest request=((ServletRequestAttributes)requestAttributes).getRequest();*/
        log.info("请求路径"+request.getRequestURI().toString());
        log.info("请求方法"+request.getMethod());
        log.info("远程地址"+ IPUtils.getRemoteIP(request));
        log.info("***********"+ Arrays.toString(joinPoint.getArgs()));
        log.info("包名加类名"+joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
    }
    /*@After("controllerNoArgs()")
    public void logArroundWeb(JoinPoint joinPoint){
       *//* RequestAttributes requestAttributes= RequestContextHolder.getRequestAttributes();
        HttpServletRequest request=((ServletRequestAttributes)requestAttributes).getRequest();*//*
        log.info("请求路径"+request.getRequestURI().toString());
        log.info("请求方法"+request.getMethod());
        log.info("远程地址"+ IPUtils.getRemoteIP(request));
        log.info("***********"+ Arrays.toString(joinPoint.getArgs()));
        log.info("包名加类名"+joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());*/

}
