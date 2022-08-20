package com.example.chat.common;

import chat.model.Message;
import com.google.gson.annotations.Expose;
import lombok.Data;
import java.util.List;

/**
 * @author andilylzy
 * @date 2022/8/6 上午11:38
 */
@Data
public class MessageResponse {

    @Expose
    private Integer code;
    @Expose
    private List<Message> messages;
}
