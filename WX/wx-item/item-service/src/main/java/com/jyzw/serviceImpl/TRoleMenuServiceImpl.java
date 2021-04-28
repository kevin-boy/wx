package com.jyzw.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jyzw.entity.Result;
import com.jyzw.entity.TMenu;
import com.jyzw.entity.TRoleMenu;
import com.jyzw.mapper.TMenuMapper;
import com.jyzw.mapper.TRoleMenuMapper;
import com.jyzw.service.TRoleMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class TRoleMenuServiceImpl implements TRoleMenuService {
    @Autowired
    private TRoleMenuMapper tRoleMenuMpper;
    @Autowired
    private TMenuMapper tMenuMapper;
    @Override
    public List<TRoleMenu> getList() {
        try {
            List<TRoleMenu> list = tRoleMenuMpper.getList();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            TRoleMenu tRoleMenu=new TRoleMenu();
            tRoleMenu.setMenuName(Result.fCode);
            tRoleMenu.setRoleName("查询列表失败");
            List<TRoleMenu> list1=new ArrayList<>();
            list1.add(tRoleMenu);
            return list1;
        }
    }

    @Override
    public TRoleMenu getOne(String rmId) {
        try {
            TRoleMenu one = tRoleMenuMpper.getOne(rmId);
            return one;
        } catch (Exception e) {
            e.printStackTrace();
            TRoleMenu tRoleMenu=new TRoleMenu();
            tRoleMenu.setRoleName(Result.fCode);
            tRoleMenu.setMenuName("根据id查询失败");
            return tRoleMenu;
        }

    }

    @Override
    public Result saveOne(TRoleMenu tRoleMenu) {
        try {
            tRoleMenuMpper.delOne(tRoleMenu.getRmId());
            tRoleMenuMpper.saveOne(tRoleMenu);
            return new Result(Result.sCode,"保存成功！",tRoleMenu);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(Result.fCode,"保存失败！",tRoleMenu);
        }

    }

    @Override
    public Result updateOne(TRoleMenu tRoleMenu) {
        try {
            tRoleMenuMpper.updateOne(tRoleMenu);
            return new Result(Result.sCode,"修改成功",tRoleMenu);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(Result.fCode,"修改失败",tRoleMenu);
        }

    }

    @Override
    public Result delOne(String rmId) {
        TRoleMenu one= null;
        try {
            one = tRoleMenuMpper.getOne(rmId);
            tRoleMenuMpper.delOne(rmId);
            return new Result(Result.sCode,"删除成功",one);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(Result.fCode,"删除失败",one);
        }

    }

    @Override
    public Set<TMenu> getMuList(String roleId) {
        List<TRoleMenu> list=tRoleMenuMpper.getTMByRid(roleId);
        Set<TMenu> set=new HashSet<>();
        if(list.size()==0) {
            Set<TMenu>  set1=new HashSet<>();
            TMenu tMenu1=new TMenu();
            tMenu1.setMenuId(Result.fCode);
            tMenu1.setMenuName("该角色无菜单信息");
            set1.add(tMenu1);
            return set1;
        }

            for (TRoleMenu tt : list) {
                TMenu tMenu = tMenuMapper.getOneCd(tt.getMenuId());
                set.add(tMenu);
            }
            return set;
    }

    @Override
    public PageInfo<TRoleMenu> getpageList(Integer pageNum,Integer pageSize,TRoleMenu tRoleMenu) {
        PageHelper.startPage(pageNum,pageSize);
        List<TRoleMenu> list=tRoleMenuMpper.getTRList(tRoleMenu);
        PageInfo<TRoleMenu> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public Result saveList(List<TRoleMenu> list) {
        if(list.size()==0){
            return new Result(Result.fCode,"批量保存失败！",list);
        }
        try {
            for(TRoleMenu t:list){
                tRoleMenuMpper.delOne(t.getRmId());
                tRoleMenuMpper.saveOne(t);
            }
            return new Result(Result.sCode,"批量保存成功！",list);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(Result.fCode,"批量保存失败！",list);
        }

    }
}
