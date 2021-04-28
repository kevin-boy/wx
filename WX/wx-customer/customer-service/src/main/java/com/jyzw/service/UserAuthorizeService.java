package com.jyzw.service;


import com.github.pagehelper.PageInfo;
import com.jyzw.entity.Result;
import com.jyzw.entity.YwUserAuthorize;

import java.util.List;

public interface UserAuthorizeService {
List<YwUserAuthorize>  getList();
YwUserAuthorize getOne(String yuaId);
PageInfo getPageList(Integer pageNum,Integer pageSize,YwUserAuthorize ywUserAuthorize);
Result saveOne(YwUserAuthorize ywUserAuthorize);
Result updateOne(YwUserAuthorize ywUserAuthorize);
Result delOne(String yuaId);
}
