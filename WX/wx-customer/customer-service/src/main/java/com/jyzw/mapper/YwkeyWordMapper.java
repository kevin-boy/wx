package com.jyzw.mapper;

import com.jyzw.entity.YwKeyWord;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface YwkeyWordMapper {
    List<YwKeyWord> getList();
    YwKeyWord getOne(String ykwId);
    void saveOne(YwKeyWord ywKeyWord);
    void updateOne(YwKeyWord ywKeyWord);
    void delOne(String ykwId);
    List<YwKeyWord> getListByTJ(YwKeyWord ywKeyWord);
}
