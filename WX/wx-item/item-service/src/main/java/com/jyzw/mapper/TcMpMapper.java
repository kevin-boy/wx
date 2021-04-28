package com.jyzw.mapper;

import com.jyzw.entity.TcMp;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;


import java.util.List;

@Repository
public interface TcMpMapper  {
    void save(TcMp tcMp);
    void update(TcMp tcMp);
    List<TcMp>  getList();
    List<TcMp> getByTJ(TcMp tcMp);
    void delOne(String mpId);
    TcMp getOne(String mpId);
}
