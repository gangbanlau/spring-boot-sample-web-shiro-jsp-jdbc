package my.mycompany.myapp.domain;

import java.util.Date;

import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;

public class User {

	@NotNull
	private long id;
	
	@NotNull
	@Size(min = 1)
	private String userId;
	
	@Email
	private String email;
	
	@NotNull
	private String passphrase;
	
	@NotNull
	private String salt;
	
	@NotNull
	private Date createdDate;
	
	@Override
	public String toString() {
		return "User [id=" + id + ", userId=" + userId + ", email=" + email
				+ ", passphrase=" + passphrase + ", salt=" + salt
				+ ", createdDate=" + createdDate + ", description="
				+ description + "]";
	}

	private String description;
	
	public long getId() {
		return this.id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getUserId() {
		return this.userId;
	}
	
	public void setUserId(String userid) {
		this.userId = userid;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public void setPassphrase(String pass) {
		this.passphrase = pass;
	}
	
	public String getPassphrase() {
		return this.passphrase;
	}
	
	public void setSalt(String salt) {
		this.salt = salt;
	}
	
	public String getSalt() {
		return this.salt;
	}
	public void setCreatedDate(Date d) {
		this.createdDate = d;
	}
	
	public Date getCreatedDate() {
		return this.createdDate;
	}
	
	public void setDescription(String description)
	{
		this.description = description;
	}
	
	public String getDescription()
	{
		return this.description;
	}
}
