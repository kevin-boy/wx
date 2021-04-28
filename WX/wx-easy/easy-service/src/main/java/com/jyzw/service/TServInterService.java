package com.jyzw.service;

import com.github.pagehelper.PageInfo;
import com.jyzw.entity.Result;
import com.jyzw.entity.TServiceInterfaceTB;

import java.util.List;

public interface TServInterService {
    List<TServiceInterfaceTB> getList();
    PageInfo getPageList(Integer pageNum,Integer pageSize,TServiceInterfaceTB tServiceInterfaceTB);
    TServiceInterfaceTB getTservInter(String siId);
    Result saveOne(TServiceInterfaceTB tServiceInterfaceTB);
    Result updateOne(TServiceInterfaceTB tServiceInterfaceTB);
    Result delOne(String siId);
}
