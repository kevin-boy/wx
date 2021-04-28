package com.jyzw.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TcMp {
    private String mpId;
    private String mpNo;
    private String mpName;
    private String mpAddr;
    private String tgId;
    private String consId;
}
