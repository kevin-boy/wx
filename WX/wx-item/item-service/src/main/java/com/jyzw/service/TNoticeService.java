package com.jyzw.service;

import com.github.pagehelper.PageInfo;
import com.jyzw.entity.Result;
import com.jyzw.entity.TNotice;

import java.util.List;

public interface TNoticeService {
List<TNotice> getList();
TNotice getOne(String noticeId);
Result saveTNotice(TNotice tNotice);
Result updateTNotice(TNotice tNotice);
Result delOne(String noticeId);
PageInfo<TNotice> getPageList(Integer pageNum, Integer pageSize, TNotice tNotice);
}
