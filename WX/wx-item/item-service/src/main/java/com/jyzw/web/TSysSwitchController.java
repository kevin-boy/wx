package com.jyzw.web;

import com.github.pagehelper.PageInfo;
import com.jyzw.entity.Result;
import com.jyzw.entity.TSysSwitch;
import com.jyzw.service.TSysSwitchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value="tsysSwitch",method={RequestMethod.GET,RequestMethod.POST})
public class TSysSwitchController {
    @Autowired
    private TSysSwitchService tSysSwitchService;

    @RequestMapping("getAll")
    public List<TSysSwitch>  getAll(){
       return tSysSwitchService.getList();
    }
    @RequestMapping("getSW")
    public TSysSwitch getOne(String tssId){
        return tSysSwitchService.getOne(tssId);
    }
    @RequestMapping("delSW")
    public Result delSW(String tssId){
        return tSysSwitchService.delOne(tssId);
    }
    @PostMapping("updateSW")
    public Result updateSW(TSysSwitch tSysSwitch){
      return  tSysSwitchService.updateOne(tSysSwitch);
    }
    @PostMapping("saveSW")
    public Result saveSW(TSysSwitch tSysSwitch){
        return tSysSwitchService.saveOne(tSysSwitch);
    }
    @GetMapping("getPageList")
    public PageInfo<TSysSwitch> getList(Integer pageNum,Integer pageSize,TSysSwitch tSysSwitch){
        return tSysSwitchService.getPageList(pageNum,pageSize,tSysSwitch);
    }

}
