package com.example.websocket;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.common.Command;
import com.example.common.MessageResponse;
import com.example.common.Packet.LoginPacket;
import com.example.common.Packet.Packet;
import com.example.common.Packet.SingleMessagePacket;
import com.example.common.User;
import com.example.constants.HttpStatus;
import com.google.gson.Gson;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import java.nio.charset.Charset;
import java.util.Date;

/**
 * Netty服务器的核心处理类
 */
@Component
@Log4j2
public class NioWebSocketHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, TextWebSocketFrame webSocketFrame) throws Exception {
        handlerWebSocketFrame(ctx, webSocketFrame);
    }

    private void handlerWebSocketFrame(ChannelHandlerContext ctx, TextWebSocketFrame webSocketFrame) {

        TextWebSocketFrame textWebSocketFrame = (TextWebSocketFrame) webSocketFrame;
        ByteBuf bytebuf = textWebSocketFrame.content();
        //从content中写入缓冲区
        String content = bytebuf.toString(Charset.forName("utf-8"));
        JSONObject jsonObject = JSONObject.parseObject(content);
        log.info("收到的消息 content:{}",content);
        Byte type = jsonObject.getByte("type");
        JSONObject params = jsonObject.getJSONObject("params");
//        MessageParam messageParam = new Gson().fromJson(content, MessageParam.class);
        Packet packet = null;

        switch (type) {
            // 注册user-->channel 映射
            case 7:
                LoginPacket registerRequestPacket = new LoginPacket();
                User user = JSON.parseObject(params.toJSONString(), User.class);
                registerRequestPacket.setUser(user);
                packet = registerRequestPacket;
                break;
            //私聊
            case 1:
                SingleMessagePacket messagePacket= new SingleMessagePacket();
                messagePacket.setToCode(params.getString("toCode"));
                messagePacket.setContent("content");
                packet = messagePacket;
                break;
        }

        if(type.equals(Command.SINGLE_MESSAGE)){
            ByteBuf buf = getByteBuf(ctx, params.getString("content"));
            TextWebSocketFrame tws = new TextWebSocketFrame(buf);
            ctx.writeAndFlush(tws);
        }
        log.info("获取的包类型：" + packet.getCommand());
        ctx.fireChannelRead(packet);
    }


    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {

//        channelMap.put(ctx.channel().id().asShortText(), ctx.channel());
//        logger.info(ctx.channel().remoteAddress() + "上线！" + "--->" + ctx.channel().id().asShortText());
    }


    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        //断开连接
//        logger.info(ctx.channel().remoteAddress() + "下线！");
    }

    public ByteBuf getByteBuf(ChannelHandlerContext ctx, String message) {
        ByteBuf byteBuf = ctx.alloc().buffer();
//        User fromUser = SessionUtils.getUser(ctx.channel());
        MessageResponse messageResponse = new MessageResponse();
        MessageResponse.Param param = new MessageResponse.Param();
        param.setContent(message);
        param.setSendTime(new Date().toString());
        messageResponse.setType(Command.SELF_RESPONSE);
        messageResponse.setStatus(HttpStatus.SUCCESS);
        messageResponse.setParams(param);
        String str = new Gson().toJson(messageResponse);
//        JSONObject data = new JSONObject();
//        data.put("type", Command.SELF_RESPONSE);
//        data.put("status", 200);
//        JSONObject params = new JSONObject();
//        params.put("message", message);
//        params.put("date", new Date().toString());
//        data.put("params", params);
        byte []bytes = str.getBytes(Charset.forName("utf-8"));
        byteBuf.writeBytes(bytes);
        return byteBuf;
    }
}
