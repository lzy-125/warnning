package com.example.config;

import lombok.extern.log4j.Log4j2;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @创建人 liuzongyu
 * @创建时间 2021/12/10
 * @描述
 */
@Component
@Log4j2
public class MQUtils {
    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    public void MessageSend(String topic, Object message) {
        rocketMQTemplate.convertAndSend(topic,message);
        log.info("消息队列的消息已经发送拉...");
    }

}
