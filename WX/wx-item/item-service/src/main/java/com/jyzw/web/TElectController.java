package com.jyzw.web;

import com.github.pagehelper.PageInfo;
import com.jyzw.entity.Result;
import com.jyzw.entity.TDataErect;
import com.jyzw.service.TDataErecService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value="telect",method={RequestMethod.GET,RequestMethod.POST})
public class TElectController {
@Autowired
    private TDataErecService tDataErecService;

@RequestMapping("getList")
    public List<TDataErect> getList(){
    return tDataErecService.getList();
}
@PostMapping("saveElec")
    public Result saveOne(TDataErect tDataErect){
    return tDataErecService.saveOne(tDataErect);
}
@PostMapping("updateElec")
    public Result updateElec(TDataErect tDataErect){
    return tDataErecService.updateOne(tDataErect);
}
@RequestMapping("getElec")
    public TDataErect getElec(String erectId){
    return tDataErecService.getOne(erectId);
}
@RequestMapping("delElec")
    public Result  delElec(String erectId){
    return tDataErecService.delone(erectId);
}
   @GetMapping("getPageList")
    public PageInfo<TDataErect>  getPageList(Integer pageNum,Integer pageSize,TDataErect tDataErect){
    return tDataErecService.getPageList(pageNum,pageSize,tDataErect);
   }
}
