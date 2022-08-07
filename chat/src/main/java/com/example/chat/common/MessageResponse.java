package com.example.chat.common;

import lombok.Data;

import java.util.List;

/**
 * @author andilylzy
 * @date 2022/8/6 上午11:38
 */
@Data
public class MessageResponse {

    private Integer code;

    private List<Message> messages;
}
