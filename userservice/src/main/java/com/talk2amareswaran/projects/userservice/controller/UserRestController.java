package com.talk2amareswaran.projects.userservice.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.talk2amareswaran.projects.userservice.model.User;

@RestController
public class UserRestController {

	List<User> usersList = new ArrayList<>();

	@PostConstruct
	public void initialize() {
		User user1 = new User();
		user1.setEmailId("talk2amareswaran@gmail.com");
		user1.setFirstName("Amareswaran");
		user1.setId(1);
		user1.setLastName("Suriyamurthy");
		user1.setMobile("+918939052159");
		user1.setUserName("talk2amareswaran");
		usersList.add(user1);

		User user2 = new User();
		user2.setEmailId("william_s@gmail.com");
		user2.setFirstName("William");
		user2.setId(2);
		user2.setLastName("Smith");
		user2.setMobile("+918493039303");
		user2.setUserName("william_smith");
		usersList.add(user2);

	}

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public ResponseEntity<Object> getUsers() {
		return new ResponseEntity<>(usersList, HttpStatus.OK);
	}
}
