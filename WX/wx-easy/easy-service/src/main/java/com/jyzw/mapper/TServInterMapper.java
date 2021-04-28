package com.jyzw.mapper;


import com.jyzw.entity.TServiceInterfaceTB;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TServInterMapper {
    List<TServiceInterfaceTB>  getList();
    TServiceInterfaceTB getOne(String siId);
    List<TServiceInterfaceTB> getListByTJ(TServiceInterfaceTB tServiceInterfaceTB);
    void save(TServiceInterfaceTB tServiceInterfaceTB);
    void update(TServiceInterfaceTB tServiceInterfaceTB);
    void delOne(String siId);
}
