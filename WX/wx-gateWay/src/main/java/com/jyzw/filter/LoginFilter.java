package com.jyzw.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class LoginFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return FilterConstants.PRE_DECORATION_FILTER_ORDER - 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
         RequestContext ctx=RequestContext.getCurrentContext();
        HttpServletRequest request=ctx.getRequest();
        String head=request.getHeader("token");
        String ss="wx77to44ken5%2$1#e$Yun/Record91*";
        if(ss.equals(head)){
            return null;
        }
        if("".equals(head)||head==null||!ss.equals(head)){
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(403);
        }
        ctx.setSendZuulResponse(false);
        ctx.setResponseStatusCode(403);
        return null;
    }
}
