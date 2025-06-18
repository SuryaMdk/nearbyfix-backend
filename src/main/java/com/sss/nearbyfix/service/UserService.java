package com.sss.nearbyfix.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sss.nearbyfix.model.User;
import com.sss.nearbyfix.repository.UserRepository;

@Service
public class UserService {
	@Autowired
    private UserRepository userRepository;

    public User registerUser(User user) {
        return userRepository.save(user);
    }

    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

	public User login(String email, String password) {
		return userRepository.findByEmailAndPassword(email, password);
	}
}
