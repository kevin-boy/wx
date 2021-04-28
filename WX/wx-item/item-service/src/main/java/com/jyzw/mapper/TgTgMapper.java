package com.jyzw.mapper;

import com.jyzw.entity.TgTg;

import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;


import java.util.List;

@Repository
public interface TgTgMapper  {
    void save(TgTg tgTg);
    void update(TgTg tgTg);
    TgTg getOne(String tgId);
    void delOne(String tgId);
    List<TgTg> getList();
    List<TgTg> getByTj(TgTg tgTg);
}
