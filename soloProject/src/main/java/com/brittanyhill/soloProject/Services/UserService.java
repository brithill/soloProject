package com.brittanyhill.soloProject.Services;


import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.brittanyhill.soloProject.Models.LoginUser;
import com.brittanyhill.soloProject.Models.User;
import com.brittanyhill.soloProject.Repositories.UserRepository;




@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;
    
    
    public User register(User newUser, BindingResult result) {
    	Optional<User> potentialUser = userRepo.findByEmail(newUser.getEmail());
    	
    	if (potentialUser.isPresent()) {
			result.rejectValue("email", "matches", "Account already exists please login.");
			
		} 
    	if (!newUser.getPassword().equals(newUser.getConfirm())) {
    		result.rejectValue("confirm", "matches", "Password must match.");
    		
		}
    	if (result.hasErrors()) {
			return null;
		}
    	
		String hashedPass = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
		newUser.setPassword(hashedPass);	
        return userRepo.save(newUser);
    }
    public User login(LoginUser newLoginObject, BindingResult result) {
    	
    	Optional<User> potentialUser = userRepo.findByEmail(newLoginObject.getEmail());
    	if (!potentialUser.isPresent()) {
			result.rejectValue("email", "matches", "User not found please register!");
			return null;
		}
    	User user = potentialUser.get();
    	
    	if (!BCrypt.checkpw(newLoginObject.getPassword(), user.getPassword())) {
			result.rejectValue("password", "matches", "Email or password do not match, please try again.");
			return null;
		}
    	
    	if (result.hasErrors()) {
			return null;
		}
        return user;
    }
    
    public User getUserById(Long id) {
    	Optional<User> user = userRepo.findById(id);
    	if (user.isPresent()) {
			return user.get();
		}
    	else {
			return null;
		}
    }
}
