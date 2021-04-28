package com.jyzw.mapper;

import com.jyzw.entity.YwUserAuthorize;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface UserAuthorizeMapper extends Mapper<YwUserAuthorize> {
 List<YwUserAuthorize> getListByTJ(YwUserAuthorize ywUserAuthorize);
}
