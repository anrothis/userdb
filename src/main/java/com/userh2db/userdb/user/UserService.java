package com.userh2db.userdb.user;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UserService {
	
	private final UserRepository userRepository;
	
	@Autowired
	public UserService(UserRepository userRepository)
	{
		this.userRepository = userRepository;
	}
    public List<String> getUser()
	{
		return userRepository.listUsers();
	}

	public List<User> getUserRich() {
		return userRepository.findAll();
	}
	public void addNewUser(User user) {
	 	Optional<User> userByEmail = userRepository.findUserByEmail(user.getEmail());
		if (userByEmail.isPresent())
		{
			throw new IllegalStateException();
		}
		userRepository.save(user);
	}
	
	public void deleteUser(Long userId) {
		boolean exists = userRepository.existsById(userId);
				
		if(!exists){
			throw new IllegalStateException();
		}
		userRepository.deleteById(userId);
	}

	public List<User> getUserByForename(String forename) {
		return userRepository.findByForename(forename);
	}
	public List<User> getUserBySurename(String surename) {
		return userRepository.findBySurename(surename);
	}

	@Transactional
	public void updateUser(Long userId, String forename, String surename, String email) {
		User user = userRepository.findById(userId).orElseThrow(()-> new IllegalStateException("No user with ID: " + userId + " found!"));
		
		if (forename != null && forename.length() > 0 && !Objects.equals(user.getForename(), forename))
		{
			user.setForename(forename);
		}
		if (surename != null && surename.length() > 0 && !Objects.equals(user.getSurename(), surename))
		{
			user.setSurename(surename);
		}
		if (email != null && email.length() > 0 && !Objects.equals(user.getEmail(), email))
		{
			if(!userRepository.findUserByEmail(email).isPresent())
			{
				user.setEmail(email);
			}
			else
			{
				throw new IllegalStateException("Email already taken!");
			}
		}
	}
	
}
