package com.jyzw.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TServiceInterfaceTB {
    private String siId;
    private String typeCode;
    private String typeName;
    private String serviceCode;
    private String serviceName;
    private String isSyn;
    private String state;
    private String adapterName;
    private String classsName;
    private String returnBody;
    private String isWrite;
    private String  isDel;
    private Integer grade;
    private String  data;
    private String  createrDate;
    private String  explain;
}
