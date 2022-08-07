package com.example.chat.common;
import lombok.Data;

@Data
public class Message {

    //发送的消息
    private String content;
    //消息时间
    private String sendTime;
    //消息发送方
    private String fromCode;
    //消息接收方
    private String toCode;
    //消息类型 在线或离线
    private String type;
    // 消息状态 在线或离线 1为私聊 0为群聊
    private Boolean state;
}
