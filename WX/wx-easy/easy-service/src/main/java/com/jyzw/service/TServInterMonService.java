package com.jyzw.service;

import com.github.pagehelper.PageInfo;
import com.jyzw.entity.Result;
import com.jyzw.entity.TServiceInterfaceMonitorTB;

import java.util.List;

public interface TServInterMonService {
    List<TServiceInterfaceMonitorTB>  getList();
    PageInfo getPageList(Integer pageNum,Integer pageSize,TServiceInterfaceMonitorTB tServiceInterfaceMonitorTB);
    TServiceInterfaceMonitorTB getOne(String simId);
    Result delOne(String simId);
    Result saveOne(TServiceInterfaceMonitorTB tServiceInterfaceMonitorTB);
    Result updateOne(TServiceInterfaceMonitorTB tServiceInterfaceMonitorTB);
}
