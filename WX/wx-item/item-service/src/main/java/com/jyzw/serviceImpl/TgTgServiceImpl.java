package com.jyzw.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jyzw.entity.Result;
import com.jyzw.entity.TgTg;
import com.jyzw.mapper.TgTgMapper;
import com.jyzw.service.TgTgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TgTgServiceImpl implements TgTgService {
   @Autowired
   private TgTgMapper tgTgMapper;
    @Override
    public Result save(TgTg tgTg) {
        try {
            tgTgMapper.save(tgTg);
            return new Result(Result.sCode,"保存成功！",tgTg);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(Result.fCode,"保存失败！",tgTg);
        }

    }

    @Override
    public Result update(TgTg tgTg) {
        try {
            tgTgMapper.update(tgTg);
            return new Result(Result.sCode,"修改成功",tgTg);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(Result.fCode,"修改失败",tgTg);
        }
    }

    @Override
    public TgTg getOne(String tgId) {
        TgTg one = tgTgMapper.getOne(tgId);
        if(one==null){
           TgTg tgTg=new TgTg();
           tgTg.setTgNo(Result.fCode);
           tgTg.setTgName("查询失败！");
           return tgTg;
        }
        return one;
    }

    @Override
    public Result delOne(String tgId) {
            TgTg tgTg=tgTgMapper.getOne(tgId);
        try {
            tgTgMapper.delOne(tgId);
            return new Result(Result.sCode,"删除成功",tgTg);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(Result.fCode,"删除失败",tgTg);
        }
    }

    @Override
    public List<TgTg> getList() {
        List<TgTg> list = tgTgMapper.getList();
        if(list.size()==0){
            List<TgTg> list1=new ArrayList<>();
            TgTg tg=new TgTg();
            tg.setTgNo(Result.fCode);
            tg.setTgName("查询失败！");
            list1.add(tg);
            return list1;
        }
        return list;
    }

    @Override
    public PageInfo<TgTg> getByTj(Integer pageNum,Integer pageSize,TgTg tgTg) {
        List<TgTg> list = tgTgMapper.getByTj(tgTg);
        PageHelper.startPage(pageNum,pageSize);
        PageInfo pageInfo=new PageInfo(list);
        return pageInfo;
    }
}
