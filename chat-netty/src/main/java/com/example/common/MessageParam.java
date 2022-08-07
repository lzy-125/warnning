package com.example.common;

import lombok.Data;

/**
 * @author andilylzy
 * @date 2022/8/5 下午9:09
 */
@Data
public class MessageParam {

    private Integer type;

    private UserInfo userInfo;

    @Data
    public static class UserInfo{
        private String fromCode;
        private String toCode;
        private String content;
//        private String password;
    }
}
