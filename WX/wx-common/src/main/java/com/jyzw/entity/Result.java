package com.jyzw.entity;

import com.sun.security.auth.NTUserPrincipal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


public class Result<T> {
    public static final String sCode="1000";//成功
    public static final String uCode="1001";//用户名不存在
    public static final String fCode="1002";//密码错误
    private String code;
    private String message;
    public T  data;

    public static String getsCode() {
        return sCode;
    }

    public static String getuCode() {
        return uCode;
    }

    public static String getfCode() {
        return fCode;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Result(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Result() {
    }
}
