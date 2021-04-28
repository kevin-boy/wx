package com.jyzw.web;

import com.github.pagehelper.PageInfo;
import com.jyzw.entity.Result;
import com.jyzw.entity.WxMsgRecord;
import com.jyzw.service.WxMsgRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="msgRecord",method= {RequestMethod.GET,RequestMethod.POST})
public class WxMsgRecordController {
    @Autowired
    private WxMsgRecordService wxMsgRecordService;
    @RequestMapping("getList")
    public List<WxMsgRecord> getList(){
        return wxMsgRecordService.getList();
    }
    @RequestMapping("getPageList")
    public PageInfo getPageInfo(Integer pageNum,Integer pageSize,WxMsgRecord wxMsgRecord){
        return wxMsgRecordService.getPageList(pageNum,pageSize,wxMsgRecord);
    }
    @RequestMapping("getOne")
    public WxMsgRecord getone(String ywmrId ){
        return wxMsgRecordService.getOne(ywmrId);
    }
    @RequestMapping("saveOne")
    public Result saveOne(WxMsgRecord wxMsgRecord){
        return wxMsgRecordService.saveOne(wxMsgRecord);
    }
    @RequestMapping("updateOne")
    public Result updateOne(WxMsgRecord wxMsgRecord){
        return wxMsgRecordService.updateOne(wxMsgRecord);
    }
    @RequestMapping("delOne")
    public Result delOne(String ywmrId){
        return wxMsgRecordService.delOne(ywmrId);
    }
}
