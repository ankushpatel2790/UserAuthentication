package com.transamerica.user.auth.dao;

import java.util.List;

import com.transamerica.user.auth.model.UserDetails;

public interface IUserDetailsDao {
	List<UserDetails>findAll();

	UserDetails findUserById(Integer id);

	void create(UserDetails userDetails);
}
