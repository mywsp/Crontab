package com.wsp.crontab.config;

import com.wsp.crontab.job.MyJob;
import com.wsp.crontab.job.MyJob1;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuartzConfiguration {



    // 使用jobDetail包装job
    @Bean
    public JobDetail MyJobDetail() {
        return JobBuilder.newJob(MyJob.class).withIdentity("myJob").storeDurably().build();
    }

    // 使用jobDetail包装job
    @Bean
    public JobDetail MyJobDetail1() {
        return JobBuilder.newJob(MyJob1.class).withIdentity("myJob1").storeDurably().build();
    }

    // 把jobDetail注册到Cron表达式的trigger上去
    @Bean
    public Trigger CronJobTrigger() {
        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule("0/2 * * * * ?");
        return TriggerBuilder.newTrigger()
                .forJob(MyJobDetail())
                .withIdentity("myJobTrigger")
                .withSchedule(cronScheduleBuilder)
                .build();
    }

    // 把jobDetail注册到Cron表达式的trigger上去
    @Bean
    public Trigger CronJobTrigger1() {
        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule("0/2 * * * * ?");
        return TriggerBuilder.newTrigger()
                .forJob(MyJobDetail1())
                .withIdentity("myJob1Trigger")
                .withSchedule(cronScheduleBuilder)
                .build();
    }

}