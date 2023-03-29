package com.example.simple.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.simple.model.Matchdetails;
import com.example.simple.model.Payment_details;
import com.example.simple.model.Player_details;
import com.example.simple.repository.Player_details_repo;

import jakarta.servlet.http.HttpServletRequest;
@Controller
public class Applicationcontroller1 {
	@Autowired
	Player_service playerservice;
	Player_details_repo playerrepo;
	@Autowired
	Payment_service paymentservice;
	@Autowired
	MatchService matchservice;
	
	
	@RequestMapping("/welcome")
	public String welcome(HttpServletRequest request) {
		
		return "welcomepage";
	}
	@PostMapping("/print/player")
	public String registerplayer(@ModelAttribute Player_details user,BindingResult bindingResult,HttpServletRequest request) {
		playerservice.createdata(user);
		
		return "welcomepage";
	}
	@GetMapping("/print/player/phonenumber")
	public ResponseEntity<?> phonenumbersearch(@ModelAttribute Player_details user,BindingResult bindingResult,HttpServletRequest request){
		Player_details p= playerservice.findbyPhonenumber(user.getPhonenumber());
		return new ResponseEntity<>(p,HttpStatus.CREATED);
		
	}
	
	
	@PostMapping("/print/payment")
	public String registerPaymeny(@ModelAttribute Payment_details user,BindingResult bindingResult,HttpServletRequest request) {
		paymentservice.createpayment(user);
		return "welcomepage";
	}
	@PostMapping("/print/match")
	public String registermatch(@ModelAttribute Matchdetails user,BindingResult bindingResult,HttpServletRequest request) {
		matchservice.createdata(user);
		return "welcomepage";
	}
	@PostMapping("/print/match1")
	public String update(@ModelAttribute Matchdetails user,BindingResult bindingResult,HttpServletRequest request) {
		matchservice.updatedata(user);
		return "welcomepage";
	}
	
	@GetMapping("/print/range")
	public ResponseEntity<?> range(@ModelAttribute Matchdetails user,BindingResult bindingResult,HttpServletRequest request) {
		List <Matchdetails> matchlist = matchservice.getmatchdetailswithinrange(user);
		return new ResponseEntity<>(matchlist,HttpStatus.CREATED);
	}
	@GetMapping("print/range/phonenumber")
	public ResponseEntity<?> rangephonenumber(@ModelAttribute Matchdetails user,BindingResult bindingResult,HttpServletRequest request){
		Set<Matchdetails>matchlist1=matchservice.getmatchdetailswithinrange1(user);
		return new ResponseEntity<>(matchlist1,HttpStatus.CREATED);
	}

}
