package com.jyzw.service;

import com.github.pagehelper.PageInfo;
import com.jyzw.entity.Result;
import com.jyzw.entity.YwEyunAccount;

import java.util.List;

public interface YwEyunAccountService {
    List<YwEyunAccount> getList();
    YwEyunAccount getOne(String yweaId);
    PageInfo getpageList(Integer pageNum,Integer pageSize,YwEyunAccount ywEyunAccount);
    Result saveOne(YwEyunAccount ywEyunAccount);
    Result update(YwEyunAccount ywEyunAccount);
    Result delOne(String yweaId);
}
