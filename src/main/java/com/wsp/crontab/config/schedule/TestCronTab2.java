package com.wsp.crontab.config.schedule;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @Description @Scheduled注解方式（异步执行）
 * @Author wsp
 * @Date 2021/11/20 17:23
 **/
@EnableAsync
//@Component
public class TestCronTab2 {

    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Scheduled(fixedRate = 2000)
    @Async
    public void doSomething1(){
        LocalDateTime now = LocalDateTime.now();
        System.out.println(Thread.currentThread().getName()+" "+dtf.format(now)+" 处理业务1(Async)");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Scheduled(fixedDelay = 2000)
    @Async
    public void doSomething2(){
        LocalDateTime now = LocalDateTime.now();
        System.out.println(Thread.currentThread().getName()+" "+dtf.format(now)+" 处理业务2(Async)");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Scheduled(cron = "0/2 * * * * *")
    @Async
    public void doSomething3(){
        LocalDateTime now = LocalDateTime.now();
        System.out.println(Thread.currentThread().getName()+" "+dtf.format(now)+" 处理业务3(Async)");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}