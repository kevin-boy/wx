package com.jyzw.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TClientInTB {
    private String ciId;
    private String typeCode;
    private String typeName;
    private String interfaceCode;
    private String interfaceName;
    private String isSyn;
    private String state;
    private String adapterName;
    private String classNameB;
    private String requestBody;
    private String curl;
    private String method;
    private String returnBody;
    private String isWrite;
    private String overTime;
    private String isDel;
    private Integer grade;
    private String  data;
    private String  createrDate;
    private String  explain;
}
