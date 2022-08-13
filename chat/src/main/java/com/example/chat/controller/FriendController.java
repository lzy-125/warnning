package com.example.chat.controller;

import com.example.chat.common.FriendResponse;
import com.example.chat.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RestController
@RequestMapping("/chat")
public class FriendController {

    @Autowired
    private FriendService friendService;

        @RequestMapping(value = "/getAllFriend")
    public FriendResponse getAllFriend(@RequestParam String fromCode) {
        return friendService.getAllFriend(fromCode);
    }

}
