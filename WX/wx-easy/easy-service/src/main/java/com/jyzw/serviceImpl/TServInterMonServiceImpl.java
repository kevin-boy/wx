package com.jyzw.serviceImpl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jyzw.entity.Result;
import com.jyzw.entity.TServiceInterfaceMonitorTB;
import com.jyzw.mapper.TServInterMonMapper;
import com.jyzw.service.TServInterMonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TServInterMonServiceImpl implements TServInterMonService {
   @Autowired
   private TServInterMonMapper tServInterMonMapper;
    @Override
    public List<TServiceInterfaceMonitorTB> getList() {
        try {
        return    tServInterMonMapper.getList();
        } catch (Exception e) {
            e.printStackTrace();
            List<TServiceInterfaceMonitorTB> list=new ArrayList<>();
            TServiceInterfaceMonitorTB tb=new TServiceInterfaceMonitorTB();
            tb.setServiceCode(Result.fCode);
            tb.setServiceName("查询列表失败！");
            list.add(tb);
            return list;
        }
    }

    @Override
    public PageInfo getPageList(Integer pageNum, Integer pageSize, TServiceInterfaceMonitorTB tServiceInterfaceMonitorTB) {
        try {
            PageHelper.startPage(pageNum,pageSize);
            List<TServiceInterfaceMonitorTB> list=tServInterMonMapper.getByTJ(tServiceInterfaceMonitorTB);
            PageInfo pageInfo=new PageInfo(list);
            return pageInfo;
        } catch (Exception e) {
            e.printStackTrace();
            List<TServiceInterfaceMonitorTB> lista=new ArrayList<>();
            TServiceInterfaceMonitorTB tb=new TServiceInterfaceMonitorTB();
            tb.setServiceCode(Result.fCode);
            tb.setServiceName("分页查询失败");
            lista.add(tb);
            PageInfo pageInfo2=new PageInfo(lista);
            return pageInfo2;
        }
    }

    @Override
    public TServiceInterfaceMonitorTB getOne(String simId) {
        try {
            TServiceInterfaceMonitorTB one = tServInterMonMapper.getOne(simId);
            return one;
        } catch (Exception e) {
            e.printStackTrace();
            TServiceInterfaceMonitorTB tb=new TServiceInterfaceMonitorTB();
            tb.setServiceCode(Result.fCode);
            tb.setServiceName("查询失败！");
            return  tb;
        }
    }

    @Override
    public Result delOne(String simId) {
            TServiceInterfaceMonitorTB tb=tServInterMonMapper.getOne(simId);
        try {
            tServInterMonMapper.delOne(simId);
            return new Result(Result.sCode,"删除成功！",tb);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(Result.fCode,"删除失败！",tb);
        }
    }

    @Override
    public Result saveOne(TServiceInterfaceMonitorTB tServiceInterfaceMonitorTB) {
        try {
            tServInterMonMapper.save(tServiceInterfaceMonitorTB);
            return new Result(Result.sCode,"保存成功！",tServiceInterfaceMonitorTB);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(Result.fCode,"保存失败!",tServiceInterfaceMonitorTB);
        }
    }

    @Override
    public Result updateOne(TServiceInterfaceMonitorTB tServiceInterfaceMonitorTB) {
        try {
            tServInterMonMapper.updateOne(tServiceInterfaceMonitorTB);
            return new Result(Result.sCode,"修改成功！",tServiceInterfaceMonitorTB);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(Result.fCode,"修改失败！",tServiceInterfaceMonitorTB);
        }
    }
}
