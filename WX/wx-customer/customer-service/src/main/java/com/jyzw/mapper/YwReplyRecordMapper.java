package com.jyzw.mapper;

import com.github.pagehelper.PageInfo;
import com.jyzw.entity.YwReplayRecord;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface YwReplyRecordMapper {
List<YwReplayRecord>  getList();
List<YwReplayRecord> getListByTJ(YwReplayRecord ywReplayRecord);
YwReplayRecord getOne(String ycrId);
void delone(String ycrId);
void saveOne(YwReplayRecord ywReplayRecord);
void updateOne(YwReplayRecord ywReplayRecord);
}
