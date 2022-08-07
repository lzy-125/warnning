package com.example.chat.controller;

import com.example.chat.common.MessageParam;
import com.example.chat.common.MessageResponse;
import com.example.chat.service.MessageService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@Log4j2
@RestController
public class MessageController {

    @Autowired
    private MessageService messageService;

    @RequestMapping(value = "/getAllMessage")
    public MessageResponse getAllMessage(MessageParam param) {
        log.info("param :{}",param);
        return messageService.getAllMessage(param);
    }
}
