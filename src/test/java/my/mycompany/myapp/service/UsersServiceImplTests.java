package my.mycompany.myapp.service;

import my.mycompany.myapp.domain.User;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;

import org.junit.runner.RunWith;
import org.junit.Test;
import org.junit.Ignore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureTestDatabase(replace=Replace.NONE)	// Don't replace the application default DataSource.
public class UsersServiceImplTests {

	private static final Logger logger = LoggerFactory.getLogger(UsersServiceImplTests.class);
	
	@Autowired
	IUsersService userService;
	
	//@Autowired
	//DefaultWebSecurityManager securityManager;
	
	@Test
	@Transactional
	public void testAddUser()
	{
		User newUser = new User();
		newUser.setUserId("testuser");
		newUser.setCreatedDate(new java.util.Date());
		
		User newUserAdded = userService.insertUser(newUser, "testpassword");
	}
	
	@Test
	@Ignore
	public void verifyPassphase() throws Exception
	{	
		User newUser = new User();
		newUser.setUserId("testuser");
		newUser.setCreatedDate(new java.util.Date());
		
		User newUserAdded = userService.insertUser(newUser, "testpassword");
		
		UsernamePasswordToken token = new UsernamePasswordToken("testuser", "testpassword");
		Subject currentUser = SecurityUtils.getSubject();

		currentUser.login(token);	        		
	}	
}
