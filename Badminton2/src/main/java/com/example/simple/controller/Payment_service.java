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
import org.springframework.web.bind.annotation.RestController;

import com.example.simple.Exception.PlayerNotFound;
import com.example.simple.model.Payment_details;
import com.example.simple.model.Player_details;
import com.example.simple.repository.Payment_details_repo;
import com.example.simple.repository.Player_details_repo;

@RestController
public class Payment_service {
	@Autowired
	Payment_details_repo paymentrepo;
	@Autowired
	Player_details_repo playerrepo;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(Payment_service.class);
	@PostMapping("/insert/payment")
	public ResponseEntity<?> createpayment(@RequestBody Payment_details payment){
		
		LOGGER.trace("Entering createpayment() method");
		LOGGER.debug("Authenticating Match");
		
		try {
			Payment_details _payment=paymentrepo.save(new Payment_details(find(payment.getPlayer_phone_number()),
					payment.getDate_of_payment(),payment.getAmount_paid()));
			LOGGER.info("Transaction Successfully");
			Player_details id=playerrepo.findById(payment.getPlayer_phone_number()).orElse(null);
			id.setAccount_balance(id.getAccount_balance()-payment.getAmount_paid());
			
			playerrepo.save(new Player_details(id.getPhonenumber(),id.getName(),id.getAccount_balance()));
			LOGGER.info("Payment Details update in player table");
			
			
			return new ResponseEntity<>("Transaction Successfully ", HttpStatus.CREATED);
		}catch(Exception e) {
			LOGGER.warn("Entering the catch block");
			throw new PlayerNotFound();
		}
	}
	private String find(String player_phone_number) {
		// TODO Auto-generated method stub
		LOGGER.info("Check Phonenumber");
		Player_details p=playerrepo.findById(player_phone_number).orElseThrow(()->new PlayerNotFound());
		return p.getPhonenumber();
	}
	@GetMapping("/print/payment")
	public List<Payment_details> findall(){
		LOGGER.trace("Entering the Findall()");
		return paymentrepo.findAll();
	}
	@GetMapping("/print/payment/{phonenumber}")
	public Payment_details findbyPhonenumber(@PathVariable("phonenumber") String phone) {
		LOGGER.trace("Entering the find by phonenumber()");
		return paymentrepo.findById(phone).orElseThrow(()-> new PlayerNotFound());
		
	}

}
