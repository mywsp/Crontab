//package com.wsp.crontab.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.scheduling.annotation.EnableAsync;
//import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
//import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
//
//import java.util.concurrent.ThreadPoolExecutor;
//
////自定义调度线程池
//@Configuration
//public class ThreadPoolTaskConfig {
//
//    @Bean
//    public ThreadPoolTaskScheduler threadPoolTaskScheduler() {
//        ThreadPoolTaskScheduler executor = new ThreadPoolTaskScheduler();
//        executor.setPoolSize(20);
//        executor.setThreadNamePrefix("taskExecutor-");
//        executor.setWaitForTasksToCompleteOnShutdown(true);
//        executor.setAwaitTerminationSeconds(60);
//        return executor;
//    }
//
//}