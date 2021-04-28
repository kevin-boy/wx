package com.jyzw.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TServiceInterfaceMonitorTB {
    private String  simId;
    private String  typeCode;
    private String  typeName;
    private String  serviceCode;
    private String  serviceName;
    private String  adapterName;
    private String  classsName;
    private String  state;
    private String  returnBody;
    private String  processingTime;
}
