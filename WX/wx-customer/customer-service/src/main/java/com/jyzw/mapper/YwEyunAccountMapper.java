package com.jyzw.mapper;

import com.jyzw.entity.YwEyunAccount;
import com.netflix.discovery.converters.Auto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface YwEyunAccountMapper {
    List<YwEyunAccount>  getList();
    YwEyunAccount getOne(String yweaId);
    void saveOne(YwEyunAccount ywEyunAccount);
    void updateone(YwEyunAccount ywEyunAccount);
    void delOne(String yweaId);
    List<YwEyunAccount> getListByTJ(YwEyunAccount ywEyunAccount);
}
