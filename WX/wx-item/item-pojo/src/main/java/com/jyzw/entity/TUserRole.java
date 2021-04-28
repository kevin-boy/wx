package com.jyzw.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TUserRole {
    private String urId;
    private String userId;
    private String userName;
    private String roleId;
    private String roleName;
    private String createrDate;
    private String explain;
}
