package com.jyzw.mapper;

import com.jyzw.entity.TRole;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
@Repository
public interface TRoleMapper  {
    List<TRole> getRoleL();
    TRole getOne(String roleId);
    void saveOne(TRole tRole);
    void updateOne(TRole tRole);
    void delOne(String roleId);
}
