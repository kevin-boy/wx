package com.jyzw.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TgTg {
    private String tgId;
    private String orgNo;
    private String tgNo;
    private String tgName;
    private String tgCap;
    private String instAddr;
    private String chgDate;
    private String pubPrivFlag;
    private String runStatusCode;
    private String explain;
}
