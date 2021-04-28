package com.jyzw.web;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.jyzw.entity.Result;
import com.jyzw.entity.TServiceInterfaceMonitorTB;
import com.jyzw.service.TServInterMonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="tServInterMon",method={ RequestMethod.GET,RequestMethod.POST})
public class TServInterMonController {
    @Autowired
    private TServInterMonService tServInterMonService;
    @RequestMapping("getList")
    public List<TServiceInterfaceMonitorTB> getList(){
        return tServInterMonService.getList();
    }
    @RequestMapping("getPageList")
    public PageInfo gerPageList(Integer pageNum,Integer pageSize,TServiceInterfaceMonitorTB tb){
        return tServInterMonService.getPageList(pageNum,pageSize,tb);
    }
    @RequestMapping("getOne")
    public TServiceInterfaceMonitorTB getOne(String simId){
        return tServInterMonService.getOne(simId);
    }
    @RequestMapping("delOne")
    public Result delOne(String simId){
        return tServInterMonService.delOne(simId);
    }
    @RequestMapping("saveOne")
    public Result saveOne(TServiceInterfaceMonitorTB tb){
    return     tServInterMonService.saveOne(tb);
    }
    @RequestMapping("updateOne")
    public Result updateOne(TServiceInterfaceMonitorTB tb){
        return tServInterMonService.updateOne(tb);
    }
}
