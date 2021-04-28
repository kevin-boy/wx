package com.jyzw.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class YwReplayRecord {
    private String ycrId;
    private String keyWord;
    private String chatData;
    private String replyContent;
    private String createrDate;
    private String wxWAccount;
    private String wxNickName;
    private String wxSmallHeadImgUrl;
    private String wxChatRoom;
    private String account;
    private String messageType;
    private String wcId;
    private String dataWId;
    private String dataFromUser;
    private String dataFromGroup;
    private String dataToUser;
    private String dataMsgId;
    private String dataNewMsgId;
    private Integer dataMsgType;
    private String dataTimeStamp;
    private String dataContent;
    private String dataSelf;
    private String dataContent1;
}
