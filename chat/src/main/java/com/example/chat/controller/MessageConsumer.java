package com.example.chat.controller;

import chat.model.Message;
import com.example.chat.service.MessageService;
import com.google.gson.Gson;
import lombok.extern.log4j.Log4j2;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author andilylzy
 * @date 2022/8/5 下午11:14
 */
@Log4j2
@Component
@RocketMQMessageListener(
        topic = "NettyInfo",
        consumerGroup = "NettyInfo",
        selectorExpression = "*"
)
public class MessageConsumer implements RocketMQListener<Object> {
    @Autowired
    private MessageService messageService;

    @Override
    public void onMessage(Object message) {
        log.info("收到的消息 message:{}",message);
        Message msg = new Gson().fromJson((String) message, Message.class);
        messageService.insertMessage(msg);
    }
}
