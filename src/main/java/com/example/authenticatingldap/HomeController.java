package com.example.authenticatingldap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class HomeController {

	//@GetMapping("/")
	//public String index() {
	//public String root(Locale locale) {
		//return "Welcome to the home page!";
	//	return "redirect:/login.html";
	//}

	/** Login form. */
	//@RequestMapping("/login.html")
	//public String login() {
	//	return "login";
	//}

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/")
	public String home() {
		return "index";
	}
}
