package com.jyzw.service;

import com.github.pagehelper.PageInfo;

import com.jyzw.entity.Result;
import com.jyzw.entity.TClientInTB;

import java.util.List;

public interface TClientTBService {
    List<TClientInTB> getList();
    TClientInTB getOne(String ciId);
    PageInfo<TClientInTB> getByTJ(Integer pageNum,Integer pageSize,TClientInTB tClientInTB);
    Result save(TClientInTB tClientInTB);
    Result update(TClientInTB tClientInTB);
    Result delOne(String ciId);
}
