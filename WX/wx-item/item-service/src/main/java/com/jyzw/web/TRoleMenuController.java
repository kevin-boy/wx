package com.jyzw.web;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.jyzw.entity.Result;
import com.jyzw.entity.TMenu;
import com.jyzw.entity.TRoleMenu;
import com.jyzw.service.TRoleMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;


@CrossOrigin
@RestController
@RequestMapping(value="roleMenu",method={RequestMethod.GET,RequestMethod.POST})
public class TRoleMenuController {
    @Autowired
    private TRoleMenuService tRoleMenuService;
    @RequestMapping("getAll")
    public List<TRoleMenu> getAll(){
        return tRoleMenuService.getList();
    }
    @RequestMapping("getOne")
    public TRoleMenu getOne(String rmId){
        return tRoleMenuService.getOne(rmId);
    }
    @PostMapping("saveRm")
    public Result saveRm(TRoleMenu tRoleMenu){
        return tRoleMenuService.saveOne(tRoleMenu);
    }
    @PostMapping("updateRm")
    public Result updateOne(TRoleMenu tRoleMenu){
        return tRoleMenuService.updateOne(tRoleMenu);
    }
    @RequestMapping ("delOne")
    public Result delOne(String rmId){
        return tRoleMenuService.delOne(rmId);
    }
    @RequestMapping("getRM")
    public Set<TMenu> getRM(String roleId){
    return  tRoleMenuService.getMuList(roleId);
    }
    @GetMapping("getPageList")
    public PageInfo<TRoleMenu> getPageList(@RequestParam("pageNum")Integer page,
                                           @RequestParam("pageSize")Integer size,
            TRoleMenu tRoleMenu){
        return tRoleMenuService.getpageList(page,size,tRoleMenu);
    }
    @PostMapping("saveList")
    public Result saveList(@RequestParam("list")String list){
        List<TRoleMenu> list1=(List<TRoleMenu>) JSON.parseArray(list,TRoleMenu.class);
       return tRoleMenuService.saveList(list1);
    }
}
