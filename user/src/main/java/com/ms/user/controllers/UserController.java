package com.ms.user.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ms.user.models.UserModel;

import jakarta.validation.Valid;

@RestController
public class UserController {

	@PostMapping("/users")
	public ResponseEntity<UserModel> saveUuser(@RequestBody @Valid UserRecordDto userRecordDto){
		
		
		
		return ResponseEntity.status(HttpStatus.CREATED).body(null);
	}
}
