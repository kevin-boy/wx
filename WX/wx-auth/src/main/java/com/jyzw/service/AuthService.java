package com.jyzw.service;

import com.jyzw.entity.Result;
import com.jyzw.entity.UserInfo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface AuthService {
    Result login(String username, String password, HttpServletResponse response);
    UserInfo verify(HttpServletRequest request, HttpServletResponse response);
    void logout(HttpServletRequest request,HttpServletResponse response);
}
