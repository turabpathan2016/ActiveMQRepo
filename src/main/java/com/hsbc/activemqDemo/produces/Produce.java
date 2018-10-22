package com.hsbc.activemqDemo.produces;

import javax.jms.Queue;

import org.apache.commons.logging.Log;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/rest/api")
public class Produce {
	@Autowired
	JmsTemplate jmsTemplate;
	@Autowired 
	Queue queue;
	final static Logger logger = Logger.getLogger(Produce.class);
	@GetMapping("/hello/{message}")
	public String produce(@PathVariable final String message ) {
		
		jmsTemplate.convertAndSend(queue,message);
		//Object o=jmsTemplate.receiveAndConvert();
		logger.info("This MQ Message:Success!!");
		return "Success!!!";
	}
	

}
