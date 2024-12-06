package com.anwar.LoginRegister.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anwar.LoginRegister.model.User;
import com.anwar.LoginRegister.model.Role;
import com.anwar.LoginRegister.repository.UserRepository;
import com.anwar.LoginRegister.web.dto.UserRegistrationDto;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    
    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
    	super();
        this.userRepository = userRepository;
    }

    @Override
    public User save(UserRegistrationDto registrationDto) {
        // Create a new User object with the data from the DTO
        User user = new User(
            registrationDto.getFirstName(), 
            registrationDto.getLastName(), 
            registrationDto.getEmail(),
            registrationDto.getPassword(), 
            Arrays.asList(new Role("ROLE_USER"))
        );

        // Save the User to the database and return the saved User object
        return userRepository.save(user);
    }
}

