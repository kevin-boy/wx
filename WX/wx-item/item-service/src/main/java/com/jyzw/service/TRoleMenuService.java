package com.jyzw.service;

import com.github.pagehelper.PageInfo;
import com.jyzw.entity.Result;
import com.jyzw.entity.TMenu;
import com.jyzw.entity.TRoleMenu;

import java.util.List;
import java.util.Set;

public interface TRoleMenuService {
    List<TRoleMenu> getList();
    TRoleMenu getOne(String rmId);
    Result  saveOne(TRoleMenu tRoleMenu);
    Result  updateOne(TRoleMenu tRoleMenu);
    Result delOne(String rmId);
   Set<TMenu> getMuList(String roleId);
   PageInfo<TRoleMenu> getpageList(Integer pageNum,Integer pageSize,TRoleMenu tRoleMenu);
   Result saveList(List<TRoleMenu> list);
}
