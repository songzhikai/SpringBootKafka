package com.demo.kafka;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class KafkaConsumer {
    private static final Logger logger = LoggerFactory.getLogger(KafkaConsumer.class);
    /**
     *  可同时监听多个topic
     * @param record
     * @throws Exception
     */
    @KafkaListener(topics = {"topic_one"})
    public void listen (ConsumerRecord<?, ?> record) throws Exception {
        Optional<?> kafkaMessage = Optional.ofNullable(record.value());
        if (kafkaMessage.isPresent()) {
            Object message = kafkaMessage.get();
            logger.info("消费者开始消费message：" + message);
        }
    }

    @KafkaListener(topics = {"topic_one2"})
    public void listen2 (String message) throws Exception {
        KafkaMessage msg = JSONObject.parseObject(message, KafkaMessage.class);
        KafkaMessageHeader header = msg.getMessageHeader();
        String messageBody = msg.getKafkaMessageBody();
        switch (header.getMessageType()) {
            case "model1":
                logger.info("接收到的消息头：" + JSON.toJSON(header));
                logger.info("接收到的消息体：" + messageBody);
                break;
            case "model2":
                logger.info("接收到的消息头：" + JSON.toJSON(header));
                logger.info("接收到的消息体：" + messageBody);
                break;
            default:
                logger.info("没有对应的消息类型匹配, message={}", message);
        }

    }

}