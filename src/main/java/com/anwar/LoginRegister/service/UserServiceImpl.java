package com.anwar.LoginRegister.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anwar.LoginRegister.model.User;
import com.anwar.LoginRegister.model.Role;
import com.anwar.LoginRegister.repository.UserRepository;
import com.anwar.LoginRegister.web.dto.UserRegistrationDto;

@Service
public class UserServiceImpl implements UserService{

	private UserRepository userRepository;
	
	@Autowired
	//private BCryptPasswordEncoder passwordEncoder;
	
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public User save(UserRegistrationDto registrationDto) {
		User user = new User(registrationDto.getFirstName(), 
				registrationDto.getLastName(), registrationDto.getEmail(),
				registrationDto.getPassword(), Arrays.asList(new Role("ROLE_USER")));
		
		return userRepository.save(user);
	}

//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//	
//		User user = userRepository.findByEmail(username);
//		if(user == null) {
//			throw new UsernameNotFoundException("Invalid username or password.");
//		}
//		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), mapRolesToAuthorities(user.getRoles()));		
//	}
//	
//	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
//		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
//	}
	
}
