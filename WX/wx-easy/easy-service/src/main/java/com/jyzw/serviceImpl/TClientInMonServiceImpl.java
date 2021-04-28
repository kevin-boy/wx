package com.jyzw.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jyzw.entity.Result;
import com.jyzw.entity.TClientIntMonTB;
import com.jyzw.mapper.TClientInMonMapper;
import com.jyzw.service.TClientInMonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TClientInMonServiceImpl implements TClientInMonService {
  @Autowired
  private TClientInMonMapper tClientInMonMapper;
    @Override
    public List<TClientIntMonTB> getList() {
        List<TClientIntMonTB> list = tClientInMonMapper.getList();
        if(list.size()==0){
            List<TClientIntMonTB> list1=new ArrayList<>();
            TClientIntMonTB tClientIntMonTB=new TClientIntMonTB();
            tClientIntMonTB.setInterfaceCode(Result.fCode);
            tClientIntMonTB.setInterfaceName("查询列表失败！");
            list1.add(tClientIntMonTB);
            return list1;
        }
        return list;
    }

    @Override
    public TClientIntMonTB getOne(String cimId) {
        TClientIntMonTB one = tClientInMonMapper.getOne(cimId);
        if(one==null){
            TClientIntMonTB tt=new TClientIntMonTB();
            tt.setInterfaceCode(Result.fCode);
            tt.setInterfaceName("查询某个接口监控失败！");
            return tt;
        }
        return one;

    }

    @Override
    public Result save(TClientIntMonTB tClientIntMonTB) {
        try {
            tClientInMonMapper.save(tClientIntMonTB);
            return new Result(Result.sCode,"保存成功",tClientIntMonTB);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(Result.fCode,"保存失败",tClientIntMonTB);
        }
    }

    @Override
    public Result update(TClientIntMonTB tClientIntMonTB) {
        try {
            tClientInMonMapper.update(tClientIntMonTB);
            return new Result(Result.sCode,"修改成功！",tClientIntMonTB);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(Result.fCode,"修改失败！",tClientIntMonTB);
        }
    }

    @Override
    public PageInfo<TClientIntMonTB> getByTj(Integer pageNum,Integer pageSize,TClientIntMonTB tClientIntMonTB) {
        PageHelper.startPage(pageNum,pageSize);
        List<TClientIntMonTB> list=tClientInMonMapper.getByTj(tClientIntMonTB);
        PageInfo pageInfo=new PageInfo(list);
        return pageInfo;
    }

    @Override
    public Result delOne(String cimId) {
        TClientIntMonTB tClientIntMonTB=tClientInMonMapper.getOne(cimId);
        try {
            tClientInMonMapper.delOne(cimId);
            return new Result(Result.sCode,"删除成功！",tClientIntMonTB);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(Result.fCode,"删除失败！",tClientIntMonTB);
        }

    }
}
