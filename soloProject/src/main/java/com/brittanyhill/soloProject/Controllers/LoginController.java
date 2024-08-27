package com.brittanyhill.soloProject.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import com.brittanyhill.soloProject.Models.LoginUser;
import com.brittanyhill.soloProject.Models.Pattern;
import com.brittanyhill.soloProject.Models.User;
import com.brittanyhill.soloProject.Models.Yarn;
import com.brittanyhill.soloProject.Services.PatternService;
import com.brittanyhill.soloProject.Services.UserService;
import com.brittanyhill.soloProject.Services.YarnService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;


@Controller
public class LoginController {
    
    @Autowired
    UserService userService;
    
    
    @Autowired
	YarnService yarnService;
	
	@Autowired
	PatternService patternService;


    
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("newUser", new User());
        model.addAttribute("newLogin", new LoginUser());
        return "index.jsp";
    }
    
    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("newUser") User newUser, BindingResult result, Model model, HttpSession session) {
        
    	userService.register(newUser, result);
        
    	if(result.hasErrors()) {

            model.addAttribute("newLogin", new LoginUser());
            return "index.jsp";
        }
        
    	session.setAttribute("userId", newUser.getId());
        return "redirect:/";
    }
    
    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, BindingResult result, Model model, HttpSession session) {
        
    	User user =userService.login(newLogin, result);
        if(result.hasErrors()) {
        	
        	model.addAttribute("newUser", new User());
            
            return "index.jsp";
        }
    
        session.setAttribute("userId", user.getId());
        return "redirect:/home";
    }
    
    @GetMapping("/home")
    public String home(HttpSession session, @ModelAttribute("yarn") Yarn yarn, @ModelAttribute("pattern") Pattern pattern,  Model model) {
    	
    	Long userId = (Long) session.getAttribute("userId");
    	if(userId == null) {
    		return "redirect:/";
    	}
    	
		User user = userService.getUserById(userId);
    	model.addAttribute("user", user);
    	
    	model.addAttribute("yarn", yarnService.allYarn());
    	model.addAttribute("pattern", patternService.allPatterns());
    	

    	
    	return "Home.jsp";
    }
    	
    @GetMapping("/logout")
    public String logout(HttpSession session) {
    	session.invalidate();
    	return "redirect:/";
    }
}
