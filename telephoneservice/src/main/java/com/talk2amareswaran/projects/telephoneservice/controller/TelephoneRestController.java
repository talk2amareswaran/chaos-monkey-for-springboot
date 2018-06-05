package com.talk2amareswaran.projects.telephoneservice.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.talk2amareswaran.projects.telephoneservice.model.Numbers;

@RestController
public class TelephoneRestController {

	List<Numbers> numbersList = new ArrayList<>();
	
	@PostConstruct
	public void initiateNumbers() {
		Numbers number1 = new Numbers();
		number1.setNumber("9201394034");
		number1.setStatus("AVAILABLE");
		numbersList.add(number1);
		
		Numbers number2 = new Numbers();
		number2.setNumber("3940393034");
		number2.setStatus("PORTED");
		numbersList.add(number2);
	}
	
	@RequestMapping(value="/numbers", method=RequestMethod.GET)
	public ResponseEntity<Object> getNumbers() {
		return new ResponseEntity<>(numbersList,HttpStatus.OK);
	}
}
