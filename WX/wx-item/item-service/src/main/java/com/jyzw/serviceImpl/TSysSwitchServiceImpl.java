package com.jyzw.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jyzw.entity.Result;
import com.jyzw.entity.TSysSwitch;
import com.jyzw.mapper.TSysSwithMapper;
import com.jyzw.service.TSysSwitchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TSysSwitchServiceImpl  implements TSysSwitchService {
  @Autowired
  private TSysSwithMapper tSysSwithMapper;
    @Override
    public List<TSysSwitch> getList() {
        return tSysSwithMapper.getList();
    }

    @Override
    public TSysSwitch getOne(String tssId) {
        return tSysSwithMapper.getOne(tssId);
    }

    @Override
    public Result saveOne(TSysSwitch tSysSwitch) {
        try {
            tSysSwithMapper.saveOne(tSysSwitch);
            return new Result(Result.sCode,"保存成功！",tSysSwitch);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(Result.sCode,"保存失败！",tSysSwitch);
        }
    }

    @Override
    public Result  updateOne(TSysSwitch tSysSwitch) {
        try {
            tSysSwithMapper.updateOne(tSysSwitch);
            return new Result(Result.sCode,"修改成功！",tSysSwitch);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(Result.fCode,"修改失败",tSysSwitch);
        }
    }

    @Override
    public Result delOne(String tssId) {
            TSysSwitch tSysSwitch=tSysSwithMapper.getOne(tssId);
        try {
            tSysSwithMapper.delOne(tssId);
            return new Result(Result.sCode,"删除成功！",tSysSwitch);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(Result.fCode,"删除失败！",tSysSwitch);
        }
    }

    @Override
    public PageInfo<TSysSwitch> getPageList(Integer pageNum, Integer pageSize, TSysSwitch tSysSwitch) {
        PageHelper.startPage(pageNum,pageSize);
        List<TSysSwitch> list=tSysSwithMapper.getTSList(tSysSwitch);
        PageInfo<TSysSwitch> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }
}
