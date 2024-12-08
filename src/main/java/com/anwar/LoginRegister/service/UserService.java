package com.anwar.LoginRegister.service;

import com.anwar.LoginRegister.model.User;
import com.anwar.LoginRegister.web.dto.UserRegistrationDto;

public interface UserService {
	
	 User save(UserRegistrationDto registrationDto);
	
}
