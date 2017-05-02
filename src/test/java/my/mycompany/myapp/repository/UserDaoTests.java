package my.mycompany.myapp.repository;

import org.junit.runner.RunWith;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import my.mycompany.myapp.domain.User;
import my.mycompany.myapp.repository.IUserDao;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureTestDatabase(replace=Replace.NONE)	// Don't replace the application default DataSource.
public class UserDaoTests {
	private static final Logger logger = LoggerFactory.getLogger(UserDaoTests.class);
	
	@Autowired
	IUserDao userDao;
	
	@Test
	@Transactional
	public void testInsert() {
		User newUser = new User();
		newUser.setCreatedDate(new java.util.Date());
		newUser.setPassphrase("passphase");
		newUser.setSalt("salt");
		newUser.setUserId("userid");
		
		userDao.insert(newUser);
	}
}
