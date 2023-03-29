package com.example.simple.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PlayerExceptionController {
	@ExceptionHandler(value=PlayerNotFound.class)
	public ResponseEntity<?> exception(PlayerNotFound exception){
		return new ResponseEntity<>("player Phonenumber not found", HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(value=SomeOneUse.class)
	public ResponseEntity<?> exception(SomeOneUse exception){
		return new ResponseEntity<>("Court Some once booked", HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(value=IdNotFound.class)
	public ResponseEntity<?> exception(IdNotFound exception){
		return new ResponseEntity<>("Id Not Found", HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(value=LoserPlayerNotFound.class)
	public ResponseEntity<?> exception(LoserPlayerNotFound exception){
		return new ResponseEntity<>("Loser phonenumber is not found",HttpStatus.NOT_FOUND);
	}

}
