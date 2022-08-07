package com.example.websocket;


import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.stream.ChunkedWriteHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NioWebSocketChannelInitializer extends ChannelInitializer<SocketChannel> {

    @Autowired
    LoginHandler loginHandler;

    @Autowired
    SingleMessageHandler singleMessageHandler;

    @Autowired
    NioWebSocketHandler nioWebSocketHandler;


    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        socketChannel.pipeline().addLast(new HttpServerCodec())
                .addLast(new ChunkedWriteHandler())
                .addLast(new HttpObjectAggregator(1024 * 62))
                .addLast(new WebSocketServerProtocolHandler("/ws"))
                .addLast(nioWebSocketHandler)
                .addLast(loginHandler)
                .addLast(singleMessageHandler);
    }

}

