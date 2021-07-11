package com.shadow.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Date;

@SpringBootApplication
@EnableScheduling
public class SchedulerApplication {

	Logger logger = LoggerFactory.getLogger(SchedulerApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SchedulerApplication.class, args);
	}

//	@Scheduled(fixedRate = 2000L) // prints the log output after 2 sec, doesn't wait for sleep
//	@Scheduled(fixedDelay = 2000L) // prints the log output after 3 sec (after the 1Sec, it waits for two sec)
//	@Scheduled(fixedDelayString = "PT2S") // same as above/ 'P' duration period, 'T' time duration.
	@Scheduled(cron = "*/2 * * * * *") // run every 2sec
	public void job() throws InterruptedException {
		logger.info("Job1 current time" + new Date());
		Thread.sleep(1000L);

	}

	@Scheduled(cron = "*/2 * * * * *") // run every 2sec
	public void job2() throws InterruptedException {
		logger.info("Job2 current time" + new Date());
		Thread.sleep(1000L);

	}
}
