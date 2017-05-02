package my.mycompany.myapp.util;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class SessionListener implements HttpSessionListener {
	private final static Logger logger = LoggerFactory.getLogger(SessionListener.class);
	
    @Override
    public void sessionCreated(HttpSessionEvent event) {
        logger.info("==== Session is created ====");
        
        // overwrite session timeout
        // event.getSession().setMaxInactiveInterval(5*60);
    }
 
    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
    	logger.info("==== Session is destroyed ====");
    }
}