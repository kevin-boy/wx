package com.jyzw.service;

import com.github.pagehelper.PageInfo;
import com.jyzw.entity.Result;
import com.jyzw.entity.TMenu;

import java.util.List;

public interface TMenuService {
    Result saveOne(TMenu tMenu);
    Result  updateOne(TMenu tMenu);
    List<TMenu> getOne(String menuId);
    Result delOne(String menuId);
    List<TMenu> getMenuList();
    TMenu getOneCd(String menuId);
    PageInfo<TMenu>  getMenuPage(Integer pageNum,Integer pageSize,TMenu tMenu);
}
