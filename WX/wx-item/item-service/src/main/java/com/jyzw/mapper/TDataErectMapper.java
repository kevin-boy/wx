package com.jyzw.mapper;

import com.jyzw.entity.TDataErect;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface TDataErectMapper  {
    List<TDataErect>  getList();
    TDataErect getOne(String erectId);
    void saveOne(TDataErect tDataErect);
    void updateOne(TDataErect tDataErect);
    void delone(String erectId);
    List<TDataErect> getDEList(TDataErect tDataErect);
}
