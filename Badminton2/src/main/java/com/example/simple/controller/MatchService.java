package com.example.simple.controller;
import java.time.Duration;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
//import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.YamlProcessor.MatchStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.simple.model.Matchstatus;
import com.example.simple.Exception.IdNotFound;
import com.example.simple.Exception.LoserPlayerNotFound;
import com.example.simple.Exception.PlayerNotFound;
import com.example.simple.Exception.SomeOneUse;
import com.example.simple.model.Matchdetails;
import com.example.simple.model.Player_details;
import com.example.simple.repository.Mathchdetailsrepo;
import com.example.simple.repository.Player_details_repo;


//import ch.qos.logback.core.util.Duration;

@RestController
public class MatchService {
	@Autowired
	Mathchdetailsrepo matchrepo;
	@Autowired
	Player_details_repo playerrepo;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MatchService.class);
	
	
	@PostMapping("/insert/match")
	public ResponseEntity<?> createdata(@RequestBody Matchdetails match){
		match.setMatch_status(Matchstatus.STARTED);
		
		
		LOGGER.trace("Entering createdata() method");
		LOGGER.debug("Authenticating Match");
		
		
			if(matchrepo.findByCourtNoAndMatchstatus(match.getCourtNo(),match.getMatch_status()).isEmpty()) {
				try {
			Matchdetails _match=matchrepo.save(new Matchdetails(match.getCourtNo(),match.getMatch_status(),
					find(match.getPlayer_1_phone_no()),find(match.getPlayer_2_phone_no()),match.getStart_date_time(),
					match.getEnd_date_time(),match.getLoser_phone_no(),match.getAmount()));
			
			LOGGER.info("Match started");
			
			return new ResponseEntity<>("Match Started", HttpStatus.CREATED);
			}catch(Exception e) {
				LOGGER.warn("Entering the catch block");
				throw new PlayerNotFound();
			}
			}
			else {
				//System.out.println("Match Running");
				LOGGER.error("Match Not Started");
				throw new SomeOneUse();
		}
	}
	public String find(String player_1_phone_no) {
		
		LOGGER.info("Check the phonenumber");
		
		Player_details p= playerrepo.findById(player_1_phone_no).orElse(null);
		
		LOGGER.info("Checking Complete");
		
		return p.getPhonenumber();
	}
	@PutMapping("/update/match")
	public ResponseEntity<Matchdetails> updatedata(@RequestBody Matchdetails match){
		
		LOGGER.trace("Entering updatedata() method");
		LOGGER.debug("Authenticating Match");
		
		try {
			Matchdetails match1=matchrepo.findById(match.getId()).orElse(null);
			
			match1.setEnd_date_time(match.getEnd_date_time());
			
			match1.setLoser_phone_no(match.getLoser_phone_no());
			match1.setMatch_status(Matchstatus.ENDED);
			match1.setAmount(duration(match1.getStart_date_time(),match.getEnd_date_time()));
		
			Matchdetails _match=matchrepo.save(match1);
		
			LOGGER.info("Match Ended");
			
			Player_details id=playerrepo.findById(match.getLoser_phone_no()).orElseThrow(()-> new LoserPlayerNotFound());
			
			double d=duration(match1.getStart_date_time(),match.getEnd_date_time());
			id.setAccount_balance(d);
			playerrepo.save(new Player_details(id.getPhonenumber(),id.getName(),id.getAccount_balance()));
			
			LOGGER.info("amount updated in player_details");
			
			return new ResponseEntity<>(_match,HttpStatus.CREATED);
		}catch(Exception e) {
			LOGGER.warn("Court number is not found");
			throw new IdNotFound();
		}
		
	}
	
	private double duration(LocalDateTime start_date_time, LocalDateTime end_date_time) {
		// TODO Auto-generated method stub
		LOGGER.trace("Entering the duration");
		double d=Duration.between(start_date_time,end_date_time).toMinutes();
		return d*2;
	}
	@GetMapping("/print/match")
	public List<Matchdetails> findAll(){
		LOGGER.info("It print matchdetails");
		return matchrepo.findAll();
	}
	
	@GetMapping("/print/match/range")
	public List<Matchdetails> getmatchdetailswithinrange(@RequestBody Matchdetails match){
		LOGGER.info("Its print matchdetails with range");
		
		return matchrepo.findByStartdatetimeBetween(match.getStart_date_time(),match.getEnd_date_time());
	}
	
	@GetMapping("/print/match/range/phonenumber")
	public Set<Matchdetails> getmatchdetailswithinrange1(@RequestBody Matchdetails match){
		LOGGER.trace("Entering the getmatchdetailswithrange");
		Set<Matchdetails>player=new HashSet<>();
		List<Matchdetails>player1= matchrepo.findByPlayer1phonenoAndStartdatetimeBetween(match.getPlayer_1_phone_no(),match.getStart_date_time(),match.getEnd_date_time());
		List<Matchdetails>player2=matchrepo.findByPlayer2phonenoAndStartdatetimeBetween(match.getPlayer_2_phone_no(),match.getStart_date_time(),match.getEnd_date_time());
		player.addAll(player1);
		player.addAll(player2);
		return player;
	}
	

}
