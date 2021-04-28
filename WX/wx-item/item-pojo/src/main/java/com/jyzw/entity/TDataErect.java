package com.jyzw.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TDataErect {
    private String erectId;
    private String dName;
    private String dCode;
    private String dValue;
    private String pid;
    private  int   grade;
    private String explain;
    private String isDel;
}
