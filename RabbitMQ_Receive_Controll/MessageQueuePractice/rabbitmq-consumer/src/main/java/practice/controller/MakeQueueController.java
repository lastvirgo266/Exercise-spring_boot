package practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import practice.service.CustomService;

@RestController
public class MakeQueueController {
	
	@Autowired
	CustomService service;

//	
	@RequestMapping(value="/makeQueue/{id}", method= RequestMethod.GET)
	public void MakeQueue(@PathVariable("id") String id) {
		service.CreateQueue(id);
		
	}
	
	@RequestMapping(value="/read/{id}", method= RequestMethod.GET)
	public void ReadQueue(@PathVariable("id") String id) {
		service.ReceivedMessage(id);
		
	}

}
