package com.example.authenticatingldap;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.unbescape.html.HtmlEscape;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

//@RestController
@Controller
@RequestMapping
public class HomeController {

	//@GetMapping("/")
	//public String index() {
	//public String root(Locale locale) {
		//return "Welcome to the home page!";
	//	return "redirect:/login.html";
	//}

	/** Home page. */
	@RequestMapping("/index.html")
	public String index() {
		return "index";
	}

	//@RequestMapping("/login.html")
	@GetMapping("/login.html")
	public String login() {
		return "login";
	}

	//@GetMapping("/")
	@RequestMapping("/")
	//public String home() {
	public String root(Locale locale) {
		//return "index";
		return "redirect:/login.html";
	}

	/** Error page. */
	@RequestMapping("/error.html")
	public String error(HttpServletRequest request, Model model) {
		model.addAttribute("errorCode", "Error " + request.getAttribute("javax.servlet.error.status_code"));
		Throwable throwable = (Throwable) request.getAttribute("javax.servlet.error.exception");
		StringBuilder errorMessage = new StringBuilder();
		errorMessage.append("<ul>");
		while (throwable != null) {
			errorMessage.append("<li>").append(HtmlEscape.escapeHtml5(throwable.getMessage())).append("</li>");
			throwable = throwable.getCause();
		}
		errorMessage.append("</ul>");
		model.addAttribute("errorMessage", errorMessage.toString());
		return "error";
	}
}
