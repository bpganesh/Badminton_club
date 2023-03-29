package com.example.simple.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.example.simple.model.Matchdetails;
import com.example.simple.model.Matchstatus;

public interface Mathchdetailsrepo extends JpaRepository<Matchdetails,Integer> {

	List<Matchdetails> findByCourtNoAndMatchstatus(int courtNo,Matchstatus matchstatus);
	List<Matchdetails> findByStartdatetimeBetween(LocalDateTime startdatetime,LocalDateTime enddatetime);
	List<Matchdetails> findByPlayer1phonenoAndStartdatetimeBetween(String player1phoneno,LocalDateTime startdatetime,LocalDateTime enddatetime);
	List<Matchdetails> findByPlayer2phonenoAndStartdatetimeBetween(String player2phoneno, LocalDateTime start_date_time,
			LocalDateTime end_date_time);
	
}
