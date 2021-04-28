package com.jyzw.service;

import com.github.pagehelper.PageInfo;
import com.jyzw.entity.Result;
import com.jyzw.entity.TgTg;

import java.util.List;

public interface TgTgService {
    Result save(TgTg tgTg);
    Result update(TgTg tgTg);
    TgTg getOne(String tgId);
    Result delOne(String tgId);
    List<TgTg> getList();
    PageInfo<TgTg> getByTj(Integer pageNum,Integer pageSize,TgTg tgTg);
}
