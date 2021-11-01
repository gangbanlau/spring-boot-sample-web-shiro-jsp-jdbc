package my.mycompany.myapp.util;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class SessionListener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent event) {
        log.info("==== Session is created ====");
        
        // overwrite session timeout
        // event.getSession().setMaxInactiveInterval(5*60);
    }
 
    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
    	log.info("==== Session is destroyed ====");
    }
}