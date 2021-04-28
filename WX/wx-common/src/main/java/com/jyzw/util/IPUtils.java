package com.jyzw.util;

import javax.servlet.http.HttpServletRequest;

public class IPUtils {
    public static String getRemoteIP(HttpServletRequest request){
        String ip=request.getHeader("x-forwarded-for");
        if(ip==null||ip.length()==0||"unknown".equalsIgnoreCase(ip)){
            ip=request.getHeader("Proxy-Client-IP");
        }
        if(ip==null||ip.length()==0||"unknown".equalsIgnoreCase(ip)){
            ip=request.getHeader("WL-Proxy-Client-IP");
        }
        if(ip==null||ip.length()==0||"unknown".equalsIgnoreCase(ip)){
            ip=request.getLocalAddr();
        }
        if("0:0:0:0:0:0:0:1".equalsIgnoreCase(ip)){
            ip="127.0.0.1";}
               return  ip;
    }
}
