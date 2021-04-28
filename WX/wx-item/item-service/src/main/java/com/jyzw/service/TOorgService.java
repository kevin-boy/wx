package com.jyzw.service;

import com.github.pagehelper.PageInfo;
import com.jyzw.entity.Result;
import com.jyzw.entity.TOorg;

import java.util.List;

public interface TOorgService {
    List<TOorg> getList();
    Result saveOne(TOorg tOorg);
    Result updateOne(TOorg tOorg);
    TOorg getOne(String orgNo);
    Result delOne(String orgNo);
    PageInfo<TOorg> getPageInfo(Integer page,Integer size,TOorg tOorg);
}
