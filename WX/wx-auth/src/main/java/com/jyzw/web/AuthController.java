package com.jyzw.web;

import com.jyzw.dao.UserClient;
import com.jyzw.entity.Result;
import com.jyzw.entity.Tuser;
import com.jyzw.entity.UserInfo;
import com.jyzw.service.AuthService;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class AuthController {
    @Autowired
    private AuthService authService;
    @Autowired
    private UserClient userClient;
    @PostMapping("loginDo")
    public Result loginDo(@RequestParam("dl_mc")String username,
                          @RequestParam("dl_mm")String password, HttpServletResponse response) {
      return  authService.login(username, password, response);
    }
    @GetMapping("verify")
    public UserInfo verify(HttpServletRequest request, HttpServletResponse response){
      return  authService.verify(request,response);
    }
    @PostMapping("logout")
    public void logout(HttpServletRequest request,HttpServletResponse response){
        authService.logout(request,response);
    }
    @GetMapping("upWid")
    public String upWid(Tuser tuser){
        userClient.updateWid(tuser);
        return "修改成功！";
    }
}
