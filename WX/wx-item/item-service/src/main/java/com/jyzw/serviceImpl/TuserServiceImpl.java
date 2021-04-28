package com.jyzw.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jyzw.entity.Result;
import com.jyzw.entity.Tuser;
import com.jyzw.mapper.TuserMapper;

import com.jyzw.service.TuserService;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class TuserServiceImpl implements TuserService {
   @Autowired
   private TuserMapper tuserMapper;
    @Override
    public Tuser getUser(String id) {
        return tuserMapper.getUser(id);
    }

    @Override
    public Result save(Tuser tuser) {
        try {
            String username=tuser.getLoginName();
            String password=tuser.getLoginPwd();
            String md5Hash=new Md5Hash(password,username).toString();
            tuser.setLoginPwd(md5Hash);
            String  id= UUID.randomUUID().toString();
            tuser.setUserId(id);
            tuserMapper.save(tuser);
            return new Result(Result.sCode,"保存成功！",tuser);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(Result.sCode,"保存失败！",tuser);
        }


    }

    @Override
    public Result  delOne(String uid) {
        Tuser tuser1= null;
        try {
            tuser1 = tuserMapper.getUser(uid);
            tuserMapper.delOne(uid);
            return new Result(Result.sCode,"删除成功！",tuser1);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(Result.sCode,"删除失败！",tuser1);
        }

    }

    @Override
    public PageInfo<Tuser> getPageInfo(Integer pageNum,Integer pageSize,Tuser tuser) {
        try {
            PageHelper.startPage(pageNum,pageSize);
            List<Tuser> list=tuserMapper.getListByTJ(tuser);
            PageInfo<Tuser> pageInfo=new PageInfo<>(list);
            return pageInfo;
        } catch (Exception e) {
            e.printStackTrace();
            Tuser tuser1=new Tuser();
            tuser1.setLoginName(Result.fCode);
            tuser1.setLoginPwd("分页查询列表失败！");
            List<Tuser> list1=new ArrayList<>();
            list1.add(tuser1);
            PageInfo<Tuser> pagheInfo2=new PageInfo<>(list1);
            return pagheInfo2;
        }
    }

    @Override
    public Result  updateOne(Tuser tuser) {
        try {

            tuserMapper.updateOne(tuser);
            return new Result(Result.sCode,"修改成功！",tuser);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(Result.sCode,"修改失败！",tuser);
        }
    }

    @Override
    public List<Tuser> getListFL() {
        try {
            List<Tuser> list = tuserMapper.getList();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            Tuser tuser=new Tuser();
            tuser.setLoginName(Result.fCode);
            tuser.setLoginPwd("查询所有用户失败");
            List<Tuser>  list1=new ArrayList<>();
            list1.add(tuser);
            return list1;
        }
    }

    @Override
    public Result<Tuser> login(String dl_mc, String dl_mm) {
        if(dl_mc==null||dl_mc.equals("")){
            return new Result(Result.uCode,"用户名为空",new Tuser());
        }
        if (dl_mm == null || dl_mm.equals("")) {
            return new Result(Result.fCode,"密码为空",new Tuser());
        }
        String uuid=UUID.randomUUID().toString();

        Tuser user = tuserMapper.getUserByName(dl_mc);
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
            tuserMapper.updateWid(tuser);
            user.setWxWid(uuid);
            return new Result(Result.sCode,
                    "登录成功！",user);
        }else{
            return new Result(Result.fCode,"密码错误！",new Tuser());
        }
    }

    @Override
    public Result updatePwd(String userId, String loginPwd) {
        try {
            Tuser tuser=tuserMapper.getUser(userId);
            String md5hash=new Md5Hash(loginPwd,tuser.getLoginName()).toString();
            tuserMapper.updatePwd(userId,md5hash);
            return new Result(Result.sCode,"修改密码成功！","userId:"+userId+",loginPwd:"+loginPwd);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(Result.sCode,"修改密码失败！","userId:"+userId+",loginPwd:"+loginPwd);
        }
    }

    @Override
    public Tuser getUserByUP(String username, String password) {
      return  tuserMapper.getUserByUP(username,password);
    }

    @Override
    public void updateWid(Tuser tuser) {
        tuserMapper.updateWid(tuser);
    }

    @Override
    public Tuser getUserByUname(String uname) {
        return tuserMapper.getUserByName(uname);
    }
}
