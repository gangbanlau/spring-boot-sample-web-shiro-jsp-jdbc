package my.mycompany.myapp.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class CronTask {	
    @Scheduled(cron = "0/5 * * * * *")
    public void work() {
    	log.info("Demo Task Execution and Scheduling");
    }
}
