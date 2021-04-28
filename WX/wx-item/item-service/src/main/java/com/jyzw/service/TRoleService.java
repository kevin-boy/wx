package com.jyzw.service;

import com.jyzw.entity.Result;
import com.jyzw.entity.TRole;

import java.util.List;

public interface TRoleService {
    List<TRole> getRolel();
    TRole getOne(String roleId);
    Result  saveOne(TRole tRole);
   Result updateOne(TRole tRole);
   Result delOne(String roleId);
}
