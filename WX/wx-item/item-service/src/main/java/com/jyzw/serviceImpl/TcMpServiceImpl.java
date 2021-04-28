package com.jyzw.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jyzw.entity.Result;
import com.jyzw.entity.TcMp;
import com.jyzw.mapper.TcMpMapper;
import com.jyzw.service.TcMpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TcMpServiceImpl implements TcMpService {
  @Autowired
   private TcMpMapper tcMpMapper;

    @Override
    public Result save(TcMp tcMp) {
        try {
            tcMpMapper.save(tcMp);
            return new Result(Result.sCode,"保存成功",tcMp);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(Result.fCode,"保存失败",tcMp);
        }
    }

    @Override
    public Result update(TcMp tcMp) {
        try {
            tcMpMapper.update(tcMp);
            return new Result(Result.sCode,"修改成功",tcMp);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(Result.fCode,"修改失败",tcMp);
        }
    }

    @Override
    public List<TcMp> getList() {
        List<TcMp> list = tcMpMapper.getList();
        if(list.size()==0){
            List<TcMp> list1=new ArrayList<>();
            TcMp tcMp=new TcMp();
            tcMp.setMpNo(Result.fCode);
            tcMp.setMpName("查询列表失败！");
            list1.add(tcMp);
            return list1;
        }
        return list;
    }

    @Override
    public PageInfo<TcMp> getByTJ(Integer pageNum, Integer pageSize, TcMp tcMp) {
        PageHelper.startPage(pageNum,pageSize);
        List<TcMp> list1=tcMpMapper.getByTJ(tcMp);
        PageInfo pageInfo=new PageInfo(list1);
        return pageInfo;
    }

    @Override
    public Result delOne(String mpId) {
      TcMp tcMp=tcMpMapper.getOne(mpId);
        try {
            tcMpMapper.delOne(mpId);
            return new Result(Result.sCode,"删除成功",tcMp);
        } catch (Exception e) {
            e.printStackTrace();
            return  new Result(Result.fCode,"删除失败",tcMp);
        }
    }

    @Override
    public TcMp getOne(String mpId) {
        TcMp one = tcMpMapper.getOne(mpId);
        if(one==null){
            TcMp tcMp=new TcMp();
            tcMp.setMpNo(Result.fCode);
            tcMp.setMpName("查询失败!");
            return tcMp;
        }
        return one;

    }
}
