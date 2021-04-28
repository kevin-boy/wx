package com.jyzw.web;

import com.github.pagehelper.PageInfo;
import com.jyzw.entity.Result;
import com.jyzw.entity.TcMp;
import com.jyzw.service.TcMpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value="tcmp",method={RequestMethod.GET,RequestMethod.POST})
public class TcMapController {
    @Autowired
    private TcMpService tcMpService;
    @RequestMapping("saveOne")
    public Result save(TcMp tcMp){
      return  tcMpService.save(tcMp);
    }
    @RequestMapping("updateOne")
    public Result updateOne(TcMp tcMp){
        return tcMpService.update(tcMp);
    }
    @RequestMapping("getList")
    public List<TcMp> getList(){
        return tcMpService.getList();
    }
    @RequestMapping("getPageList")
    public PageInfo getPage(Integer pageNum,Integer pageSize,TcMp tcMp){
        return tcMpService.getByTJ(pageNum,pageSize,tcMp);
    }
    @RequestMapping("getOne")
    public TcMp getOne(String mpId){
        return tcMpService.getOne(mpId);
    }
    @RequestMapping ("delOne")
    public Result  delOne(String mpId){
        return tcMpService.delOne(mpId);
    }
}
