package com.jyzw.mapper;


import com.jyzw.entity.TMenu;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface TMenuMapper {
void  saveOne(TMenu tMenu);
void updateOne(TMenu tMenu);
List<TMenu> getOne(String menuId);
TMenu getOneCd(String menuId);
void delOne(String menuId);
List<TMenu> getMenuList();
List<TMenu> getPageMenu(TMenu tMenu);
}
