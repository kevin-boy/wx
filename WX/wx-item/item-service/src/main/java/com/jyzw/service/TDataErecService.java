package com.jyzw.service;

import com.github.pagehelper.PageInfo;
import com.jyzw.entity.Result;
import com.jyzw.entity.TDataErect;

import java.util.List;

public interface TDataErecService {
    List<TDataErect> getList();
    TDataErect getOne(String erectId);
    Result saveOne(TDataErect tDataErect);
    Result updateOne(TDataErect tDataErect);
    Result delone(String erectId);
    PageInfo<TDataErect>  getPageList(Integer page,Integer size,TDataErect tDataErect);
}
