package com.example.utils;

import com.example.common.User;
import io.netty.channel.Channel;
import lombok.extern.log4j.Log4j2;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Log4j2
public class SessionUtils {
	/**
	 * userID 映射 连接channel
	 */
	public static Map<String, Channel> userIdChannelMap = new ConcurrentHashMap<>();


	public static void bindChannel(User user, Channel channel) {
		userIdChannelMap.put(user.getUserName(), channel);
		log.info(user.getUserName() + "已经登陆...");
		log.info("userIdChannelMap: {}",userIdChannelMap);
		channel.attr(Attributes.SESSION).set(user);
	}

	public static boolean hasLogin(Channel channel) {
		return channel.hasAttr(Attributes.SESSION);
	}

	public static User getUser(Channel channel) {
		return channel.attr(Attributes.SESSION).get();
	}

	public static Channel getChannel(String userName) {
		return userIdChannelMap.get(userName);
	}

}
