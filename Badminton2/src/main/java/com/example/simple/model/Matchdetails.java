package com.example.simple.model;

import java.time.LocalDateTime;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="match_details")

public class Matchdetails {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	protected int id;
	protected int courtNo;
	@Enumerated(EnumType.STRING)
	protected Matchstatus matchstatus;
	protected String player1phoneno;
	protected String player2phoneno;
	protected LocalDateTime startdatetime;
	protected LocalDateTime enddatetime;
	protected String loser_phone_no;
	protected double amount;
	public Matchdetails(int id, int courtNo, Matchstatus match_status, String player_1_phone_no,
			String player_2_phone_no, LocalDateTime startdatetime, LocalDateTime enddatetime, String loser_phone_no,
			double amount) {
		super();
		this.id = id;
		this.courtNo = courtNo;
		this.matchstatus = match_status;
		this.player1phoneno = player_1_phone_no;
		this.player2phoneno = player_2_phone_no;
		this.startdatetime = startdatetime;
		this.enddatetime = enddatetime;
		this.loser_phone_no = loser_phone_no;
		this.amount = amount;
	}
	public Matchdetails(int courtNo, Matchstatus match_status, String player_1_phone_no, String player_2_phone_no,
			LocalDateTime start_date_time, LocalDateTime end_date_time, String loser_phone_no, double amount) {
		super();
		this.courtNo = courtNo;
		this.matchstatus = match_status;
		this.player1phoneno = player_1_phone_no;
		this.player2phoneno = player_2_phone_no;
		this.startdatetime = start_date_time;
		this.enddatetime = end_date_time;
		this.loser_phone_no = loser_phone_no;
		this.amount = amount;
	}
	
	public Matchdetails() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCourtNo() {
		return courtNo;
	}
	public void setCourtNo(int courtNo) {
		this.courtNo = courtNo;
	}
	public Matchstatus getMatch_status() {
		return matchstatus;
	}
	public void setMatch_status(Matchstatus match_status) {
		this.matchstatus = match_status;
	}
	public String getPlayer_1_phone_no() {
		return player1phoneno;
	}
	public void setPlayer_1_phone_no(String player_1_phone_no) {
		this.player1phoneno = player_1_phone_no;
	}
	public String getPlayer_2_phone_no() {
		return player2phoneno;
	}
	public void setPlayer_2_phone_no(String player_2_phone_no) {
		this.player2phoneno = player_2_phone_no;
	}
	public LocalDateTime getStart_date_time() {
		return startdatetime;
	}
	public void setStart_date_time(LocalDateTime start_date_time) {
		this.startdatetime = start_date_time;
	}
	public LocalDateTime getEnd_date_time() {
		return enddatetime;
	}
	public void setEnd_date_time(LocalDateTime end_date_time) {
		this.enddatetime = end_date_time;
	}
	public String getLoser_phone_no() {
		return loser_phone_no;
	}
	public void setLoser_phone_no(String loser_phone_no) {
		this.loser_phone_no = loser_phone_no;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "Match_details [id=" + id + ", courtNo=" + courtNo + ", match_status=" + matchstatus
				+ ", player_1_phone_no=" + player1phoneno + ", player_2_phone_no=" + player2phoneno
				+ ", start_date_time=" + startdatetime + ", end_date_time=" + enddatetime + ", loser_phone_no="
				+ loser_phone_no + ", amount=" + amount + "]";
	}
	
	
	

}

