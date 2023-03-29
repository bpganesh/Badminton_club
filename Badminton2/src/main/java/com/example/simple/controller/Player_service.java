package com.example.simple.controller;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestController;

import com.example.simple.Exception.PlayerNotFound;
import com.example.simple.model.Player_details;
import com.example.simple.repository.Player_details_repo;


@RestController
public class Player_service {
	@Autowired
	Player_details_repo playerrepo;
	private static final Logger LOGGER = LoggerFactory.getLogger(Payment_service.class);
	@PostMapping("/insert/player")
	public ResponseEntity<?> createdata(@RequestBody Player_details player){
		
		LOGGER.trace("Entering createdata() method");
		LOGGER.debug("Authenticating Match");
		
		try {
		Player_details _player=playerrepo.save(player);
		LOGGER.info("Successfully created");
		     return new ResponseEntity<>(_player, HttpStatus.CREATED);
		} catch(Exception e) {
			LOGGER.warn("Entering the catch Block");
			return new ResponseEntity<>("Format Wrong", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/print/player/{phonenumber}")
	public Player_details findbyPhonenumber(@PathVariable("phonenumber") String phone) {
		LOGGER.info("Entering the findbyphonenumber()");
		
		return playerrepo.findById(phone).orElseThrow(()-> new PlayerNotFound());
		
		
	}
	@GetMapping("/print/player")
	public List<Player_details> findAll(){
		LOGGER.info("Entering the findall()");
		return playerrepo.findAll();
	}
	

}
