package my.mycompany.myapp.schedule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class CronTask {
	private static final Logger logger = LoggerFactory.getLogger(CronTask.class);
	
    @Scheduled(cron = "0/5 * * * * *")
    public void work() {
    	logger.info("Demo Task Execution and Scheduling");
    }
}
