package com.jyzw.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="yw_user_authorize")
public class YwUserAuthorize {
    @Id
    @Column(name="yua_id")
    private String yuaId;
    @Column(name="user_id")
    private String userId;
    @Column(name="user_name")
    private String userName;
    @Column(name="grant_user_id")
    private String grantUserId;
    @Column(name="grant_user_name")
    private String grantUserName;
    @Column(name="grant_company_id")
    private String grantCompanyId;
    @Column(name="grant_company_name")
    private String grantCompanyName;

}
