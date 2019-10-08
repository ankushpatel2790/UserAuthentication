package com.transamerica.user.auth.controller;

import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

@Path("/api/commonWordFinder")
@RestController
public class CommonWordFinderController {
	
	Logger log=LoggerFactory.getLogger(CommonWordFinderController.class);
	
	@GET
	@Path("/findCommonWords")
	@Consumes("applicaton/json")
	@Produces("applicaton/json")
	public Set<String> findCommondWords(@QueryParam("filesPath") String filesPath){
		
		
		return null;
		
	}

}
