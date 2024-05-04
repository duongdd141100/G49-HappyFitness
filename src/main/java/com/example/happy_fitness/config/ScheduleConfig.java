package com.example.happy_fitness.config;

import com.example.happy_fitness.task.ScheduleRunnable;
import com.example.happy_fitness.task.TicketRunnable;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.config.Task;

@Configuration
@EnableScheduling
@Slf4j
public class ScheduleConfig {
    @Autowired
    private TicketRunnable ticketRunnable;

    @Autowired
    private ScheduleRunnable scheduleRunnable;

    @Scheduled(cron = "0 0 0 ? * *")
    public void expireTicket() {
        try {
            Task task = new Task(() -> ticketRunnable.expire());
            task.getRunnable().run();
        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
        }
    }

    @Scheduled(cron = "0 0 0 ? * SAT")
    public void createScheduleNextWeek() {
        try {
            log.info("Create schedule");
            Task task = new Task(() -> scheduleRunnable.createScheduleNextWeek());
            task.getRunnable().run();
        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
        }
    }
}
