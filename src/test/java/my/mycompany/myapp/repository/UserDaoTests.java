package my.mycompany.myapp.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import my.mycompany.myapp.domain.User;
import my.mycompany.myapp.repository.IUserDao;

@Slf4j
@SpringBootTest
@AutoConfigureTestDatabase(replace=Replace.NONE)	// Don't replace the application default DataSource.
public class UserDaoTests {	
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
