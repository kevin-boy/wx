package com.jyzw.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
public class WxFriendsTB {
   private String  ywflId;
   private String  userId;
   private String  typeCode;
   private String  typeName;
   private String  wxWcId;
   private String  wxWAccount;
   private String  userName;
   private String  nickName;
   private String  remark;
   private String  signature;
   private String  sex;
   private String  aliasName;
   private String  country;
   private String  bigHead;
   private String  smallHead;
   private String  labelList;
   private String  v1;
   private String  province;
   private String   city;
   private String   dataJson;


   public String getYwflId() {
      return ywflId;
   }

   public void setYwflId(String ywflId) {
      this.ywflId = ywflId;
   }

   public String getUserId() {
      return userId;
   }

   public void setUserId(String userId) {
      this.userId = userId;
   }

   public String getTypeCode() {
      return typeCode;
   }

   public void setTypeCode(String typeCode) {
      this.typeCode = typeCode;
   }

   public String getTypeName() {
      return typeName;
   }

   public void setTypeName(String typeName) {
      this.typeName = typeName;
   }

   public String getWxWcId() {
      return wxWcId;
   }

   public void setWxWcId(String wxWcId) {
      this.wxWcId = wxWcId;
   }

   public String getWxWAccount() {
      return wxWAccount;
   }

   public void setWxWAccount(String wxWAccount) {
      this.wxWAccount = wxWAccount;
   }

   public String getUserName() {
      return userName;
   }

   public void setUserName(String userName) {
      this.userName = userName;
   }

   public String getNickName() {
      return nickName;
   }

   public void setNickName(String nickName) {
      this.nickName = nickName;
   }

   public String getRemark() {
      return remark;
   }

   public void setRemark(String remark) {
      this.remark = remark;
   }

   public String getSignature() {
      return signature;
   }

   public void setSignature(String signature) {
      this.signature = signature;
   }

   public String getSex() {
      return sex;
   }

   public void setSex(String sex) {
      this.sex = sex;
   }

   public String getAliasName() {
      return aliasName;
   }

   public void setAliasName(String aliasName) {
      this.aliasName = aliasName;
   }

   public String getCountry() {
      return country;
   }

   public void setCountry(String country) {
      this.country = country;
   }

   public String getBigHead() {
      return bigHead;
   }

   public void setBigHead(String bigHead) {
      this.bigHead = bigHead;
   }

   public String getSmallHead() {
      return smallHead;
   }

   public void setSmallHead(String smallHead) {
      this.smallHead = smallHead;
   }

   public String getLabelList() {
      return labelList;
   }

   public void setLabelList(String labelList) {
      this.labelList = labelList;
   }

   public String getV1() {
      return v1;
   }

   public void setV1(String v1) {
      this.v1 = v1;
   }

   public String getProvince() {
      return province;
   }

   public void setProvince(String province) {
      this.province = province;
   }

   public String getCity() {
      return city;
   }

   public void setCity(String city) {
      this.city = city;
   }

   public String getDataJson() {
      return dataJson;
   }

   public void setDataJson(String dataJson) {
      this.dataJson = dataJson;
   }
}
