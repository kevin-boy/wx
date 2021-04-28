package com.jyzw.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TClientIntMonTB {
    private String cimId;
    private String typeCode;
    private String typeName;
    private String interfaceCode;
    private String interfaceName;
    private String adapterName;
    private String classsName;
    private String state;
    private String  requestBody;
    private String returnBody;
    private String processingTime;
}
