package com.narvee.usit.service;

import com.narvee.usit.entity.User;

public interface IUserService {

	public Integer saveUser(User user);
	public User findByUsername(String username);
}
