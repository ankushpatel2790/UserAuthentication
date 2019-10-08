package com.transamerica.user.auth.service;

import java.util.List;

import com.transamerica.user.auth.model.UserDetails;

public interface IUserDetailsService {
List<UserDetails>findAll();

UserDetails findUserById(Integer id);

void create(UserDetails userDetails);

}
