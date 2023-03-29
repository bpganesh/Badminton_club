package com.example.simple.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.simple.model.Payment_details;

public interface Payment_details_repo extends JpaRepository<Payment_details,String> {

	

}
