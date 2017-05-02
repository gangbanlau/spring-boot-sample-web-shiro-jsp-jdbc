package my.mycompany.myapp.web;

import javax.validation.constraints.NotNull;

public class LoginFormBean {

	@NotNull
	private String user;
	
	@NotNull
	private String password;
	
	public void setUser(String user) {
		this.user = user;
	}
	
	public String getUser() {
		return this.user;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPassword() {
		return this.password;	
	}
}
