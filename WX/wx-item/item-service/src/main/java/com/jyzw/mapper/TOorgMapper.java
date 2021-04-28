package com.jyzw.mapper;

import com.jyzw.entity.TOorg;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface TOorgMapper  {
    List<TOorg>  getList();
    void saveOne(TOorg tOorg);
    void updateOne(TOorg tOorg);
    TOorg getOne(String orgNo);
    void delOne(String orgNo);
    List<TOorg>  getTOList(TOorg tOorg);
}
