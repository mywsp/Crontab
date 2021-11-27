package com.wsp.crontab.config.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @Description @Scheduled注解方式
 * @Author wsp
 * @Date 2021/11/20 17:23
 **/
//@Component
public class TestCronTab1 {

    private static  final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    //两个任务间隔2000ms执行，若上个任务尚未执行完成，则等待上个任务执行完，下个任务才开始执行
    @Scheduled(fixedRate = 2000)
    public void doSomething1(){
        LocalDateTime now = LocalDateTime.now();
        System.out.println(Thread.currentThread().getName()+" "+dtf.format(now)+" 处理业务1");
    }

    //两个任务间隔2000ms执行，若上个任务尚未执行完成，则等待上个任务执行完之后，再等待2000ms下个任务执行（上个任务结束后计时）
    @Scheduled(fixedDelay = 2000)
    public void doSomething2(){
        LocalDateTime now = LocalDateTime.now();
        System.out.println(Thread.currentThread().getName()+" "+dtf.format(now)+" 处理业务2");
    }

    //按照cron表达式规则周期执行，若上个任务未完成，则会跳过当前的执行周期
    @Scheduled(cron = "0/2 * * * * *")
    public void doSomething3(){
        LocalDateTime now = LocalDateTime.now();
        System.out.println(Thread.currentThread().getName()+" "+dtf.format(now)+" 处理业务3");
    }
}