package com.demo.kafka;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
@EnableScheduling
public class KafkaProducer {
    private Logger logger = LoggerFactory.getLogger(KafkaProducer.class);
    @Autowired
    private KafkaTemplate kafkaTemplate;

    @Scheduled(cron = "*/5 * * * * ?")
    public void sendMessage() {
        String topic = "topic_one2";
        KafkaMessageHeader kafkaMessageHeader = new KafkaMessageHeader();
        kafkaMessageHeader.setSerialNo("1");
        kafkaMessageHeader.setCreateTime(new Date());
        kafkaMessageHeader.setMessageType("model1");
        Map map = new HashMap();
        map.put("id", "111");
        map.put("name", "111");
        KafkaMessage kafkaMessage = new KafkaMessage(kafkaMessageHeader, JSON.toJSONString(map));
        ListenableFuture<SendResult<Integer, String>> future = kafkaTemplate.send(topic, JSON.toJSONString(kafkaMessage));
        future.addCallback(new ListenableFutureCallback<SendResult<Integer, String>>() {
            @Override
            public void onSuccess(SendResult<Integer, String> result) {
                logger.info("发送消息成功");
            }

            @Override
            public void onFailure(Throwable ex) {
                logger.error("发送消息失败");
            }

        });
    }

}