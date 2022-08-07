package com.example.websocket;

import com.example.common.Command;
import com.example.common.Message;
import com.example.common.MessageResponse;
import com.example.common.Packet.SingleMessagePacket;
import com.example.common.User;
import com.example.config.MQUtils;
import com.example.constants.HttpStatus;
import com.example.constants.Topic;
import com.example.utils.SessionUtils;
import com.google.gson.Gson;
import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.Charset;
import java.util.Date;

/**
 * @author andilylzy
 * @date 2022/8/5 下午10:05
 */
@Service
@Log4j2
public class SingleMessageHandler extends SimpleChannelInboundHandler<SingleMessagePacket> {

    @Autowired
    MQUtils mqUtils;

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, SingleMessagePacket singleMessagePacket) throws Exception {
        Boolean onLine;
        String message = "";
        Channel toCodeChannel = SessionUtils.getChannel(singleMessagePacket.getToCode());
        if (toCodeChannel != null && SessionUtils.hasLogin(toCodeChannel)) {
            message = singleMessagePacket.getContent();
            sendMessage(ctx,message, singleMessagePacket.getToCode(), Topic.OnLine,true);
        }else {
            message = singleMessagePacket.getContent();
            sendMessage(ctx,message, singleMessagePacket.getToCode(), Topic.OffLine,true);
        }
        User toUser = SessionUtils.getUser(toCodeChannel);
        ByteBuf buf = getByteBuf(ctx, message, toUser);
        toCodeChannel.writeAndFlush(new TextWebSocketFrame(buf));

        log.info(SessionUtils.getUser(ctx.channel()).getUserName() + "发送了消息给" + singleMessagePacket.getToCode() + "：" + singleMessagePacket.getContent());
    }

    public ByteBuf getByteBuf(ChannelHandlerContext ctx, String message, User toCode) {
        ByteBuf byteBuf = ctx.alloc().buffer();
        User fromUser = SessionUtils.getUser(ctx.channel());
        MessageResponse messageResponse = new MessageResponse();
        MessageResponse.Param param = new MessageResponse.Param();
        param.setFromCode(fromUser.getUserName());
        param.setContent(message);
        param.setToCode(toCode.getUserName());
        param.setSendTime(new Date().toString());
        messageResponse.setType(Command.SELF_RESPONSE);
        messageResponse.setStatus(HttpStatus.SUCCESS);
        messageResponse.setParams(param);
        String str = new Gson().toJson(messageResponse);
//        JSONObject data = new JSONObject();
//        data.put("type", 2);
//        data.put("status", 200);
//        JSONObject params = new JSONObject();
//        params.put("message", content);
//        params.put("fromCode", fromUser);
//        params.put("toCode", toCode);
//        data.put("params", params);
        byte []bytes = str.getBytes(Charset.forName("utf-8"));
        byteBuf.writeBytes(bytes);
        return byteBuf;
    }

    public void sendMessage(ChannelHandlerContext ctx, String message, String toCode, String state, Boolean type) {
        Message messageMQ = new Message();
        messageMQ.setFromCode(SessionUtils.getUser(ctx.channel()).getUserName());
        messageMQ.setToCode(toCode);
        messageMQ.setType(state);
        messageMQ.setContent(message);
        messageMQ.setSendTime(new Date().toString());
        messageMQ.setState(type);

        mqUtils.MessageSend(Topic.OnLineTopic,messageMQ);
    }
}
