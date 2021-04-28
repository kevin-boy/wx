package com.jyzw.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class YwEyunAccount {
   private String  yweaId;
   private String  eyLoginUrl;
   private String  eyAccount;
   private String  eyPassword;
   private String  eyAuthorization;
   private String  eyApiUrl;
   private String createrDate;
   private String  isDel;
}
