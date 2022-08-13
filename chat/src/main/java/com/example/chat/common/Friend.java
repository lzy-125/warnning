package com.example.chat.common;

import com.google.gson.annotations.Expose;
import lombok.Data;

@Data
public class Friend {
    @Expose
    private Integer id;
    @Expose
    private String fromCode;
    @Expose
    private String toCode;
}
