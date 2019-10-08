package com.transamerica.user.auth.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.transamerica.user.auth.dao.IUserDetailsDao;
import com.transamerica.user.auth.model.UserDetails;
import com.transamerica.user.auth.service.IUserDetailsService;

@Service
public class UserDetailsServiceImpl implements IUserDetailsService {
	@Autowired
	private IUserDetailsDao userDetailsDao;

	
	


	@Override
	public List<UserDetails> findAll() {
		return userDetailsDao.findAll();
	}

	@Override
	public UserDetails findUserById(Integer id) {
		
		return userDetailsDao.findUserById(id);
	}

	@Transactional
	@Override
	public void create(UserDetails userDetails) {
		userDetailsDao.create(userDetails);
		
	}

}
