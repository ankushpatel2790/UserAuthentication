package com.transamerica.user.auth.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.transamerica.user.auth.model.TextData;
import com.transamerica.user.auth.service.ICommonWordFinderService;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "CommonWordFinderController")
@Path("/api")
@RestController
public class CommonWordFinderController {

	Logger log = LoggerFactory.getLogger(CommonWordFinderController.class);

	@Autowired
	private ICommonWordFinderService commonWordService;

	@POST
	@Consumes("application/json")
	@Produces("application/json")
	@Path("/findCommondWords")
	public List<String> findCommondWords( TextData filesPath) {
		List<String> commandWord = commonWordService.findCommandWord(filesPath.getPath());

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
