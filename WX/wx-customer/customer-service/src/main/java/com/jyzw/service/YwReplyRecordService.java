package com.jyzw.service;

import com.github.pagehelper.PageInfo;
import com.jyzw.entity.Result;
import com.jyzw.entity.YwReplayRecord;

import java.util.List;

public interface YwReplyRecordService {
    List<YwReplayRecord> getList();
    PageInfo getPageList(Integer pageNum,Integer pageSize,YwReplayRecord ywReplayRecord);
    Result saveOne(YwReplayRecord ywReplayRecord);
    Result updateOne(YwReplayRecord ywReplayRecord);
    Result delOne(String ycrId);
    YwReplayRecord getOne(String ycrId);
}
