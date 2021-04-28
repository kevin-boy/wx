package com.jyzw.dao;

import com.jyzw.entity.Ygmoney;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface YgDao {
    @Select("select * from employee where id=#{id}")
    Ygmoney getOne(String id);
}
