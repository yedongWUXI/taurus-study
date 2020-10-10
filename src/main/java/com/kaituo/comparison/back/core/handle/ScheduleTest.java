package com.kaituo.comparison.back.core.handle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description:
 * @Author: yedong
 * @Date: 2020/4/7 15:30
 * @Modified by:
 */
@Component
//@EnableScheduling
public class ScheduleTest {

    private ExecutorService executorService = Executors.newSingleThreadExecutor();

    Logger logger = LoggerFactory.getLogger(ScheduleTest.class);

    @Scheduled(cron = "0/10 * *  * * ? ")
    public void logTest() {
//        logger.info("这是slf4j的测试，参数1:{}，参数2:{}", "1", "2");

        for (int i = 0; i < 10; i++) {
            logger.info("这是多线程测试");
            executorService.execute(() -> sleep());
        }
    }


    public void sleep() {
        try {
            Thread.sleep(5000);
            logger.info("这是slf4j的测试，参数1:{}，参数2:{}", "1", "2");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
