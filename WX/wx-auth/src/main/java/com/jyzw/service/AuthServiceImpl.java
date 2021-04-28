package com.jyzw.service;

import com.jyzw.config.JwtProperties;
import com.jyzw.dao.UserClient;
import com.jyzw.entity.*;
import com.jyzw.util.CookieUtils;
import com.jyzw.util.JwtUtils;
import io.jsonwebtoken.Jwt;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.UUID;

@Service
public class AuthServiceImpl implements  AuthService{

    @Autowired
    private UserClient userClient;
    @Autowired
    private JwtProperties prop;
    private static final String user_role="role_user";
    @Override
    public Result login(String uname, String pwd, HttpServletResponse response) {
        if(uname==null||uname.equals("")){
            return new Result(Result.uCode,"用户名为空",new Tuser());
        }
        if (pwd== null || pwd.equals("")) {
            return new Result(Result.fCode,"密码为空",new Tuser());
        }
        Tuser tuser=userClient.getUserByUP(uname,pwd);
        if(tuser==null){
            return new Result(Result.fCode,"用户名或密码错误",new Tuser());
        }
        String uuid= UUID.randomUUID().toString();
        Tuser tuser1=new Tuser();
        tuser1.setLoginName(uname);
        tuser1.setWxWid(uuid);
        userClient.updateWid(tuser1);
        try {
            UserInfo userInfo=new UserInfo(tuser.getLoginName(),tuser.getLoginPwd(),user_role);
            String token= JwtUtils.generateTokenExpireInMinutes(userInfo,prop.getPrivateKey(),prop.getUser().getExpire());
            CookieUtils.newBuilder().response(response).httpOnly(true).name(prop.getUser().getCookieName()).value(token).build();
            return new Result(Result.sCode,"登录成功！",tuser);
        } catch (Exception e) {
            e.printStackTrace();
          return new Result(Result.fCode,"登录失败!",tuser);
        }
    }

    @Override
    public UserInfo verify(HttpServletRequest request, HttpServletResponse response) {

        try {
            String token=CookieUtils.getCookieValue(request,prop.getUser().getCookieName());
            Payload<UserInfo> payload=JwtUtils.getInfoFromToken(token,prop.getPublicKey(),UserInfo.class);
            Date  expiration=payload.getExpiration();
            DateTime refreshTime=new DateTime(expiration.getTime()).minusMinutes(prop.getUser().getMinRefreshInterval());
            if(refreshTime.isBefore(System.currentTimeMillis())){
                token=JwtUtils.generateTokenExpireInMinutes(payload.getUserInfo(),prop.getPrivateKey(),prop.getUser().getExpire());
                CookieUtils.newBuilder().response(response).httpOnly(true).name(prop.getUser().getCookieName()).value(token).build();
            }
            return payload.getUserInfo();
        } catch (Exception e) {
            e.printStackTrace();
            return new UserInfo("1","验证cookie失败","异常");
        }

    }

    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response) {
       /* String token=CookieUtils.getCookieValue(request,prop.getUser().getCookieName());
        Payload<UserInfo> payload= JwtUtils.getInfoFromToken(token,prop.getPublicKey());*/
        CookieUtils.deleteCookie(prop.getUser().getCookieName(),response);
    }
}
