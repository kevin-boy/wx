package com.jyzw.service;

import com.github.pagehelper.PageInfo;
import com.jyzw.entity.Result;
import com.jyzw.entity.WxFriendsTB;

import java.util.List;

public interface WxFriendsService {
    List<WxFriendsTB> getList();
    WxFriendsTB getOne(String ywflId);
    PageInfo  getPageList(Integer pageNum,Integer pageSize,WxFriendsTB tb);
    Result delOne(String ywflId);
    Result updateOne(WxFriendsTB tb);
    Result saveOne(WxFriendsTB tb);
}
