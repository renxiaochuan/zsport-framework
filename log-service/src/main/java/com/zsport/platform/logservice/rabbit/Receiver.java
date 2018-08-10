package com.zsport.platform.logservice.rabbit;

import com.alibaba.fastjson.JSON;
import com.zsport.platform.logservice.entity.SysLog;
import com.zsport.platform.logservice.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

/**
 * Created by fangzhipeng on 2017/7/12.
 */
@Component
public class Receiver {

    private CountDownLatch latch = new CountDownLatch(1);

    @Autowired
    SysLogService sysLogService;
    public void receiveMessage(String message) {
        System.out.println("Received <" + message + ">");
        SysLog sysLog=  JSON.parseObject(message,SysLog.class);
        sysLogService.saveLogger(sysLog);
        latch.countDown();
    }


}