package my.mycompany.myapp.service;

import my.mycompany.myapp.domain.User;

public interface IUsersService {

	public User insertUser(User newUser, String password);
}
