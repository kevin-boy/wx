package com.jyzw.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TSysSwitch {
    private String tssId;
    private String switchCode;
    private String switchName;
    private String switchValue;
    private String explain;
}
