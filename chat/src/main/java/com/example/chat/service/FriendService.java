package com.example.chat.service;

import com.example.chat.common.Friend;
import com.example.chat.common.FriendResponse;
import com.example.chat.mapper.FriendMapper;
import com.example.chat.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @author andilylzy
 * @date 2022/8/6 下午12:29
 */
@Service
public class FriendService {
    @Autowired
    private FriendMapper friendMapper;

    public FriendResponse getAllFriend(String fromCode){
        Set<Friend> allFriend = friendMapper.getAllFriend(fromCode);
        FriendResponse response = new FriendResponse();
        response.setCode(Constants.SUCCESS);
        response.setFriends(allFriend);
        return response;
    }
}
