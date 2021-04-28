package com.jyzw.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jyzw.entity.Result;
import com.jyzw.entity.WxFriendsTB;
import com.jyzw.mapper.WxFriendsMapper;
import com.jyzw.service.WxFriendsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WxFriendsServiceImpl implements WxFriendsService {

   @Autowired
   private WxFriendsMapper wxFriendsMapper;
   @Override
    public List<WxFriendsTB> getList() {
       try {
           List<WxFriendsTB> list=  wxFriendsMapper.getList();
           return list;
       } catch (Exception e) {
           e.printStackTrace();
           List<WxFriendsTB> lista=new ArrayList<>();
           WxFriendsTB tb=new WxFriendsTB();
           tb.setTypeCode(Result.sCode);
           tb.setTypeName("查询列表失败！");
           lista.add(tb);
           return lista;
       }
   }

    @Override
    public WxFriendsTB getOne(String ywflId) {
        try {
            WxFriendsTB one = wxFriendsMapper.getOne(ywflId);
            return one;
        } catch (Exception e) {
            e.printStackTrace();
            WxFriendsTB tb=new WxFriendsTB();
            tb.setTypeCode(Result.fCode);
            tb.setTypeName("查询失败！");
            return tb;
        }
    }

    @Override
    public PageInfo getPageList(Integer pageNum, Integer pageSize, WxFriendsTB tb) {
        try {
            PageHelper.startPage(pageNum,pageSize);
            List<WxFriendsTB> list=wxFriendsMapper.getListByTJ(tb);
            PageInfo pageInfo=new PageInfo(list);
            return pageInfo;
        } catch (Exception e) {
            e.printStackTrace();
            List<WxFriendsTB> lista=new ArrayList<>();
            WxFriendsTB wxFriendsTB=new WxFriendsTB();
            wxFriendsTB.setTypeCode(Result.fCode);
            wxFriendsTB.setTypeName("分页查询失败！");
            lista.add(wxFriendsTB);
            PageInfo pageInfo2=new PageInfo(lista);
            return pageInfo2;
        }
    }

    @Override
    public Result delOne(String ywflId) {
            WxFriendsTB wxFriendsTB=wxFriendsMapper.getOne(ywflId);
           if(wxFriendsTB!=null){
               wxFriendsMapper.delOne(ywflId);
               return new Result(Result.sCode,"删除成功！",wxFriendsTB);
           }else{
               return new Result(Result.fCode,"删除失败！",wxFriendsTB);
           }
    }

    @Override
    public Result updateOne(WxFriendsTB tb) {
        try {
            wxFriendsMapper.updateOne(tb);
            return new Result(Result.sCode,"修改成功！",tb);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(Result.fCode,"修改失败！",tb);
        }
    }

    @Override
    public Result saveOne(WxFriendsTB tb) {
        try {
            wxFriendsMapper.saveOne(tb);
            return new Result(Result.sCode,"保存成功！",tb);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(Result.fCode,"保存失败",tb);
        }
    }
}
