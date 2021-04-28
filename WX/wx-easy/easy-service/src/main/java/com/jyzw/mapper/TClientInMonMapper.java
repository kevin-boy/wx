package com.jyzw.mapper;

import com.jyzw.entity.TClientIntMonTB;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface TClientInMonMapper {
    List<TClientIntMonTB> getList();
    TClientIntMonTB getOne(String cimId);
    void save(TClientIntMonTB tClientIntMonTB);
    void update(TClientIntMonTB tClientIntMonTB);
    List<TClientIntMonTB> getByTj(TClientIntMonTB tClientIntMonTB);
    void delOne(String cimId);
}
