package com.jyzw.config;

import com.jyzw.util.IPUtils;
import com.netflix.discovery.converters.Auto;
import lombok.extern.slf4j.Slf4j;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Array;
import java.util.Arrays;

@Slf4j
@Component
@Aspect
public class RecordConfig {
    @Autowired
    private HttpServletRequest request;
    @Pointcut("execution(public * com.jyzw.web.*.*(..))")
    public void weblog(){}
    @Pointcut("execution(public * com.jyzw.web.*.*())")
    public void NoArgsLog(){}
    @Before("weblog()|| NoArgsLog()")
    public void record(JoinPoint joinPoint){
        log.info("请求路径"+request.getRequestURI());
        log.info("请求方法:"+request.getMethod());
        log.info("请求远程地址"+ IPUtils.getRemoteIP(request));
        log.info("请求参数："+ Arrays.toString(joinPoint.getArgs()));
        log.info("包名加类名:"+joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
    }
}
