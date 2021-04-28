package com.jyzw.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jyzw.entity.Result;
import com.jyzw.entity.YwReplayRecord;
import com.jyzw.mapper.YwReplyRecordMapper;
import com.jyzw.service.YwReplyRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class YwReplyRecordServiceImpl implements YwReplyRecordService {
    @Autowired
    private YwReplyRecordMapper mapper;
    @Override
    public List<YwReplayRecord> getList() {
        try {
            List<YwReplayRecord> list= mapper.getList();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            List<YwReplayRecord> list1=new ArrayList<>();
            YwReplayRecord tb=new YwReplayRecord();
            tb.setAccount(Result.fCode);
            tb.setDataContent("查询列表失败");
            list1.add(tb);
            return list1;
        }
    }

    @Override
    public PageInfo getPageList(Integer pageNum, Integer pageSize, YwReplayRecord ywReplayRecord) {
        try {
            PageHelper.startPage(pageNum,pageSize);
            List<YwReplayRecord> list=mapper.getListByTJ(ywReplayRecord);
            PageInfo pageInfo=new PageInfo(list);
            return pageInfo;
        } catch (Exception e) {
            e.printStackTrace();
            List<YwReplayRecord> listq=new ArrayList<>();
            YwReplayRecord tb=new YwReplayRecord();
            tb.setAccount(Result.fCode);
            tb.setCreaterDate("分页查询失败！");
            listq.add(tb);
            PageInfo pageInfo2=new PageInfo(listq);
            return pageInfo2;
        }
    }

    @Override
    public Result saveOne(YwReplayRecord ywReplayRecord) {
        try {
            mapper.saveOne(ywReplayRecord);
            return new Result(Result.sCode,"保存成功！",ywReplayRecord);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(Result.fCode,"保存失败！",ywReplayRecord);
        }
    }

    @Override
    public Result updateOne(YwReplayRecord ywReplayRecord) {
        try {
            mapper.updateOne(ywReplayRecord);
            return new Result(Result.sCode,"修改成功！",ywReplayRecord);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(Result.fCode,"修改失败！",ywReplayRecord);
        }
    }

    @Override
    public Result delOne(String ycrId) {
        YwReplayRecord one = mapper.getOne(ycrId);
         if(one!=null){
             mapper.delone(ycrId);
             return new Result(Result.sCode,"删除成功！",one);
         }else{
             return new Result(Result.fCode,"删除失败！",one);
         }
    }

    @Override
    public YwReplayRecord getOne(String ycrId) {
        try {
            YwReplayRecord one = mapper.getOne(ycrId);
            return one;
        } catch (Exception e) {
            e.printStackTrace();
            YwReplayRecord tb=new YwReplayRecord();
            tb.setAccount(Result.fCode);
            tb.setDataContent("查询失败！");
            return tb;
        }

    }
}
