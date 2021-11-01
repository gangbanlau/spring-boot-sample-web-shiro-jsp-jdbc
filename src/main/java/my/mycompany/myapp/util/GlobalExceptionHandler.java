package my.mycompany.myapp.util;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = {DataAccessException.class, SQLException.class})
    public @ResponseBody String databaseExceptionHandler(HttpServletRequest req, Exception e) throws Exception {
    	log.debug("Execute databaseExceptionHandler!");
    	
        return "FAILURE:The data access has problem!";
    }
}
