package com.example.websocket;

import com.example.common.Packet.LoginPacket;
import com.example.common.User;
import com.example.utils.SessionUtils;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

/**
 * @author andilylzy
 * @date 2022/8/5 下午9:39
 */
@Service
@Log4j2
public class LoginHandler extends SimpleChannelInboundHandler<LoginPacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, LoginPacket loginPacket) throws Exception {
        User loginUser = loginPacket.getUser();
        SessionUtils.bindChannel(loginUser, ctx.channel());
        if (SessionUtils.hasLogin(ctx.channel())) {
            log.info("该用户已经登录");
        }
    }
}
