package com.example.common;

public interface Command {
    Byte SELF_RESPONSE = 0;  //自己发送的消息确认
    Byte SINGLE_MESSAGE = 1;  //私聊消息
//    Integer MESSAGE_RESPONSE = 2; //私聊响应
//    Integer CREATE_GROUP = 3; //创建群
//    Integer CREATE_GROUP_RESPONSE = 4; //创建群响应
//    Integer LOGIN_REQUEST = 5; //登录请求
//    Integer LOGIN_RESPONSE = 6; // 登录响应
    Byte REGISTER = 7;  //注册请求
//    Integer REGISTER_RESPONSE = 8; //注册响应
//    Integer GROUP_MESSAGE = 9;  //发送群消息
//    Integer GROUP_MESSAGE_RESPONSE = 10; //接收群消息
//    Integer HEARTBEAT_REQUEST = 11; //心跳消息请求
//    Integer HEARTBEAT_RESPONSE = 12; //心跳消息恢复
//    Integer RED_PACK_CREATED = 13; //红包发起
//    Integer JOIN_GROUP = 14; //加入群
}
