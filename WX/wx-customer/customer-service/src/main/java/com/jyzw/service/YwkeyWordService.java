package com.jyzw.service;

import com.github.pagehelper.PageInfo;
import com.jyzw.entity.Result;
import com.jyzw.entity.YwKeyWord;

import java.util.List;

public interface YwkeyWordService {
List<YwKeyWord> getList();
PageInfo getPageList(Integer pageNum,Integer pageSize,YwKeyWord ywKeyWord);
YwKeyWord getOne(String ykwId);
Result saveOne(YwKeyWord ywKeyWord);
Result updateOne(YwKeyWord ywKeyWord);
Result delOne(String ykwId);
}
