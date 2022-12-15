package com.example.authenticatingldap;

import com.example.authenticatingldap.dto.UserLoginDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.unbescape.html.HtmlEscape;

import javax.servlet.http.HttpServletRequest;
import java.sql.*;
import java.util.Optional;

@Controller
@RequestMapping("/login")
public class HomeController {

	@ModelAttribute("transmission_roles")
	public UserLoginDto userLoginDto() {
	    return new UserLoginDto();
	}

	private int id;

	public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = Optional.ofNullable(this.id).orElse(id);
	}

	@GetMapping
	public String login () {
		return "login";
	}
	@PostMapping
	public String login (@ModelAttribute("transmission_roles") UserLoginDto userLoginDto) {

		Connection connection = null;
		try {
			connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/txsis_registration",
					"root", "");

			PreparedStatement st = (PreparedStatement) connection
					.prepareStatement("Select role from txsis_registration.transmission_roles where ad_unique_number=?");

			st.setString(1, userLoginDto.getAdUniqueNumber());
			ResultSet rs = st.executeQuery();

			if (rs.next()) {
				String role = rs.getString("role");
				if (role.equals("ADMIN")) {
					return "index";
				}else if(role.equals("USER")){
				    return "index";
				}
			} else {
				return "restrict";
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return "welcome";
	}

	@GetMapping("/")
	public String home() {
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
