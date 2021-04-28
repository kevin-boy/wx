package com.jyzw.web;

import com.github.pagehelper.PageInfo;
import com.jyzw.entity.Result;
import com.jyzw.entity.WxFriendsTB;
import com.jyzw.service.WxFriendsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="wxFriends",method={RequestMethod.GET,RequestMethod.POST})
public class WxFriendsController {
    @Autowired
    private WxFriendsService wxFriendsService;
    @RequestMapping("getList")
    public List<WxFriendsTB> getList(){
        return wxFriendsService.getList();
    }
    @RequestMapping("getPageList")
    public PageInfo getpageList(Integer pageNum,Integer pageSize,WxFriendsTB tb){
        return wxFriendsService.getPageList(pageNum,pageSize,tb);
    }
    @RequestMapping("getOne")
    public WxFriendsTB getone(String ywflId){
        return wxFriendsService.getOne(ywflId);
    }
    @RequestMapping("saveOne")
    public Result saveOne(WxFriendsTB tb){
        return wxFriendsService.saveOne(tb);
    }
    @RequestMapping("updateOne")
    public Result updateOne(WxFriendsTB tb){
        return wxFriendsService.updateOne(tb);
    }
    @RequestMapping("delOne")
    public Result delOne(String ywflId){
        return wxFriendsService.delOne(ywflId);
    }
}
