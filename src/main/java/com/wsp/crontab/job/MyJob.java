package com.wsp.crontab.job;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@DisallowConcurrentExecution //注解表示同一个任务，等上个任务执行完成才会执行（即作业不并发，串行执行）
public class MyJob implements Job {

    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(Thread.currentThread().getName()+" "+dtf.format(now)+" 处理MyJob");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
