package com.jyzw.web;

import com.github.pagehelper.PageInfo;
import com.jyzw.entity.Result;
import com.jyzw.entity.TOorg;
import com.jyzw.service.TOorgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin
@RestController
@RequestMapping(value="torg",method={RequestMethod.GET,RequestMethod.POST})
public class TOorgController {
    @Autowired
    private TOorgService tOorgService;
    @RequestMapping("getAll")
    public List<TOorg> getAll(){
     return   tOorgService.getList();
    }
    @RequestMapping("getOne")
    public TOorg getOne(String orgNo){
        return tOorgService.getOne(orgNo);
    }
    @PostMapping("saveTOrg")
    public Result saveTorg(TOorg tOorg){
        return tOorgService.saveOne(tOorg);
    }
    @PostMapping("updateTorg")
    public Result updateTOorg(TOorg tOorg){
        return tOorgService.updateOne(tOorg);
    }
    @RequestMapping("delOne")
    public Result delOne(String orgNo){
        return tOorgService.delOne(orgNo);
    }
    @GetMapping("getPageList")
    public PageInfo<TOorg>  getList(Integer pageNum,Integer pageSize,TOorg tOorg){
        return tOorgService.getPageInfo(pageNum,pageSize,tOorg);
    }
}
