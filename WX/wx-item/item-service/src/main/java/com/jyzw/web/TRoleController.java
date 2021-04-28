package com.jyzw.web;

import com.jyzw.entity.Result;
import com.jyzw.entity.TRole;
import com.jyzw.service.TRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin
@RestController
@RequestMapping(value="role",method={RequestMethod.GET,RequestMethod.POST})
public class TRoleController {
    @Autowired
    private TRoleService tRoleService;

    @RequestMapping("getList")
    public List<TRole> getList(){
        return tRoleService.getRolel();
    }

    @RequestMapping("getOne")
    public TRole getOne(String roleId){
        return tRoleService.getOne(roleId);
    }
    @PostMapping("saveOne")
    public Result saveOne(TRole tRole){
        return tRoleService.saveOne(tRole);
    }
    @PostMapping("updateOne")
    public Result updateOne(TRole tRole){
        return tRoleService.updateOne(tRole);
    }
    @RequestMapping("delOne")
    public Result delOne(String roleId){
        return tRoleService.delOne(roleId);
    }

}
