package br.com.amigooo.dao;

import java.util.List;

import br.com.amigooo.model.User;

public interface UserDao extends GenericRepository<User>{
	public User getUser(String registration);
	public List<User> getUsersList();
}
