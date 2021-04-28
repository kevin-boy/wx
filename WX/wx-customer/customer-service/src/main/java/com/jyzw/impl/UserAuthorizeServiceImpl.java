package com.jyzw.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jyzw.entity.Result;
import com.jyzw.entity.YwUserAuthorize;
import com.jyzw.mapper.UserAuthorizeMapper;
import com.jyzw.service.UserAuthorizeService;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserAuthorizeServiceImpl  implements UserAuthorizeService {
    @Autowired
    private UserAuthorizeMapper userAuthorizeMapper;
    @Override
    public List<YwUserAuthorize> getList() {
        try {
            return   userAuthorizeMapper.selectAll();
        } catch (Exception e) {
            e.printStackTrace();
          List<YwUserAuthorize> list=new ArrayList<>();
          YwUserAuthorize tb=new YwUserAuthorize();
          tb.setGrantUserName(Result.fCode);
          tb.setGrantCompanyName("查询列表失败！");
          list.add(tb);
          return list;
        }
    }

    @Override
    public YwUserAuthorize getOne(String yuaId) {
        try {
            return userAuthorizeMapper.selectByPrimaryKey(yuaId);
        } catch (Exception e) {
            e.printStackTrace();
            YwUserAuthorize tb=new YwUserAuthorize();
            tb.setUserName(Result.fCode);
            tb.setGrantCompanyName("查询失败！");
            return tb;
        }
    }

    @Override
    public PageInfo getPageList(Integer pageNum, Integer pageSize, YwUserAuthorize ywUserAuthorize) {
        try {
            PageHelper.startPage(pageNum,pageSize);
            List<YwUserAuthorize> list=userAuthorizeMapper.getListByTJ(ywUserAuthorize);
            PageInfo pageInfo=new PageInfo(list);
            return pageInfo;
        } catch (Exception e) {
            e.printStackTrace();
            List<YwUserAuthorize> list1=new ArrayList<>();
            YwUserAuthorize tb=new YwUserAuthorize();
            tb.setUserName(Result.fCode);
            tb.setGrantCompanyName("分页查询失败！");
            PageInfo pageInfo2=new PageInfo(list1);
            return pageInfo2;
        }
    }

    @Override
    public Result saveOne(YwUserAuthorize ywUserAuthorize) {
        try {
            userAuthorizeMapper.insert(ywUserAuthorize);
            return new Result(Result.sCode,"保存成功！",ywUserAuthorize);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Result(Result.sCode,"保存成功！",ywUserAuthorize);

    }

    @Override
    public Result updateOne(YwUserAuthorize ywUserAuthorize) {
        try {
            userAuthorizeMapper.updateByPrimaryKey(ywUserAuthorize);
            return new Result(Result.sCode,"修改成功！",ywUserAuthorize);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(Result.fCode,"修改失败！",ywUserAuthorize);
        }
    }

    @Override
    public Result delOne(String yuaId) {
             YwUserAuthorize ywUserAuthorize=userAuthorizeMapper.selectByPrimaryKey(yuaId);
        try {
            userAuthorizeMapper.deleteByPrimaryKey(yuaId);
            return new Result(Result.sCode,"删除成功！",ywUserAuthorize);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(Result.fCode,"删除失败！",ywUserAuthorize);
        }
    }
}
