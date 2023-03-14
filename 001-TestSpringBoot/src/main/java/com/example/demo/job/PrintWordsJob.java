package com.example.demo.job;

import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Random;

/**
 * @author: xiong.qiang
 * @date: 2023/3/6 19:57
 */
public class PrintWordsJob implements Job {
    public static final Logger log = LoggerFactory.getLogger(PrintWordsJob.class);

    @Override
    public void execute(JobExecutionContext context) {
        String currentTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        String format = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println(format);
        System.out.println("================");
        LocalDateTime ctt = LocalDateTime.ofInstant(Instant.now(), ZoneId.of(ZoneId.SHORT_IDS.get("CTT")));
        String s = ctt.toLocalDate().toString();
        System.out.println(s);
        System.out.println("================");
        System.out.println("Print Job " + currentTime + " Hello Job - " + new Random().nextInt(10));
        JobDetail jobDetail = context.getJobDetail();
        jobDetail.getJobDataMap().forEach((a, b) -> {
            System.out.println(a + " ---> " + b);
        });
        context.getJobDetail().getJobDataMap().forEach((k, v) -> log.info("param key :{} , vallue :{} ", k, v));
    }
}
