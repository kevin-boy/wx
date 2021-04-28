package com.jyzw.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Table(name="yw_wx_msg_record")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WxMsgRecord implements Serializable {
    @Id
    @Column(name="ywmr_id")
    private String ywmrId;
    @Column(name="msg_data")
    private String msgData;
    @Column(name="creater_date")
    private String  createrDate;
    @Column(name="httpUrl")
    private String httpUrl;
    private String account;
    @Column(name="data_content")
   private String dataContent;
   @Column(name="data_fromGroup")
   private String dataFromGroup;
   @Column(name="data_fromUser")
   private String dataFromUser;
   @Column(name="data_msgId")
    private String dataMsgId;
   @Column(name="data_newMsgId")
    private String dataNewMsgId;
   @Column(name="data_self")
   private String dataSelf;
    @Column(name="data_timestamp")
    private String dataTimeStamp;
    @Column(name="data_toUser")
    private String dataToUser;
    @Column(name="data_wId")
    private String dataWId;
    @Column(name="messageType")
    private String messageType;
}
