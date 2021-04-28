package com.jyzw.mapper;

import com.jyzw.entity.TUserRole;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface TUserRoleMapper  {
  void save(TUserRole tUserRole);
  void update(TUserRole tUserRole);
  List<TUserRole>  getList();
  TUserRole getOne(String urId);
  void delOne(String urId);
  List<TUserRole> getUR(String userId);
  List<TUserRole> getTRList(TUserRole tUserRole);
  void delur(TUserRole tUserRole);
}
