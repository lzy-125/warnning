package com.example.chat.common;

import com.google.gson.annotations.Expose;
import lombok.Data;

import java.util.Set;

/**
 * @author andilylzy
 * @date 2022/8/6 下午12:00
 */
@Data
public class FriendResponse {
    @Expose
    private Integer code;
    @Expose
    private Set<Friend> friends;
}
