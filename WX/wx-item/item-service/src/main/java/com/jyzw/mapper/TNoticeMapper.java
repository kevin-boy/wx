package com.jyzw.mapper;

import com.jyzw.entity.TNotice;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface TNoticeMapper  {
    List<TNotice>  getList();
    TNotice getOne(String noticeId);
    void save(TNotice tNotice);
    void update(TNotice tNotice);
    void delOne(String noticeId);
    List<TNotice> getTNList(TNotice tNotice);
}
