package com.jyzw.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jyzw.entity.Result;
import com.jyzw.entity.TRole;
import com.jyzw.entity.TUserRole;
import com.jyzw.mapper.TRoleMapper;
import com.jyzw.mapper.TUserRoleMapper;
import com.jyzw.service.TUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class TUserRoleServiceImpl implements TUserRoleService {
   @Autowired
   private TUserRoleMapper tUserRoleMapper;
   @Autowired
   private TRoleMapper tRoleMapper;
    @Override
    public Result save(TUserRole tUserRole) {
        try {
            tUserRoleMapper.delur(tUserRole);
            tUserRoleMapper.save(tUserRole);
            return new Result(Result.sCode,"保存成功！",tUserRole);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(Result.fCode,"保存失败！",tUserRole);
        }

    }

    @Override
    public Result  update(TUserRole tUserRole) {
        try {
            tUserRoleMapper.update(tUserRole);
            return new Result(Result.sCode,"修改成功！",tUserRole);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(Result.fCode,"修改失败！",tUserRole);
        }

    }

    @Override
    public List<TUserRole> getList() {

        try {
            List<TUserRole> list = tUserRoleMapper.getList();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            List<TUserRole> list1=new ArrayList<>();
            TUserRole tUserRole=new TUserRole();
            tUserRole.setRoleName(Result.fCode);
            tUserRole.setUserName("查询用户角色列表失败！");
            list1.add(tUserRole);
            return list1;
        }
    }

    @Override
    public TUserRole getOne(String urId) {
        try {
            TUserRole one = tUserRoleMapper.getOne(urId);
            return one;
        } catch (Exception e) {
            e.printStackTrace();
            TUserRole tUserRole=new TUserRole();
            tUserRole.setUserName(Result.fCode);
            tUserRole.setRoleName("根据id查询用户角色信息");
            tUserRole.setExplain("失败");
            return tUserRole;
        }
    }

    @Override
    public Result delOne(String urId) {
        TUserRole tUserRole= null;
        try {
            tUserRole = tUserRoleMapper.getOne(urId);
            tUserRoleMapper.delOne(urId);
            return new Result(Result.fCode,"删除成功！",tUserRole);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(Result.sCode,"删除失败！",tUserRole);
        }

    }

    @Override
    public Result getURole(String userId) {
        List<TUserRole> list=tUserRoleMapper.getUR(userId);
        if(list.size()==0){
            return new Result(Result.sCode,"该用户不存在角色",new TUserRole());
        }
        /*List<TRole>  rList=new ArrayList<>();*/
        Set<TRole> set=new HashSet<>();
        for(TUserRole tt:list){
             TRole one = tRoleMapper.getOne(tt.getRoleId());
             set.add(one);
        }
        return new Result(Result.sCode,"查询成功",set);
    }

    @Override
    public PageInfo<TUserRole> getPageList(Integer page,Integer size,TUserRole tUserRole) {
        PageHelper.startPage(page,size);
        List<TUserRole> list=tUserRoleMapper.getTRList(tUserRole);
        PageInfo<TUserRole> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public Result saveList(List<TUserRole> list) {
        try {
            if(list.size()==0){
                return new Result(Result.sCode,"保存数据为空！",list);
            }
            for(TUserRole r:list){
                   tUserRoleMapper.delur(r);
                   tUserRoleMapper.save(r);
            }
            return new Result(Result.sCode,"批量保存成功！",list);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(Result.fCode,"批量保存失败！",list);
        }

    }
}
