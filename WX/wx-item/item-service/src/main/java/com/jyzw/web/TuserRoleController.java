package com.jyzw.web;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.jyzw.entity.Result;
import com.jyzw.entity.TUserRole;
import com.jyzw.service.TUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value="userRole",method={RequestMethod.GET,RequestMethod.POST})
public class TuserRoleController {
    @Autowired
    private TUserRoleService tUserRoleService;
    @RequestMapping("getList")
    public List<TUserRole> getList(){
        return tUserRoleService.getList();
    }
    @RequestMapping("getOne")
    public TUserRole getOne(String urId){
        return tUserRoleService.getOne(urId);
    }
    @PostMapping("saveUr")
    public Result saveUr(TUserRole tUserRole){
        return tUserRoleService.save(tUserRole);
    }
    @PostMapping("updateUr")
    public Result updateUr(TUserRole tUserRole){
        return tUserRoleService.update(tUserRole);
    }
    @RequestMapping("delUr")
    public Result  delUr(String urId){
        return tUserRoleService.delOne(urId);
    }

    @RequestMapping("getUR")
    public Result getUR(String userId){
      return tUserRoleService.getURole(userId);
    }

    @RequestMapping("getPageList")
    public PageInfo<TUserRole> getPageList(Integer pageNum,Integer pageSize,TUserRole tUserRole){
        return tUserRoleService.getPageList(pageNum,pageSize,tUserRole);
    }
    @PostMapping("saveList")
    public Result saveList(@RequestParam("list") String list){
        try {
            List<TUserRole> lisstur=(List<TUserRole>) JSON.parseArray(list,TUserRole.class);
            return tUserRoleService.saveList(lisstur);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(Result.fCode,"批量保存失败",list);
        }

    }
}
