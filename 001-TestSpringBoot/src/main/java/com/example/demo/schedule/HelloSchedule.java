package com.example.demo.schedule;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author xxx
 */
@Slf4j
@Component
public class HelloSchedule {

    /**
     * 在Spring中 只允许6位 [* * * ? * 1] : 每周一每秒执行一次
     * [* /5 * * ? * 1] : 每周一 每5秒执行一次
     * 1.定时任务不应阻塞 [默认是阻塞的]
     * 2.定时任务线程池 spring.task.scheduling.pool.size=5
     * 3.让定时任务异步执行
     */
    @Async
    @Scheduled(cron = "*/2 * * * * *")
    public void hello() {
        log.info("i love you...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
