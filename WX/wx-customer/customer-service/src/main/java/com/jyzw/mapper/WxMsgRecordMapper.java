package com.jyzw.mapper;

import com.jyzw.entity.WxMsgRecord;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface WxMsgRecordMapper extends Mapper<WxMsgRecord> {
    List<WxMsgRecord> queryListByTJ(WxMsgRecord wxMsgRecord);
}
