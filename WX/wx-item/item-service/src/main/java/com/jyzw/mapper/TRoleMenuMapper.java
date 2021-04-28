package com.jyzw.mapper;

import com.jyzw.entity.TRoleMenu;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
@Repository
public interface TRoleMenuMapper {
    List<TRoleMenu> getList();
    TRoleMenu getOne(String rmId);
    void saveOne(TRoleMenu tRoleMenu);
    void updateOne(TRoleMenu tRoleMenu);
    void delOne(String rmId);
    List<TRoleMenu> getTMByRid(String roleId);
    List<TRoleMenu> getTRList(TRoleMenu tRoleMenu);
}
