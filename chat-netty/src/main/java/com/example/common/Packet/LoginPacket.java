package com.example.common.Packet;

import com.example.common.Command;
import com.example.common.User;
import lombok.Data;

/**
 * @author andilylzy
 * @date 2022/8/5 下午9:57
 */
@Data
public class LoginPacket extends Packet{
    private User user;

    @Override
    public Byte getCommand() {
        return Command.REGISTER;
    }
}
