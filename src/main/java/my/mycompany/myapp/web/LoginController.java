package my.mycompany.myapp.web;

import javax.validation.Valid;

import my.mycompany.myapp.service.IUsersService;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

@Controller
public class LoginController {
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	//@Autowired
	//private JdbcRealm shiroRealm;		// here using JDBCRealm, need to change if use custom realm
	
	@Autowired
	IUsersService userService;
	
	// Invoked initially to create the "form" attribute
	// Once created the "form" attribute comes from the HTTP session (see @SessionAttributes)

	@ModelAttribute("loginFormBean")
	public LoginFormBean createFormBean() {
		LoginFormBean fb = new LoginFormBean();
		return fb;
	}
		
    @RequestMapping(value="/login",method=RequestMethod.POST)
    public String onSubmit(@Valid LoginFormBean loginFormBean,
    		BindingResult result, SessionStatus sessionStatus) {

    	if (result.hasErrors()) {
    		logger.info("valid result has errors");
    		return null;
    	}
  
        String userid = loginFormBean.getUser();
        String passphrase = loginFormBean.getPassword();
        UsernamePasswordToken token = new UsernamePasswordToken(userid, passphrase);
        Subject currentUser = SecurityUtils.getSubject();

        try {
          currentUser.login(token);
          logger.info("AUTH SUCCESS");
        } catch (AuthenticationException ae) {
          logger.info("AUTH MSSG: " + ae.getMessage());
          return null;
        }
        
        return "redirect:/inventory";
    }
    
    @RequestMapping(value="/login", method=RequestMethod.GET)
    public String form(ModelMap model) {	
    	return "login";
    }
    
    @RequestMapping(value="/logout", method=RequestMethod.GET)
    public String logout(ModelMap model) {
    	Subject currentUser = SecurityUtils.getSubject();
    	currentUser.logout();
    	return "redirect:/";
    }    
}
