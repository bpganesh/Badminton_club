package com.example.simple.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.simple.model.Player_details;

public interface Player_details_repo extends JpaRepository<Player_details, String>{

}
