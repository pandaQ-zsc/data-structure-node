package com.example.demo.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * @author: xiong.qiang
 * @date: 2023/3/6 19:57
 */
public class PrintWordsJob implements Job {
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        String currentTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        System.out.println("Print Job" + currentTime + "Hello Job - " + new Random().nextInt(100));
    }
}
