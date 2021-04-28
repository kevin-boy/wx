package com.jyzw.service;

import com.github.pagehelper.PageInfo;
import com.jyzw.entity.Result;
import com.jyzw.entity.WxFriendsTB;
import com.jyzw.entity.WxMsgRecord;

import java.util.List;

public interface WxMsgRecordService {
    List<WxMsgRecord> getList();
    WxMsgRecord getOne(String ywmrId);
    Result  delOne(String ywmrId);
    Result updateOne(WxMsgRecord wxMsgRecord);
    Result saveOne(WxMsgRecord wxMsgRecord);
    PageInfo getPageList(Integer pageNum,Integer pageSize,WxMsgRecord wxMsgRecord);

}
