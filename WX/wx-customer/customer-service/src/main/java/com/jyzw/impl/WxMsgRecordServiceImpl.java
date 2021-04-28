package com.jyzw.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jyzw.entity.Result;
import com.jyzw.entity.WxMsgRecord;
import com.jyzw.mapper.WxMsgRecordMapper;
import com.jyzw.service.WxMsgRecordService;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WxMsgRecordServiceImpl implements WxMsgRecordService {
   @Autowired
   private WxMsgRecordMapper mapper;
    @Override
    public List<WxMsgRecord> getList() {
        try {
            List<WxMsgRecord> wxMsgRecords = mapper.selectAll();
            return wxMsgRecords;
        } catch (Exception e) {
            e.printStackTrace();
            List<WxMsgRecord> list =new ArrayList<>();
            WxMsgRecord wxMsgRecord=new WxMsgRecord();
            wxMsgRecord.setAccount(Result.fCode);
            wxMsgRecord.setDataContent("查询列表失败！");
            list.add(wxMsgRecord);
            return list;
        }
    }

    @Override
    public WxMsgRecord getOne(String ywmrId) {

        try {
            return mapper.selectByPrimaryKey(ywmrId);
        } catch (Exception e) {
            e.printStackTrace();
            WxMsgRecord tb=new WxMsgRecord();
            tb.setDataContent(Result.fCode);
            tb.setCreaterDate("查询失败！");
            return tb;
        }
    }

    @Override
    public Result delOne(String ywmrId) {
        WxMsgRecord wxMsgRecord= null;
        try {
            wxMsgRecord = mapper.selectByPrimaryKey(ywmrId);
            mapper.deleteByPrimaryKey(ywmrId);
            return new Result(Result.sCode,"删除成功！",wxMsgRecord);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Result(Result.fCode,"删除失败！",wxMsgRecord);
    }

    @Override
    public Result updateOne(WxMsgRecord wxMsgRecord) {
        try {
            mapper.updateByPrimaryKey(wxMsgRecord);
            return new Result(Result.sCode,"修改成功！",wxMsgRecord);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(Result.fCode,"修改失败！",wxMsgRecord);
        }
    }

    @Override
    public Result saveOne(WxMsgRecord wxMsgRecord) {
        try {
            mapper.insert(wxMsgRecord);
            return new Result(Result.sCode,"保存成功！",wxMsgRecord);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(Result.fCode,"保存失败！",wxMsgRecord);
        }
    }

    @Override
    public PageInfo getPageList(Integer pageNum, Integer pageSize, WxMsgRecord wxMsgRecord) {
        /*PageInfo pageInfo;
        List<WxMsgRecord> list;*/
        /*if(wxMsgRecord.getCreaterDate()==null||"".equals(wxMsgRecord.get)){
            list=mapper.selectAll();
            list=mapper.selectAll();
            PageInfo   pageInfo1=new PageInfo(list);
            return pageInfo1;
        }*/
        try {
            PageHelper.startPage(pageNum,pageSize);
            List<WxMsgRecord> list= mapper.queryListByTJ(wxMsgRecord);
            PageInfo pageInfo=new PageInfo<>(list);
            return pageInfo;
        } catch (Exception e) {
            e.printStackTrace();
            List<WxMsgRecord> list=new ArrayList<>();
            WxMsgRecord wx=new WxMsgRecord();
            wx.setAccount(Result.fCode);
            wx.setCreaterDate("分页查询失败");
            list.add(wx);
            PageInfo pageInfo2=new PageInfo(list);
            return pageInfo2;
        }
    }
}
