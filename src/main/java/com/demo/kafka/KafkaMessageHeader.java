package com.demo.kafka;

import java.io.Serializable;
import java.util.Date;

public class KafkaMessageHeader implements Serializable, Cloneable {
    private static final long serialVersionUID = 4471705521989631577L;

    //消息惟一标识
    private String serialNo;

    //创建时间
    private Date createTime;

    //消息类型，用于区分不同业务消息
    private String messageType;

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }
}
