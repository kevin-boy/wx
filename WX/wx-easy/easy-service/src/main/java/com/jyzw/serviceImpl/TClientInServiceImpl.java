package com.jyzw.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jyzw.entity.Result;
import com.jyzw.entity.TClientInTB;
import com.jyzw.mapper.TClientInMapper;
import com.jyzw.service.TClientTBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TClientInServiceImpl implements TClientTBService {
    @Autowired
    private TClientInMapper tClientInMapper;
    @Override
    public List<TClientInTB> getList() {
        List<TClientInTB> list = tClientInMapper.getList();
        if(list.size()==0) {
            List<TClientInTB> list1 = new ArrayList<>();
            TClientInTB tClientInTB=new TClientInTB();
            tClientInTB.setTypeCode(Result.fCode);
            tClientInTB.setTypeName("查询列表失败！");
            list1.add(tClientInTB);
            return list1;
        }
        return list;
    }

    @Override
    public TClientInTB getOne(String ciId) {
        TClientInTB one = tClientInMapper.getOne(ciId);
       if(one==null){
           TClientInTB tClientInTB=new TClientInTB();
           tClientInTB.setTypeCode(Result.fCode);
           tClientInTB.setTypeName("查询失败!");
           return tClientInTB;
       }
       return one;
    }

    @Override
    public PageInfo<TClientInTB> getByTJ(Integer pageNum, Integer pageSize, TClientInTB tClientInTB) {
        PageHelper.startPage(pageNum,pageSize);
        List<TClientInTB> list=tClientInMapper.getByTJ(tClientInTB);
        PageInfo pageInfo=new PageInfo(list);
        return pageInfo;
    }

    @Override
    public Result save(TClientInTB tClientInTB) {
        try {
            tClientInMapper.save(tClientInTB);
            return new Result(Result.sCode,"保存成功",tClientInTB);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(Result.fCode,"保存失败",tClientInTB);
        }
    }

    @Override
    public Result update(TClientInTB tClientInTB) {
        try {
            tClientInMapper.update(tClientInTB);
            return new Result(Result.sCode,"修改成功！",tClientInTB);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(Result.fCode,"修改失败",tClientInTB);
        }
    }

    @Override
    public Result delOne(String ciId) {
            TClientInTB tClientInTB=tClientInMapper.getOne(ciId);
            if(tClientInTB!=null){
                tClientInMapper.delOne(ciId);
            return new Result(Result.sCode,"删除成功",tClientInTB);}
         else{
            return new Result(Result.fCode,"删除失败",tClientInTB);}

    }
}
