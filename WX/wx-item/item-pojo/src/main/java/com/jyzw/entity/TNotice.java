package com.jyzw.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TNotice {
    private String noticeId;
    private String type;
    private String title;
    private String content;
    private String createrId;
    private String userName;
    private String createrDate;
    private String isDel;
    private String endDate;
}
