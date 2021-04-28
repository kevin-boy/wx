package com.jyzw.service;

import com.github.pagehelper.PageInfo;
import com.jyzw.entity.Result;
import com.jyzw.entity.TcMp;

import java.util.List;

public interface TcMpService {
    Result save(TcMp tcMp);
    Result update(TcMp tcMp);
    List<TcMp> getList();
    PageInfo<TcMp> getByTJ(Integer pageNum,Integer pageSize,TcMp tcMp);
    Result delOne(String mpId);
    TcMp getOne(String mpId);
}
