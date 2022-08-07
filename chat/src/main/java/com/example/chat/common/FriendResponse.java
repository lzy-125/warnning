package com.example.chat.common;

import lombok.Data;

import java.util.Set;

/**
 * @author andilylzy
 * @date 2022/8/6 下午12:00
 */
@Data
public class FriendResponse {
    private Integer code;

    private Set<Friend> friends;
}
