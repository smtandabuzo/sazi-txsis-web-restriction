package com.example.authenticatingldap;

import com.example.authenticatingldap.dto.UserLoginDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.unbescape.html.HtmlEscape;

import javax.servlet.http.HttpServletRequest;
import java.sql.*;

@Controller
@RequestMapping("/login")
public class HomeController {

	@ModelAttribute("transmission_roles")
	public UserLoginDto userLoginDto() {
	    return new UserLoginDto();
	}

	@GetMapping
	public String login () {
		//return setLogin();
		return "login";
	}
	@PostMapping
	public String login (@ModelAttribute("transmission_roles") UserLoginDto userLoginDto) {
		//model.addAttribute("username",adUniqueNumber);
		System.out.println("Inside login");
		Connection connection = null;
		try {
			connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/txsis_registration",
					"root", "");

			PreparedStatement st = (PreparedStatement) connection
					.prepareStatement("Select txsis_role from txsis_registration.transmission_roles where ad_unique_number=?");

			st.setString(1, userLoginDto.getAdUniqueNumber());
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				return "index";
				//return "redirect:/index.html";
			} else {
				return "login";
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/*@GetMapping("/login/{token}")
	public String signin (@RequestParam("uid") String aUid, @PathVariable("token") String aToken) {
		try {
			authenticator.authenticate(aUid, aToken);
			return "redirect:/";
		}
		catch (BadCredentialsException aBadCredentialsException) {
			return "invalid_login_link";
		}
	}*/

	//@GetMapping("/")
	//public String index() {
	//public String root(Locale locale) {
		//return "Welcome to the home page!";
	//	return "redirect:/login.html";
	//}

	/** Home page. */
//	@RequestMapping("/index.html")
//	public String index() {
	//	return "index";
	//}

	//@RequestMapping("/login.html")
	//@GetMapping("/login.html")
	//public String login() {
	//	return "login";
	//}

	@GetMapping("/")
	//@RequestMapping("/")
	public String home() {
	//public String root(Locale locale) {
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
