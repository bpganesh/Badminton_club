package com.example.simple.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Payment_details {
	@Id

	protected String player_phone_number;
	protected LocalDate date_of_payment;
	protected double amount_paid;

	public Payment_details(String player_phone_number, LocalDate date_of_payment, double amount_paid) {
		super();
		this.player_phone_number = player_phone_number;
		this.date_of_payment = date_of_payment;
		this.amount_paid = amount_paid;
	}

	public Payment_details() {
		super();
	}

	public String getPlayer_phone_number() {
		return player_phone_number;
	}

	public void setPlayer_phone_number(String player_phone_number) {
		this.player_phone_number = player_phone_number;
	}

	public LocalDate getDate_of_payment() {
		return date_of_payment;
	}

	public void setDate_of_payment(LocalDate date_of_payment) {
		this.date_of_payment = date_of_payment;
	}

	public double getAmount_paid() {
		return amount_paid;
	}

	public void setAmount_paid(double amount_paid) {
		this.amount_paid = amount_paid;
	}

	@Override
	public String toString() {
		return "Payment_details [player_phone_number=" + player_phone_number + ", date_of_payment=" + date_of_payment
				+ ", amount_paid=" + amount_paid + "]";
	}

}
