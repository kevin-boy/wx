package com.jyzw.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jyzw.entity.Result;
import com.jyzw.entity.YwEyunAccount;
import com.jyzw.mapper.YwEyunAccountMapper;
import com.jyzw.service.YwEyunAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class YwEyunAccountServiceImpl implements YwEyunAccountService {
   @Autowired
   private YwEyunAccountMapper mapper;
    @Override
    public List<YwEyunAccount> getList() {
        try {
            List<YwEyunAccount> list= mapper.getList();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
           List<YwEyunAccount> list1=new ArrayList<>();
           YwEyunAccount tb=new YwEyunAccount();
           tb.setEyAccount(Result.fCode);
           tb.setEyPassword("查询列表失败！");
           list1.add(tb);
           return list1;
        }
    }

    @Override
    public YwEyunAccount getOne(String yweaId) {
        try {
            YwEyunAccount one=mapper.getOne(yweaId);
            return one;
        } catch (Exception e) {
            e.printStackTrace();
            YwEyunAccount tb=new YwEyunAccount();
            tb.setEyAccount(Result.fCode);
            tb.setEyPassword("查询失败！");
            return tb;
        }
    }

    @Override
    public PageInfo getpageList(Integer pageNum, Integer pageSize, YwEyunAccount ywEyunAccount) {
        try {
            PageHelper.startPage(pageNum,pageSize);
            List<YwEyunAccount> list=mapper.getListByTJ(ywEyunAccount);
            PageInfo pageInfo=new PageInfo(list);
            return pageInfo;
        } catch (Exception e) {
            e.printStackTrace();
            List<YwEyunAccount> list1=new ArrayList<>();
            YwEyunAccount tb=new YwEyunAccount();
            tb.setEyAccount(Result.fCode);
            tb.setEyPassword("分页查询失败！");
            list1.add(tb);
            PageInfo pageInfo2= new PageInfo(list1);
            return pageInfo2;
        }
    }

    @Override
    public Result saveOne(YwEyunAccount ywEyunAccount) {
        try {
            mapper.saveOne(ywEyunAccount);
            return new Result(Result.sCode,"保存成功！",ywEyunAccount);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(Result.fCode,"保存失败！",ywEyunAccount);
        }
    }

    @Override
    public Result update(YwEyunAccount ywEyunAccount) {
        try {
            mapper.updateone(ywEyunAccount);
            return new Result(Result.sCode,"修改成功！",ywEyunAccount);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(Result.fCode,"修改失败！",ywEyunAccount);
        }
    }

    @Override
    public Result delOne(String yweaId) {
        YwEyunAccount tb=mapper.getOne(yweaId);
        if(tb!=null){
            mapper.delOne(yweaId);
            return new Result(Result.sCode,"删除成功！",tb);
        }else{
            return new Result(Result.fCode,"删除失败！",tb);
        }
    }
}
