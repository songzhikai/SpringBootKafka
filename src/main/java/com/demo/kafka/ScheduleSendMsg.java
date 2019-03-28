package com.demo.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

//定时发送信息
//每隔5秒执行一次：*/5 * * * * ?
//每隔1分钟执行一次：0 */1 * * * ?
//每天23点执行一次：0 0 23 * * ?
//每天凌晨1点执行一次：0 0 1 * * ?
//每月1号凌晨1点执行一次：0 0 1 1 * ?
//每月最后一天23点执行一次：0 0 23 L * ?
//每周星期天凌晨1点实行一次：0 0 1 ? * L
//在26分、29分、33分执行一次：0 26,29,33 * * * ?
//每天的0点、13点、18点、21点都执行一次：0 0 0,13,18,21 * * ?

@Component
//@EnableScheduling
public class ScheduleSendMsg {
    private static final Logger logger = LoggerFactory.getLogger(ScheduleSendMsg.class);
    private  static final SimpleDateFormat dataFromat = new SimpleDateFormat("HH:mm:ss");

//    @Scheduled(cron="0/3 * * * * ?")
    public void reportCurrent(){
        logger.info("现在时间：{}",dataFromat.format(new Date()));
    }

}