package com.transamerica.user.auth.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.transamerica.user.auth.model.UserDetails;
import com.transamerica.user.auth.service.IUserDetailsService;

@Path("/api")
@RestController
public class UserAuthenticationController {

	Logger logger = LoggerFactory.getLogger(UserAuthenticationController.class);

	@Autowired
	private IUserDetailsService userDetailsService;

	@GET
	@Path("/findUserById/{id}")
	@Consumes("application/json")
	@Produces("application/json")
	public UserDetails findUserById(@PathParam("id") Integer id) {
		logger.info("Find User by id :{}", id);
		return userDetailsService.findUserById(id);
	}

	@POST
	@Consumes("application/json")
	@Produces("application/json")
	@Path("/create")
	public Response create(@RequestBody UserDetails userDetails) {
		logger.info("create User ");
		userDetailsService.create(userDetails);
		return Response
                .status(200)
                .entity(userDetails)
                .build();
	}

}
