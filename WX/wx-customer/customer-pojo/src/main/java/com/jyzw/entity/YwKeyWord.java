package com.jyzw.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class YwKeyWord {
    private String ykwId;
    private String userId;
    private String userName;
    private String type;
    private String keyWord;
    private String content;
    private String wxWcId;
    private String isDel;
}
