package com.transamerica.user.auth.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.transamerica.user.auth.service.ICommonWordFinderService;

@Path("/api")
@RestController
public class CommonWordFinderController {

	Logger log = LoggerFactory.getLogger(CommonWordFinderController.class);

	@Autowired
	private ICommonWordFinderService commonWordService;

	@POST
	@Path("/findCommonWords")
	@Consumes({"applicaton/json","text/plain"})
	@Produces("applicaton/json")
	public List<String> findCommondWords(@RequestBody String filesPath) {
		List<String> commandWord = commonWordService.findCommandWord(filesPath);

		return commandWord;

	}

	
	@GET
	@Path("/find/{id}")
	@Consumes({"applicaton/json","text/plain"})
	@Produces("applicaton/json")
	public List<String> find(@PathParam("id") String filesPath) {
		List<String> commandWord = commonWordService.findCommandWord(filesPath);

		return commandWord;

	}
}
