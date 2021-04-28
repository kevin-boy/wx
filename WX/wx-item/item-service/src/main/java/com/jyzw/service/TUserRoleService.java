package com.jyzw.service;

import com.github.pagehelper.PageInfo;
import com.jyzw.entity.Result;
import com.jyzw.entity.TUserRole;

import java.util.List;

public interface TUserRoleService {
    Result save(TUserRole tUserRole);
    Result update(TUserRole tUserRole);
    List<TUserRole> getList();
    TUserRole getOne(String urId);
    Result delOne(String urId);
    Result getURole(String userId);
    PageInfo<TUserRole> getPageList(Integer page,Integer size,TUserRole tUserRole);
    Result  saveList(List<TUserRole> list);
}
