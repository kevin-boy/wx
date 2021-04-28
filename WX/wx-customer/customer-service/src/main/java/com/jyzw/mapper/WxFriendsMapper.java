package com.jyzw.mapper;

import com.jyzw.entity.WxFriendsTB;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WxFriendsMapper  {
 List<WxFriendsTB> getList();
 List<WxFriendsTB> getListByTJ(WxFriendsTB tb);
 WxFriendsTB getOne(String ywflId);
 void saveOne(WxFriendsTB tb);
 void updateOne(WxFriendsTB tb);
 void delOne(String ywflId);
}
