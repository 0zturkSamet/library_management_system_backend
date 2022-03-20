package com.lms.library.service;

import java.util.Date;
import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.lms.library.domain.User;
import com.lms.library.repository.UserRepository;

import lombok.AllArgsConstructor;


@AllArgsConstructor
@Service
public class UserService {
	
	

	private  UserRepository userRepository;
	private  BCryptPasswordEncoder passwordEncoder;
	//----------------------------------GET ALL USERS-------------------------->>>>>>
	public List<User> getAllUsers() {
		return userRepository.findAllByOrderByDisplayNameAsc();

	}
	
	//----------------------------------GET ALL  ACTIVE USERS------------------>>>>>>
	public List<User> getAllActiveUsers(){
		return userRepository.findAllByActiveOrderByDisplayNameAsc(1);
	}
	
	//----------------------------------GET USER BY USERNAME------------------->>>>>>
	public User getByUsername(String username) {
		return userRepository.findByUsername(username);
	}
	//----------------------------------GET USER BY ID------------------------->>>>>>
	public User getById(Long id) {
		return userRepository.findById(id).get();
	}

	/*
	 * //----------------------------------ADD NEW
	 * USER--------------------------->>>>>> public User addNew(User user) {
	 * user.setPassword( passwordEncoder.encode(user.getPassword()) );
	 * user.setCreatedDate( new Date() ); user.setLastModifiedDate(
	 * user.getCreatedDate() ); user.setActive(1); return userRepository.save(user);
	 * } //----------------------------------UPDATE--------------------------->>>>>>
	 * public User update(User user) { user.setLastModifiedDate(new Date()); return
	 * userRepository.save(user);
	 * 
	 * }
	 */
	//----------------------------------DELETE BY USER-------------------->>>>>>
	public void delete (User user) {
		userRepository.delete(user);
	}
	//----------------------------------DELETE BY USER ID----------------->>>>>>
	public void deleteById(Long id) {
	 userRepository.deleteById(id);
	}
}
