package com.jyzw.service;

import com.github.pagehelper.PageInfo;
import com.jyzw.entity.Result;
import com.jyzw.entity.TSysSwitch;

import java.util.List;

public interface TSysSwitchService {
    List<TSysSwitch> getList();
    TSysSwitch getOne(String tssId);
    Result saveOne(TSysSwitch tSysSwitch);
    Result updateOne(TSysSwitch tSysSwitch);
    Result delOne(String tssId);
    PageInfo<TSysSwitch> getPageList(Integer pageNum,Integer pageSize,TSysSwitch tSysSwitch);
}
