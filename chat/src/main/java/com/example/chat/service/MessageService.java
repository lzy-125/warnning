package com.example.chat.service;

import com.example.chat.common.Message;
import com.example.chat.common.MessageParam;
import com.example.chat.common.MessageResponse;
import com.example.chat.mapper.MessageMapper;
import com.example.constants.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author andilylzy
 * @date 2022/8/6 下午12:22
 */
@Service
public class MessageService {
    @Autowired
    private MessageMapper messageMapper;

    public MessageResponse getAllMessage(MessageParam param){
        List<Message> allMessage = messageMapper.getAllMessage(param.getFromCode(), param.getToCode());
        MessageResponse messageResponse = new MessageResponse();
        messageResponse.setCode(Constants.SUCCESS);
        messageResponse.setMessages(allMessage);
        return messageResponse;
    }

    public void insertMessage(Message message){
        messageMapper.insertMessage(message);
    }
}
