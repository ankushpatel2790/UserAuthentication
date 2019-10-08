package com.transamerica.user.auth.daoImpl;

import java.util.List;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.transamerica.user.auth.configuration.AbstractDaoConfig;
import com.transamerica.user.auth.dao.IUserDetailsDao;
import com.transamerica.user.auth.model.UserDetails;

@Repository
public class UserDetailsDaoImpl extends AbstractDaoConfig<UserDetails>implements IUserDetailsDao {

	public UserDetailsDaoImpl() {
		super();
		setClazz(UserDetails.class);
	}

	@Override
	public List<UserDetails> findAll() {

		return findAll();
	}

	@Override
	public UserDetails findUserById(Integer id) {

		return (UserDetails) findById(id);
	}

}
