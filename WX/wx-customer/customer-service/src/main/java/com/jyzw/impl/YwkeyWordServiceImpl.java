package com.jyzw.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jyzw.entity.Result;
import com.jyzw.entity.YwKeyWord;
import com.jyzw.mapper.YwkeyWordMapper;
import com.jyzw.service.YwkeyWordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class YwkeyWordServiceImpl implements YwkeyWordService {

   @Autowired
   private YwkeyWordMapper mapper;
    @Override
    public List<YwKeyWord> getList() {
        try {
            List<YwKeyWord> list = mapper.getList();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            List<YwKeyWord> list1=new ArrayList<>();
            YwKeyWord tb=new YwKeyWord();
            tb.setUserName(Result.sCode);
            tb.setKeyWord("查询列表失败！");
            list1.add(tb);
            return list1;
        }
    }



    @Override
    public PageInfo getPageList(Integer pageNum, Integer pageSize, YwKeyWord ywKeyWord) {
        try {
            PageHelper.startPage(pageNum,pageSize);
            List<YwKeyWord> list=mapper.getListByTJ(ywKeyWord);
            PageInfo pageInfo=new PageInfo(list);
            return pageInfo;
        } catch (Exception e) {
            e.printStackTrace();
            List<YwKeyWord> listq=new ArrayList<>();
            YwKeyWord tb=new YwKeyWord();
            tb.setUserName(Result.fCode);
            tb.setKeyWord("分页查询失败！");
            listq.add(tb);
            return new PageInfo(listq);
        }
    }

    @Override
    public YwKeyWord getOne(String ykwId) {
        try {
            YwKeyWord one = mapper.getOne(ykwId);
            return  one;
        } catch (Exception e) {
            e.printStackTrace();
            YwKeyWord tb=new YwKeyWord();
            tb.setUserName(Result.fCode);
            tb.setKeyWord("查询失败！");
            return tb;
        }

    }

    @Override
    public Result saveOne(YwKeyWord ywKeyWord) {
        try {
            mapper.saveOne(ywKeyWord);
            return new Result(Result.sCode,"保存成功！",ywKeyWord);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(Result.fCode,"保存失败!",ywKeyWord);
        }
    }

    @Override
    public Result updateOne(YwKeyWord ywKeyWord) {
        try {
            mapper.updateOne(ywKeyWord);
            return new Result(Result.sCode,"修改成功！",ywKeyWord);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(Result.fCode,"修改失败！",ywKeyWord);
        }
    }

    @Override
    public Result delOne(String ykwId) {
        YwKeyWord one = mapper.getOne(ykwId);
        if(one==null){
            return new Result(Result.fCode,"删除失败！",one);
        }else{
            mapper.delOne(ykwId);
            return new Result(Result.fCode,"删除成功！",one);
        }
    }
}
