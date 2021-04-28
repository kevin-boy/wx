package com.jyzw.service;

import com.jyzw.entity.Result;

public interface LoginService {
    Result loginDo(String dl_mc,String dl_mm);
    Result loginout();
    Result login(String dl_mc,String dl_mm);
}
