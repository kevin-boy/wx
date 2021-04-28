package com.jyzw.mapper;

import com.jyzw.entity.TabUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(value="provider-service")
public interface Itemmapper {
    @RequestMapping("iinyyy")
    List<TabUser> getList();
}
