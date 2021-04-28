package com.jyzw.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jyzw.entity.Result;
import com.jyzw.entity.TMenu;
import com.jyzw.mapper.TMenuMapper;
import com.jyzw.service.TMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TMenuServiceimpl implements TMenuService {
    @Autowired
    private TMenuMapper tMenuMapper;
    @Override
    public Result saveOne(TMenu tMenu) {
        try {
            tMenuMapper.saveOne(tMenu);
            return new Result (Result.sCode,"保存成功！",tMenu);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result (Result.fCode,"保存失败！",tMenu);
        }

    }

    @Override
    public Result  updateOne(TMenu tMenu) {
        try {
            tMenuMapper.updateOne(tMenu);
            return new Result(Result.sCode,"修改成功！",tMenu);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result (Result.fCode,"修改失败！",tMenu);
        }

    }

    @Override
    public List<TMenu> getOne(String menuId) {
        List<TMenu> one = null;
        try {
            one = tMenuMapper.getOne(menuId);
            return one;
        } catch (Exception e) {
            e.printStackTrace();
            List<TMenu>  list=new ArrayList<>();
            TMenu tMenu=new TMenu();
            tMenu.setMenuId(Result.fCode);
            tMenu.setMenuName("根据id查询子菜单列表失败");
            list.add(tMenu);
            return list;
        }
    }

    @Override
    public Result  delOne(String menuId) {
    TMenu tMenu=tMenuMapper.getOneCd(menuId);
    if(tMenu!=null){
        String level=tMenu.getLevel();
        if(level.equals("1")){
            List<TMenu> tMenu2=tMenuMapper.getOne(menuId);
            if(tMenu2.size()==0){
                tMenuMapper.delOne(menuId);
                return new Result(Result.sCode,"删除主菜单成功！",tMenu);
            }else{
                return new Result(Result.fCode,"有子菜单不能删除！",tMenu);
            }
        }else if(level.equals("2")){
            tMenuMapper.delOne(menuId);
            return new Result(Result.sCode,"删除子菜单成功！",tMenu);
        }
    }else{
        return new Result(Result.fCode,"菜单不存在",tMenu);
    }
        return new Result(Result.fCode,"未知错误",tMenu);
    }

    @Override
    public List<TMenu> getMenuList() {
        try {
            List<TMenu> menuList = tMenuMapper.getMenuList();
            return menuList;
        } catch (Exception e) {
            e.printStackTrace();
            List<TMenu>  list=new ArrayList<>();
            TMenu tMenu=new TMenu();
            tMenu.setMenuId(Result.fCode);
            tMenu.setMenuName("查询列表失败!");
            list.add(tMenu);
            return list;
        }
    }

    @Override
    public TMenu getOneCd(String menuId) {
        try {
            TMenu oneCd = tMenuMapper.getOneCd(menuId);
            return oneCd;
        } catch (Exception e) {
            e.printStackTrace();
            TMenu tMenu=new TMenu();
            tMenu.setMenuId(Result.fCode);
            tMenu.setMenuName("根据id查询菜单信息失败！");
            return tMenu;
        }

    }

    @Override
    public PageInfo<TMenu> getMenuPage(Integer pageNum,Integer pageSize,TMenu tMenu) {
        PageHelper.startPage(pageNum,pageSize);
        List<TMenu> list=tMenuMapper.getPageMenu(tMenu);
        PageInfo<TMenu> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }
}
