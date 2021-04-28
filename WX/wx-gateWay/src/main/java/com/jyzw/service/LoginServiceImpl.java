package com.jyzw.service;

import com.jyzw.dao.UserClient;
import com.jyzw.entity.Result;
import com.jyzw.entity.Tuser;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.session.InvalidSessionException;
import org.apache.shiro.subject.Subject;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class LoginServiceImpl implements  LoginService{
    @Autowired
    private UserClient userClient;
    @Override
    public Result loginDo(String dl_mc, String dl_mm) {
        Tuser tuser=userClient.getUByName(dl_mc);
        AuthenticationToken token=new UsernamePasswordToken(dl_mc,dl_mm);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
            Tuser tuser1=(Tuser)subject.getPrincipal();
            subject.getSession().setAttribute("loginUser",tuser1);
            log.info(tuser.toString());
        } catch (UnknownAccountException e) {
            e.printStackTrace();
            return new Result(Result.fCode,"用户名错误！",tuser);
        } catch (IncorrectCredentialsException e) {
            e.printStackTrace();
            return new Result(Result.fCode,"密码错误！",tuser);
        }
        return new Result(Result.sCode,"登录成功！",tuser);
    }

    @Override
    public Result loginout() {
        Subject subject= SecurityUtils.getSubject();
        subject.logout();
        log.info("登出成功!");
        return  new Result(Result.sCode,"注销成功！",null);
    }

    @Override
    public Result login(String dl_mc, String dl_mm) {
        if(dl_mc==null||dl_mc.equals("")){
            return new Result(Result.uCode,"用户名为空",new Tuser());
        }
        if (dl_mm == null || dl_mm.equals("")) {
            return new Result(Result.fCode,"密码为空",new Tuser());
        }
        String uuid= UUID.randomUUID().toString();

        Tuser user = userClient.getUByName(dl_mc);
        if(user==null){
            return new Result<Tuser>(Result.uCode,"用户名不存在",new Tuser());
        }
        String md5pwd=new Md5Hash(dl_mm,dl_mc).toString();
      /*  long l = System.currentTimeMillis();
        String time=String.valueOf(l);
        Date date=user.getCreaterDate();*/
        if(user.getLoginPwd().equals(md5pwd)){
           /* user.setLoginPwd("");
            user.setLoginName("");*/
            Tuser tuser=new Tuser();
            tuser.setLoginName(dl_mc);
            tuser.setWxWid(uuid);
            userClient.updateWid(tuser);
            user.setWxWid(uuid);
            return new Result(Result.sCode,
                    "登录成功！",user);
        }else{
            return new Result(Result.fCode,"密码错误！",new Tuser());
        }
    }
}
