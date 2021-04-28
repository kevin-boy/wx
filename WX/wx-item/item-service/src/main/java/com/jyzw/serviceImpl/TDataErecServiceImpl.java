package com.jyzw.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jyzw.entity.Result;
import com.jyzw.entity.TDataErect;
import com.jyzw.mapper.TDataErectMapper;
import com.jyzw.service.TDataErecService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TDataErecServiceImpl implements TDataErecService {
   @Autowired
   private TDataErectMapper tDataErectMapper;
    @Override
    public List<TDataErect> getList() {
        return tDataErectMapper.getList();
    }

    @Override
    public TDataErect getOne(String erectId) {
        return tDataErectMapper.getOne(erectId);
    }

    @Override
    public Result saveOne(TDataErect tDataErect) {
        try {
            tDataErectMapper.saveOne(tDataErect);
            return new Result(Result.sCode,"保存成功！",tDataErect);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(Result.fCode,"保存失败！",tDataErect);
        }

    }

    @Override
    public Result updateOne(TDataErect tDataErect) {
        try {
            tDataErectMapper.updateOne(tDataErect);
            return new Result(Result.sCode,"修改成功！",tDataErect);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(Result.fCode,"修改失败",tDataErect);
        }
    }

    @Override
    public Result  delone(String erectId) {
        TDataErect tDataErect=tDataErectMapper.getOne(erectId);
        try {
            tDataErectMapper.delone(erectId);
            return new Result(Result.sCode,"删除成功！",tDataErect);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(Result.fCode,"删除失败！",tDataErect);
        }
    }

    @Override
    public PageInfo<TDataErect> getPageList(Integer page, Integer size, TDataErect tDataErect) {
        PageHelper.startPage(page,size);
        List<TDataErect>  list=tDataErectMapper.getDEList(tDataErect);
        PageInfo<TDataErect> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }
}
