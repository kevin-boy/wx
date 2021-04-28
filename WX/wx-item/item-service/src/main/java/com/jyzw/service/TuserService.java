package com.jyzw.service;

import com.github.pagehelper.PageInfo;
import com.jyzw.entity.Result;
import com.jyzw.entity.Tuser;

import java.util.List;

public interface TuserService {
    Tuser getUser(String uid);
    Result save(Tuser tuser);
    Result delOne(String uid);
    PageInfo<Tuser> getPageInfo(Integer pageNum,Integer pageSize,Tuser tuser);
    Result updateOne(Tuser tuser);
    List<Tuser> getListFL();
    Result login(String dl_mc, String dl_mm);
    Result updatePwd(String userId, String loginPwd);
    Tuser getUserByUP(String username,String password);
    void updateWid(Tuser tuser);
    Tuser getUserByUname(String uname);
}
