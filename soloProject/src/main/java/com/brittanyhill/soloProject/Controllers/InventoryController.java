package com.brittanyhill.soloProject.Controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import com.brittanyhill.soloProject.Models.Pattern;
import com.brittanyhill.soloProject.Models.User;
import com.brittanyhill.soloProject.Models.Yarn;
import com.brittanyhill.soloProject.Services.PatternService;
import com.brittanyhill.soloProject.Services.UserService;
import com.brittanyhill.soloProject.Services.YarnService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;



@Controller
public class InventoryController {


	
	@Autowired
	YarnService yarnService;
	
	@Autowired
	PatternService patternService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	HttpSession session;
	
	 @GetMapping("/yarn/all")
	    public String allYarn(HttpSession session, @ModelAttribute("yarn")Yarn yarn, Model model) {
	    	
	    	Long userId = (Long) session.getAttribute("userId");
	    	if(userId == null) {
	    		return "redirect:/";
	    	}
	    	
			User user = userService.getUserById(userId);
	    	model.addAttribute("user", user);
	    	
	    	model.addAttribute("yarn", yarnService.allYarn());

	    	
	    	return "allYarn.jsp";
	    }
	 
	 @GetMapping("/pattern/all")
	    public String allPatterns(HttpSession session, @ModelAttribute("pattern")Pattern pattern, Model model) {
	    	
	    	Long userId = (Long) session.getAttribute("userId");
	    	if(userId == null) {
	    		return "redirect:/";
	    	}
	    	
			User user = userService.getUserById(userId);
	    	model.addAttribute("user", user);
	    	
	    	model.addAttribute("patterns", patternService.allPatterns());

	    	
	    	return "allPatterns.jsp";
	    }
	 
	 @GetMapping("/yarn/create")
		public String newYarn(@ModelAttribute("yarn") Yarn yarn) {
			return "createYarn.jsp";
		}
	 
	 @PostMapping("/yarn/submit")
		public String createYarn(@Valid @ModelAttribute("yarn") Yarn yarn, BindingResult result) {
			Long userId = (Long) session.getAttribute("userId");
			if (userId == null) {
				return "redirect:/";
			}
			if (result.hasErrors()) {
				return "createYarn.jsp";
			} else {
				User user = userService.getUserById(userId);
				yarn.setUser(user);
				yarnService.createYarn(yarn);
				return "redirect:/yarn/all";
			}
		}
	 @GetMapping("/pattern/create")
		public String newPattern(@ModelAttribute("pattern") Pattern pattern) {
			return "createPattern.jsp";
		}
	 
	 @PostMapping("/pattern/submit")
		public String createPattern(@Valid @ModelAttribute("pattern") Pattern pattern, BindingResult result) {
			Long userId = (Long) session.getAttribute("userId");
			if (userId == null) {
				return "redirect:/";
			}
			if (result.hasErrors()) {
				return "createPattern.jsp";
			} else {
				User user = userService.getUserById(userId);
				pattern.setUser(user);
				patternService.createPattern(pattern);
				return "redirect:/pattern/all";
			}
		}
	 @GetMapping("/yarn/{yarnId}")
		public String yarnDetails(Model model, @PathVariable("yarnId") Long yarnId) {
			Long userId = (Long) session.getAttribute("userId");
			User user = userService.getUserById(userId);
			if (userId == null) {
				return "redirect:/";
			}
			
			model.addAttribute("user", user);

			model.addAttribute("yarn", yarnService.findYarn(yarnId));
			return "yarnDetails.jsp";
		}
	 
	 @GetMapping("/pattern/{patternId}")
		public String patternDetails( @PathVariable("patternId") Long patternId, Model model) {
			Long userId = (Long) session.getAttribute("userId");
			User user = userService.getUserById(userId);
			if (userId == null) {
				return "redirect:/";
			}
			
			model.addAttribute("user", user);
			model.addAttribute("pattern", patternService.findPattern(patternId));
			return "patternDetails.jsp";
		}

	 @GetMapping("/pattern/{patternId}/edit")
	    public String editPattern(@PathVariable("patternId") Long patternId, Model model) {
			Long userId = (Long) session.getAttribute("userId");
			
			if (userId == null) {
				return "redirect:/";
			}

			Pattern pattern = patternService.findPattern(patternId);
	        model.addAttribute("pattern", pattern);
	        return "updatePattern.jsp";
	    }
	 @PutMapping("/pattern/{patternId}/update")
	    public String updatePattern(@Valid @ModelAttribute("patternId") Pattern pattern, BindingResult result, Model model, @PathVariable("patternId") Long id) {
			Long userId = (Long) session.getAttribute("userId");
			if(userId == null) {
				return "redirect:/";
			}
			if (result.hasErrors()) {
	            model.addAttribute("pattern", patternService.findPattern(id));
	            return "updatePattern.jsp";
	        } else {
	        	User user = userService.getUserById(userId);
	        	pattern.setUser(user);
	        	patternService.updatePattern(pattern);
	            return "redirect:/pattern/all";
	        }
		}
	 @DeleteMapping("/pattern/{patternId}/delete")
		public String deletePattern(@PathVariable("patternId") Long id) {
			patternService.deletePattern(id);
			return "redirect:/pattern/all";
		}
	 @GetMapping("/yarn/{yarnId}/edit")
	    public String editYarn(@PathVariable("yarnId") Long yarnId, Model model) {
			Long userId = (Long) session.getAttribute("userId");
			
			if (userId == null) {
				return "redirect:/";
			}

			Yarn yarn = yarnService.findYarn(yarnId);
	        model.addAttribute("yarn", yarn);
	        return "updateYarn.jsp";
	    }
	 @PutMapping("/yarn/{yarnId}/update")
	    public String updateYarn(@Valid @ModelAttribute("yarnId") Yarn yarn, BindingResult result, Model model, @PathVariable("yarnId") Long id) {
			Long userId = (Long) session.getAttribute("userId");
			if(userId == null) {
				return "redirect:/";
			}
			if (result.hasErrors()) {
	            model.addAttribute("yarn", yarnService.findYarn(id));
	            return "updateYarn.jsp";
	        } else {
	        	User user = userService.getUserById(userId);
	        	yarn.setUser(user);
	        	yarnService.updateYarn(yarn);
	            return "redirect:/yarn/all";
	        }
		}
	 @DeleteMapping("/yarn/{yarnId}/delete")
		public String deleteYarn(@PathVariable("yarnId") Long id) {
		 yarnService.deleteYarn(id);
			return "redirect:/yarn/all";
		}
}
