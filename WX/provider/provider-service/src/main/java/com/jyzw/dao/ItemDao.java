package com.jyzw.dao;

import com.jyzw.entity.TabUser;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemDao {
    @Select("select * from tab_user")
    List<TabUser> getList();
}
