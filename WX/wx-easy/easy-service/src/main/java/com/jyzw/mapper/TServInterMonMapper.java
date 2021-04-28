package com.jyzw.mapper;

import com.jyzw.entity.TServiceInterfaceMonitorTB;
import com.jyzw.service.TClientInMonService;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TServInterMonMapper {
    List<TServiceInterfaceMonitorTB>  getList();
    List<TServiceInterfaceMonitorTB> getByTJ(TServiceInterfaceMonitorTB tServiceInterfaceMonitorTB);
    TServiceInterfaceMonitorTB getOne(String simId);
    void save(TServiceInterfaceMonitorTB tServiceInterfaceMonitorTB);
    void updateOne(TServiceInterfaceMonitorTB tServiceInterfaceMonitorTB);
    void delOne(String simId);
}
