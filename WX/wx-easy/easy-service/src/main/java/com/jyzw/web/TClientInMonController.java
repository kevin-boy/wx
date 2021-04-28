package com.jyzw.web;

import com.github.pagehelper.PageInfo;
import com.jyzw.entity.Result;
import com.jyzw.entity.TClientIntMonTB;
import com.jyzw.service.TClientInMonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value="tInMon",method={RequestMethod.GET,RequestMethod.POST})
public class TClientInMonController {
    @Autowired
    private TClientInMonService tClientInMonService;
    @RequestMapping("getPageList")
    public PageInfo getPageList(Integer pageNum, Integer pageSize, TClientIntMonTB tClientIntMonTB){
        return tClientInMonService.getByTj(pageNum,pageSize,tClientIntMonTB);
    }
    @RequestMapping("getOne")
    public TClientIntMonTB getOne(String cimId){
        return tClientInMonService.getOne(cimId);
    }
    @RequestMapping("saveOne")
    public Result save(TClientIntMonTB tClientIntMonTB){
        return tClientInMonService.save(tClientIntMonTB);
    }
    @RequestMapping("updateOne")
    public Result updateOne(TClientIntMonTB tClientIntMonTB){
        return tClientInMonService.update(tClientIntMonTB);
    }
    @RequestMapping("delOne")
    public Result delOne(String cimId){
        return tClientInMonService.delOne(cimId);
    }
    @RequestMapping("getList")
    public List<TClientIntMonTB> getList(){
        return tClientInMonService.getList();
    }
}
