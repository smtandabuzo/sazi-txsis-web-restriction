package com.example.authenticatingldap;

import com.example.authenticatingldap.dto.UserLoginDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.*;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @GetMapping
    public String admin () {
        return "admin";
    }

    @ModelAttribute("transmission_roles")
    public UserLoginDto userLoginDto() {
        return new UserLoginDto();
    }

    @PostMapping
    public String admin (@ModelAttribute("transmission_roles") UserLoginDto userLoginDto) {
        System.out.println("Inside login");
        Connection connection = null;
        try {
            connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/txsis_registration",
                    "root", "");

            PreparedStatement st = (PreparedStatement) connection
                    .prepareStatement("Select txsis_role from txsis_registration.transmission_roles where ad_unique_number=? and role = ?");

            st.setString(1, userLoginDto.getAdUniqueNumber());
            st.setString(2, "ADMIN");
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return "login";
               // return "redirect:/login.html";
            } else {
                return "restrict";
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
