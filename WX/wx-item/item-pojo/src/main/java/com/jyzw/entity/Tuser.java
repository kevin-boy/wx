package com.jyzw.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tuser {
    private String userId;
    private String loginName;
    private String loginPwd;
    private String userName;
    private String phone;
    private String sex;
    private String WeChat;
    private String userImg;
    private String email;
    private String isDel;
    private String loginIp;
    private String createrId;
    private String createrName;
    private String createrDate;
    private String  isAdmin;
    private String wxLoginData;
    private String explain;
    private String wxWcId;
    private String wxType;
    private String wxWid;
    private String wxQrCodeUrl;
    private String wxWAccount;
    private String wxSmallHeadImgUrl;
    private String dataJson;
    private String orgNo;
    private String orgName;
    private String consId;
    private String consNo;
    private String consName;
    private String wxNickName;

    @Override
    public String toString() {
        return "Tuser{" +
                "userId='" + userId + '\'' +
                ", loginName='" + loginName + '\'' +
                ", loginPwd='" + loginPwd + '\'' +
                ", userName='" + userName + '\'' +
                ", phone='" + phone + '\'' +
                ", sex='" + sex + '\'' +
                ", WeChat='" + WeChat + '\'' +
                ", userImg='" + userImg + '\'' +
                ", email='" + email + '\'' +
                ", isDel='" + isDel + '\'' +
                ", loginIp='" + loginIp + '\'' +
                ", createrId='" + createrId + '\'' +
                ", createrName='" + createrName + '\'' +
                ", createrDate='" + createrDate + '\'' +
                ", isAdmin='" + isAdmin + '\'' +
                ", wxLoginData='" + wxLoginData + '\'' +
                ", explain='" + explain + '\'' +
                ", wxWcId='" + wxWcId + '\'' +
                ", wxType='" + wxType + '\'' +
                ", wxWid='" + wxWid + '\'' +
                ", wxQrCodeUrl='" + wxQrCodeUrl + '\'' +
                ", wxWAccount='" + wxWAccount + '\'' +
                ", wxSmallHeadImgUrl='" + wxSmallHeadImgUrl + '\'' +
                ", dataJson='" + dataJson + '\'' +
                ", orgNo='" + orgNo + '\'' +
                ", orgName='" + orgName + '\'' +
                ", consId='" + consId + '\'' +
                ", consNo='" + consNo + '\'' +
                ", consName='" + consName + '\'' +
                ", wxNickName='" + wxNickName + '\'' +
                '}';
    }
}
