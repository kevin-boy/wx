package com.jyzw.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jyzw.entity.Result;
import com.jyzw.entity.TServiceInterfaceTB;
import com.jyzw.mapper.TServInterMapper;
import com.jyzw.service.TServInterService;
import com.sun.org.apache.bcel.internal.generic.RETURN;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TServInterServiceImpl  implements TServInterService {
   @Autowired
   private TServInterMapper tServInterMapper;
    @Override
    public List<TServiceInterfaceTB> getList() {
        try {
         return tServInterMapper.getList();
        } catch (Exception e) {
            e.printStackTrace();
            List<TServiceInterfaceTB> list=new ArrayList<>();
            TServiceInterfaceTB tb=new TServiceInterfaceTB();
            tb.setAdapterName(Result.fCode);
            tb.setClasssName("查询列表失败！");
            list.add(tb);
            return list;
        }
    }

    @Override
    public PageInfo getPageList(Integer pageNum, Integer pageSize, TServiceInterfaceTB tServiceInterfaceTB) {
        PageHelper.startPage(pageNum,pageSize);
        List<TServiceInterfaceTB> list=tServInterMapper.getListByTJ(tServiceInterfaceTB);
        PageInfo pageInfo=new PageInfo(list);
        return pageInfo;
    }

    @Override
    public TServiceInterfaceTB getTservInter(String siId) {
        try {
           return tServInterMapper.getOne(siId);
        } catch (Exception e) {
            e.printStackTrace();
            TServiceInterfaceTB tb=new TServiceInterfaceTB();
            tb.setClasssName(Result.fCode);
            tb.setAdapterName("查询失败！");
            return tb;
        }
    }

    @Override
    public Result saveOne(TServiceInterfaceTB tServiceInterfaceTB) {
        try {
            tServInterMapper.save(tServiceInterfaceTB);
            return new Result(Result.sCode,"保存成功！",tServiceInterfaceTB);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(Result.fCode,"保存失败！",tServiceInterfaceTB);
        }
    }

    @Override
    public Result updateOne(TServiceInterfaceTB tServiceInterfaceTB) {
        try {
            tServInterMapper.update(tServiceInterfaceTB);
            return new Result(Result.sCode,"修改成功！",tServiceInterfaceTB);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(Result.fCode,"修改失败！",tServiceInterfaceTB);
        }
    }

    @Override
    public Result delOne(String siId) {
            TServiceInterfaceTB tServiceInterfaceTB=tServInterMapper.getOne(siId);
        try {
            tServInterMapper.delOne(siId);
            return new Result(Result.sCode,"删除成功！",tServiceInterfaceTB);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(Result.fCode,"删除成功",tServiceInterfaceTB);
        }
    }
}
