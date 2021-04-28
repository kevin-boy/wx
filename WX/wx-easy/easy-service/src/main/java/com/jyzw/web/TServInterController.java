package com.jyzw.web;

import com.github.pagehelper.PageInfo;
import com.jyzw.entity.Result;
import com.jyzw.entity.TServiceInterfaceTB;
import com.jyzw.service.TServInterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="tServIn",method= {RequestMethod.GET,RequestMethod.POST})
public class TServInterController {
    @Autowired
    private TServInterService tServInterService;
    @RequestMapping("getList")
    public List<TServiceInterfaceTB> getList(){
        return tServInterService.getList();
    }
    @RequestMapping("getOne")
    public TServiceInterfaceTB getOne(String siId){
        return tServInterService.getTservInter(siId);
    }
    @RequestMapping("getPageList")
    public PageInfo getPageList(Integer pageNum,Integer pageSize,TServiceInterfaceTB tServiceInterfaceTB){
        return tServInterService.getPageList(pageNum,pageSize,tServiceInterfaceTB);
    }
    @RequestMapping("delOne")
    public Result delone(String siId){
        return tServInterService.delOne(siId);
    }
    @RequestMapping("updateOne")
    public Result updateOne(TServiceInterfaceTB tServiceInterfaceTB){
        return tServInterService.updateOne(tServiceInterfaceTB);
    }
    @RequestMapping("saveOne")
    public Result saveOne(TServiceInterfaceTB tServiceInterfaceTB){
        return tServInterService.saveOne(tServiceInterfaceTB);
    }
}
