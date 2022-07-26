package com.MySqlConnection.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import com.MySqlConnection.Entity.User;
import com.MySqlConnection.repositoory.UserRepository;

@RestController
@RequestMapping(path="/demo")
public class UserController {
	@Autowired
	private UserRepository userRepository;
	
	@PostMapping("/add")
	public User addNewUser(@RequestBody User user) {
		
		return userRepository.save(user);
		
	}
	@GetMapping("/getAll")
	public List<User> getAllUsers() {
		return userRepository.findAll();
		
	}
	

}
