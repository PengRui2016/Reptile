package cn.ylapl.rabbitMQ;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * rabbitMQ发送消息测试
 * Created by Angle on 2017/3/20.
 */

//@Component
public class Sender {
    private static final Logger logger = LoggerFactory.getLogger(Sender.class);

    private final AmqpTemplate amqpTemplate;

    @Autowired
    public Sender(AmqpTemplate amqpTemplate) {
        this.amqpTemplate = amqpTemplate;
    }

//    @Scheduled(fixedDelay = 1000)
//    public void Send() {
//        String context = "hello" + new Date();
//        logger.debug("send messages");
//        amqpTemplate.convertAndSend("test",context);
//    }
}
