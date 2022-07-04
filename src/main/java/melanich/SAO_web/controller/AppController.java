package melanich.SAO_web.controller;

import melanich.SAO_web.model.User;
import melanich.SAO_web.repository.UserRepository;
import melanich.SAO_web.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class AppController {

	@Autowired
	private CustomUserDetailsService userDetailsService;
	
	@GetMapping("/register")
	public String showRegistrationForm(Model model) {
		model.addAttribute("user", new User());
		
		return "signup_form";
	}

	@PostMapping("/process_register")
	public String processRegister(User user) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		userDetailsService.save(user);
		
		return "redirect:/users";
	}
	
	@GetMapping("/users")
	@ResponseBody
	public String listUsers(Model model) {
		
		return "users";
	}
}
