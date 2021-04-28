package com.jyzw.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TRole {
    private String  roleId;
    private String  roleName;
    private String  state;
    private String  grade;
    private String  createrDate;
    private String  explain;
}
