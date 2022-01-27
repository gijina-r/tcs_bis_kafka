package com.tcs.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.demo.service.KafKaConsumerService;
import com.tcs.demo.service.KafKaProducerService;

@RestController
@RequestMapping(value="/kafka")
public class kafkaController {
	
	@Autowired
	private KafKaConsumerService kafKaConsumerService;
	@Autowired
	private KafKaProducerService kafKaProducerService;
	 
	  @GetMapping
	  public List<String> getAllMessage() {
	  return kafKaConsumerService.consume();
	  }
	  
	  @PostMapping(value="/{message}")
	  public void sendMessage(@PathVariable String message, HttpServletRequest rq) {
		  kafKaProducerService.sendMessage(message);
	  }

}
