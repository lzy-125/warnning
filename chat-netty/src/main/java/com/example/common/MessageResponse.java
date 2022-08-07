package com.example.common;

import lombok.Data;

/**
 * @author andilylzy
 * @date 2022/8/6 上午9:24
 */
@Data
public class MessageResponse {
    private Byte type;
    private Integer status;
    private Param params;

    @Data
    public static class Param{
        private String fromCode;
        private String toCode;
        private String content;
        private String sendTime;
    }

}
