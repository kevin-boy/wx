package com.jyzw.serviceImpl;

import com.jyzw.entity.Result;
import com.jyzw.entity.TRole;
import com.jyzw.mapper.TRoleMapper;
import com.jyzw.service.TRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class TRoleServiceImpl implements TRoleService {
 @Autowired
 private TRoleMapper tRoleMapper;
    @Override
    public List<TRole> getRolel() {
        try {
            List<TRole> roleL = tRoleMapper.getRoleL();
            return roleL;
        } catch (Exception e) {
            e.printStackTrace();
            List<TRole> list=new ArrayList<>();
            TRole tRole=new TRole();
            tRole.setRoleId(Result.fCode);
            tRole.setRoleName("查询角色列表失败");
            list.add(tRole);
            return list;
        }
    }

    @Override
    public TRole getOne(String roleId) {
        try {
            TRole one = tRoleMapper.getOne(roleId);
            return one;
        } catch (Exception e) {
            e.printStackTrace();
            TRole tRole=new TRole();
            tRole.setRoleId(Result.fCode);
            tRole.setRoleName("根据id查询角色信息失败！");
            return  tRole;
        }
    }

    @Override
    public Result saveOne(TRole tRole) {
        try {
            tRoleMapper.saveOne(tRole);
            return new Result(Result.sCode,"保存成功！",tRole);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(Result.fCode,"保存失败！",tRole);
        }

    }

    @Override
    public Result updateOne(TRole tRole) {
        try {
            tRoleMapper.updateOne(tRole);
            return new Result(Result.sCode,"修改成功！",tRole);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(Result.fCode,"修改失败！",tRole);
        }

    }

    @Override
    public Result delOne(String roleId) {
        TRole one = null;
        try {
            one = tRoleMapper.getOne(roleId);
            tRoleMapper.delOne(roleId);
            return new Result(Result.sCode,"删除成功！",one);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(Result.fCode,"删除失败！",one);
        }

    }
}
