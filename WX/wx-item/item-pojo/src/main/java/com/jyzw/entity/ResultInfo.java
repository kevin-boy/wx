package com.jyzw.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultInfo<T> {
    public static final String sCode="1000";//成功
    public static final String uCode="1001";//用户名不存在
    public static final String fCode="1002";//密码错误
    private String code;
    private String message;
    public T  data;
}
