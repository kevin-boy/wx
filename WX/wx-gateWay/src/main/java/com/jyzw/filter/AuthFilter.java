package com.jyzw.filter;

import com.jyzw.config.FilterProperties;
import com.jyzw.config.JwtProperties;
import com.jyzw.entity.Payload;
import com.jyzw.entity.Result;
import com.jyzw.entity.UserInfo;
import com.jyzw.util.CookieUtils;
import com.jyzw.util.JwtUtils;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/*@EnableConfigurationProperties({JwtProperties.class, FilterProperties.class})*/
@Slf4j
public class AuthFilter extends ZuulFilter {

  /* @Autowired
   private JwtProperties jwtProp;
   @Autowired
   private FilterProperties filterProp;*/
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return FilterConstants.PRE_DECORATION_FILTER_ORDER-1;
    }

    @Override
    public boolean shouldFilter() {
        /*RequestContext ctx=RequestContext.getCurrentContext();
        HttpServletRequest req=ctx.getRequest();
        String requestURI=req.getRequestURI();
        return !isAllowedPath(requestURI);*/
        return true;
    }
   /* private boolean isAllowedPath(String uri){
        boolean b=false;
        for(String path:filterProp.getAllowedPath()){
            if(uri.contains(path)){
                b=true;
                break;
            }
        }
        return true;
    }*/

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx=RequestContext.getCurrentContext();
        HttpServletRequest request=ctx.getRequest();
        /*RequestContext ctx=RequestContext.getCurrentContext();
        HttpServletRequest request=ctx.getRequest();
        String token= CookieUtils.getCookieValue(request,jwtProp.getUser().getCookieName());
        try {
            Payload<UserInfo> payload= JwtUtils.getInfoFromToken(token,jwtProp.getPublicKey(),UserInfo.class);
            UserInfo userInfo=payload.getUserInfo();
            String role= userInfo.getRole();
            String path=request.getRequestURI();
            String method=request.getMethod();
            log.info("【网关】用户{},角色{}。访问服务{} : {},",userInfo.getUsername(),role,method,path);
        } catch (Exception e) {
            e.printStackTrace();
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(403);
            log.error("非法访问，未登录，地址{}",request.getRemoteHost(),e);
        }*/
       /* RequestContext ctx=RequestContext.getCurrentContext();
        HttpServletRequest request=ctx.getRequest();
        String head=request.getHeader("token");
        String ss="wx77to44ken5%2$1#e$Yun/Record91*";
        if(head.equals(ss)){
            return null;
        }
        if("".equals(head)||head==null||!head.equals(ss)){
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(403);
        }
        ctx.setSendZuulResponse(false);
        ctx.setResponseStatusCode(403);
        return null;*/
        ctx.setSendZuulResponse(false);
        ctx.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
        return null;
    }
}
