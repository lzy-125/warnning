package com.example.utils;
import com.example.common.User;
import io.netty.util.AttributeKey;

/**
 * 设置channel的属性来判断有没有登录   ---》 channel.attr()
 * @author andilylzy
 * @date 2022/8/5 下午9:52
 */
public interface Attributes {
    AttributeKey<User> SESSION = AttributeKey.newInstance("session");
}
