package com.wsp.crontab.config.schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.stereotype.Component;

/**
 * @Description ThreadPoolTaskScheduler线程池调度方式（默认单个线程）
 * @Author wsp
 * @Date 2021/11/21 15:44
 **/
@Component
public class TestCronTab3 {

    @Autowired
    private ThreadPoolTaskScheduler threadPoolTaskScheduler;

    @Bean
    public void doTask1() {
        TestCronTab2 testCronTab2 = new TestCronTab2();
        threadPoolTaskScheduler.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                testCronTab2.doSomething1();
            }
        }, 2000);
    }
}