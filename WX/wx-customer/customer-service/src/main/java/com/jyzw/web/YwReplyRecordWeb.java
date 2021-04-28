package com.jyzw.web;

import com.github.pagehelper.PageInfo;
import com.jyzw.entity.Result;
import com.jyzw.entity.YwReplayRecord;
import com.jyzw.service.YwReplyRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="reply",method= {RequestMethod.GET,RequestMethod.POST})
public class YwReplyRecordWeb {
    @Autowired
    private YwReplyRecordService ywReplyRecordService;
    @RequestMapping("getList")
    public List<YwReplayRecord>  getList(){
        return ywReplyRecordService.getList();
    }
    @RequestMapping("getPageList")
    public PageInfo getPagelist(Integer pageNum,Integer pageSize,YwReplayRecord ywReplayRecord){
        return ywReplyRecordService.getPageList(pageNum,pageSize,ywReplayRecord);
    }
    @RequestMapping("getOne")
    public YwReplayRecord getOne(String ycrId){
        return ywReplyRecordService.getOne(ycrId);
    }
    @RequestMapping("saveOne")
    public Result saveOne(YwReplayRecord ywReplayRecord){
        return ywReplyRecordService.saveOne(ywReplayRecord);
    }
    @RequestMapping("updateOne")
    public Result updateOne(YwReplayRecord ywReplayRecord){
        return ywReplyRecordService.updateOne(ywReplayRecord);
    }
    @RequestMapping("delOne")
    public Result delOne(String ycrId){
        return ywReplyRecordService.delOne(ycrId);
    }
}
