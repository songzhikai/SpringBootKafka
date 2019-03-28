package com.demo.kafka;

import java.io.Serializable;

/**
 * {
 *     messageHeader："消息头"，
 *     messageBody: "信息体"
 * }
 */
public class KafkaMessage implements Serializable, Cloneable {
    private static final long serialVersionUID = -3659546761454608926L;
    /**
     * 统一消息头
     */
    protected KafkaMessageHeader messageHeader;

    /**
     * JSON格式消息体
     */
    private String kafkaMessageBody;

    public KafkaMessage(KafkaMessageHeader messageHeader, String kafkaMessageBody){
        this.messageHeader = messageHeader;
        this.kafkaMessageBody = kafkaMessageBody;
    }

    public KafkaMessageHeader getMessageHeader() {
        return messageHeader;
    }

    public void setMessageHeader(KafkaMessageHeader messageHeader) {
        this.messageHeader = messageHeader;
    }

    public String getKafkaMessageBody() {
        return kafkaMessageBody;
    }

    public void setKafkaMessageBody(String kafkaMessageBody) {
        this.kafkaMessageBody = kafkaMessageBody;
    }
}
