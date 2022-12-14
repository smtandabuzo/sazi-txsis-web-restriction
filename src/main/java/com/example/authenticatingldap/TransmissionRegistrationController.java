package com.example.authenticatingldap;//package com.example.authenticatingldap;

import com.example.authenticatingldap.dto.TransmissionRegistrationDto;
import com.example.authenticatingldap.service.TransmissionRolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.*;

@Controller
@RequestMapping("/registration")
public class TransmissionRegistrationController {

	@Autowired
	private TransmissionRolesService transmissionRolesService;

	public TransmissionRegistrationController(TransmissionRolesService transmissionRolesService) {
		super();
		this.transmissionRolesService = transmissionRolesService;
	}
	
	@ModelAttribute("transmission_roles")
    public TransmissionRegistrationDto transmissionRegistrationDto() {
        return new TransmissionRegistrationDto();
    }
	
	@GetMapping
	public String showRegistrationForm() {
		return "registration";
	}
	
	@PostMapping
	public String registerUserAccount(@ModelAttribute("transmission_roles") TransmissionRegistrationDto transmissionRegistrationDto) {
		Connection connection = null;
		try {
			connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/txsis_registration",
					"root", "");

			PreparedStatement st = (PreparedStatement) connection
					.prepareStatement("insert into txsis_registration.transmission_roles(id,ad_account,ad_unique_number,ad_firstname,ad_surname,ad_email_address,txsis_role,status) values(100,?,?,?,?,?,?,?)");

			st.setString(1, transmissionRegistrationDto.getAdAccount());
			st.setString(2,transmissionRegistrationDto.getAdUniqueNumber());
			st.setString(3,transmissionRegistrationDto.getAdFirstName());
			st.setString(4,transmissionRegistrationDto.getAdSurname());
			st.setString(5,transmissionRegistrationDto.getAdEmailAddress());
			st.setString(6,transmissionRegistrationDto.getTxsisRole());
			st.setString(7,transmissionRegistrationDto.getStatus());
			st.executeUpdate();
			connection.close();
			/*if (rs.next()) {
				return "index";
				//return "redirect:/index.html";
			} else {
				return "login";
			}*/
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		//transmissionRolesService.save(transmissionRegistrationDto);
		return "redirect:/registration?success";
	}
}
