package com.ms.user.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.user.models.UserModel;
import com.ms.user.producers.UserProducer;
import com.ms.user.repositories.UserRepository;

import ch.qos.logback.classic.Logger;
import jakarta.transaction.Transactional;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;

	Logger logger = (Logger) org.slf4j.LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	UserProducer userProducer;

	@Transactional
	public UserModel save(UserModel userModel) {
		userModel = userRepository.save(userModel);
		userProducer.publishMessageEmail(userModel);
		logger.info("User saved successfully");
		return userModel;
	}

}
