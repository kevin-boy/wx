package com.jyzw.web;

import com.github.pagehelper.PageInfo;
import com.jyzw.entity.Result;
import com.jyzw.entity.TClientInTB;
import com.jyzw.service.TClientTBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value="tclientIn",method={RequestMethod.GET,RequestMethod.POST})
public class TClientInController {
    @Autowired
    private TClientTBService tClientTBService;
    @RequestMapping("getPageList")
    public PageInfo getPageInfo(Integer pageNum, Integer pageSize, TClientInTB tClientInTB){
       return tClientTBService.getByTJ(pageNum,pageSize,tClientInTB);
    }
    @RequestMapping("getList")
    public List<TClientInTB> getList(){
        return tClientTBService.getList();
    }
    @RequestMapping("getOne")
    public TClientInTB getOne(String ciId){
        return tClientTBService.getOne(ciId);
    }
    @RequestMapping("saveOne")
    public Result saveone(TClientInTB tClientInTB){
        return tClientTBService.save(tClientInTB);
    }
    @RequestMapping("updateOne")
    public Result update(TClientInTB tClientInTB){
        return tClientTBService.update(tClientInTB);
    }
    @RequestMapping("delOne")
    public Result delOne(String ciId){
        return tClientTBService.delOne(ciId);
    }

}
