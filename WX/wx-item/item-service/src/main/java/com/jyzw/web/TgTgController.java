package com.jyzw.web;

import com.github.pagehelper.PageInfo;
import com.jyzw.entity.Result;
import com.jyzw.entity.TgTg;
import com.jyzw.service.TgTgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value="tgtg",method={RequestMethod.GET,RequestMethod.POST})
public class TgTgController {
    @Autowired
    private TgTgService tgTgService;
    @RequestMapping("getList")
    public List<TgTg>  getList(){
        return tgTgService.getList();
    }
    @RequestMapping("getPageList")
    public PageInfo getpage(Integer pageNum,Integer pageSize,TgTg tgTg){
        return tgTgService.getByTj(pageNum,pageSize,tgTg);
    }
    @RequestMapping("getOne")
    public TgTg getOne(String tgId){
        return tgTgService.getOne(tgId);
    }
    @RequestMapping("delOne")
    public Result delOne(String tgId){
        return tgTgService.delOne(tgId);
    }
    @PostMapping("saveOne")
    public Result saveOne(TgTg tgTg){
        return tgTgService.save(tgTg);
    }
    @PostMapping("updateOne")
    public Result update(TgTg tgTg){
        return tgTgService.update(tgTg);
    }
}
