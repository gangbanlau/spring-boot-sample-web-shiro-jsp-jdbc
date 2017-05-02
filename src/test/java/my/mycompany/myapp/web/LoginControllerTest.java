package my.mycompany.myapp.web;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import my.mycompany.myapp.service.IUsersService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(LoginController.class)
public class LoginControllerTest {
	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private IUsersService userService;
	
	@Test
	public void test() throws Exception {
		this.mvc.perform(get("/login"))
				.andExpect(status().isOk())
				.andExpect(forwardedUrl("/WEB-INF/views/login.jsp"));
	}
	
	@Test
	@Ignore			// TODO fix it
	public void verifyPassphase() throws Exception
	{				
		this.mvc.perform(post("/login").param("user", "admin").param("password", "TestUserPassword"))
			.andExpect(status().isOk())
			.andExpect(redirectedUrl("/inventory"));
	}	
}
