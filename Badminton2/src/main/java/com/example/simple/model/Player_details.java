package com.example.simple.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="player-details")
public class Player_details {
	@Id
	protected String phonenumber;
	protected String name;
	protected double account_balance;
	
	public Player_details(String phonenumber, String name, double account_balance) {
		super();
		this.phonenumber = phonenumber;
		this.name = name;
		this.account_balance = account_balance;
	}

	public Player_details() {
		super();
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getAccount_balance() {
		return account_balance;
	}

	public void setAccount_balance(double account_balance) {
		this.account_balance = account_balance;
	}

	@Override
	public String toString() {
		return "Player_details [phonenumber=" + phonenumber + ", name=" + name + ", account_balance=" + account_balance
				+ "]";
	}
	
	
	

}
