package my.mycompany.myapp.util;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {
	private final static Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	
    @ExceptionHandler(value = {DataAccessException.class, SQLException.class})
    public @ResponseBody String databaseExceptionHandler(HttpServletRequest req, Exception e) throws Exception {
    	logger.debug("Execute databaseExceptionHandler!");
    	
        return "FAILURE:The data access has problem!";
    }
}
