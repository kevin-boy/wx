package com.jyzw.web;

import com.jyzw.dao.UserClient;
import com.jyzw.entity.Result;
import com.jyzw.entity.Tuser;
import com.jyzw.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.aspectj.lang.JoinPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.awt.geom.IllegalPathStateException;


@RestController
@Slf4j
public class LoginController {
    @Autowired
    private LoginService loginService;

  /*  @RequestMapping("login")
    public Result login(@RequestParam("dl_mc")String dlMc,
                        @RequestParam("dl_mm") String dlMM){
      return  loginService.login(dlMc,dlMM);
    }
    @RequestMapping("logout")*/
    public String logout(){
         /*log.info("请求路径"+request.getRequestURI());
         log.info("请求方法"+request.getMethod());
         log.info("请求地址"+ request.getLocalAddr());
         log.info("参数："+joinPoint.getArgs());
         log.info("包名加类名"+joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());*/
       return "redirect:http://121.37.187.26:8089/login.call#";
    }
}
