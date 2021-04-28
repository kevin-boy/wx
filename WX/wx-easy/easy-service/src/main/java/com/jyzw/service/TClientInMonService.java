package com.jyzw.service;

import com.github.pagehelper.PageInfo;
import com.jyzw.entity.Result;
import com.jyzw.entity.TClientIntMonTB;

import java.util.List;

public interface TClientInMonService {
    List<TClientIntMonTB> getList();
    TClientIntMonTB getOne(String cimId);
    Result save(TClientIntMonTB tClientIntMonTB);
    Result update(TClientIntMonTB tClientIntMonTB);
    PageInfo<TClientIntMonTB> getByTj(Integer pageNum,Integer pageSize,TClientIntMonTB tClientIntMonTB);
    Result delOne(String cimId);
}
