package com.jyzw.mapper;

import com.jyzw.entity.TSysSwitch;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
@Repository
public interface TSysSwithMapper {
    List<TSysSwitch> getList();
    TSysSwitch getOne(String tssId);
    void saveOne(TSysSwitch tSysSwitch);
    void updateOne(TSysSwitch tSysSwitch);
    void delOne(String tssId);
    List<TSysSwitch> getTSList(TSysSwitch tSysSwitch);
}
