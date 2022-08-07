package com.example.common.Packet;

import com.example.common.Command;
import lombok.Data;

/**
 * @author andilylzy
 * @date 2022/8/5 下午9:26
 */
@Data
public class SingleMessagePacket extends Packet {
    private String toCode;
    private String content;

    @Override
    public Byte getCommand() {
        return Command.SINGLE_MESSAGE;
    }
}
