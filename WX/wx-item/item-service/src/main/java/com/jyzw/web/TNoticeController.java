package com.jyzw.web;

import com.github.pagehelper.PageInfo;
import com.jyzw.entity.Result;
import com.jyzw.entity.TNotice;
import com.jyzw.service.TNoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value="tNotice",method={RequestMethod.GET,RequestMethod.POST})
public class TNoticeController {
    @Autowired
    private TNoticeService tNoticeService;

    @RequestMapping("getAll")
    public List<TNotice>  getAll(){
       return  tNoticeService.getList();
    }
    @RequestMapping("getOne")
    public TNotice getOne(String noticeId){
        return tNoticeService.getOne(noticeId);
    }
    @PostMapping("saveTN")
    public Result saveTN(TNotice tNotice){
      return  tNoticeService.saveTNotice(tNotice);
    }
    @PostMapping("updateTN")
    public Result updateTN(TNotice tNotice){
        return tNoticeService.updateTNotice(tNotice);
    }
    @RequestMapping("delOne")
    public Result delOne(String noticeId){
        return tNoticeService.delOne(noticeId);
    }
    @GetMapping("getPageList")
    public PageInfo<TNotice> getPage(Integer pageNum,Integer pageSize,TNotice tNotice){
     return   tNoticeService.getPageList(pageNum,pageSize,tNotice);
    }
}
