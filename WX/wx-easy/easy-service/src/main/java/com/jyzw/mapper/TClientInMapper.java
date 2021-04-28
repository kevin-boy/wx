package com.jyzw.mapper;

import com.jyzw.entity.TClientInTB;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TClientInMapper {
    List<TClientInTB> getList();
    TClientInTB getOne(String ciId);
    List<TClientInTB> getByTJ(TClientInTB tClientInTB);
    void save(TClientInTB tClientInTB);
    void update(TClientInTB tClientInTB);
    void delOne(String ciId);
}
