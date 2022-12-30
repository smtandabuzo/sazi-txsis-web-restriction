package com.example.authenticatingldap;

import com.example.authenticatingldap.dto.UserLoginDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.*;

@Controller
@RequestMapping("/user")
public class UserController {
    @GetMapping
    public String user () {
        return "user";
    }
    @ModelAttribute("transmission_roles")
    public UserLoginDto userLoginDto() {
        return new UserLoginDto();
    }
    @PostMapping
    public String user (@ModelAttribute("transmission_roles") UserLoginDto userLoginDto) {
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
            } else {
                return "restrict";
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @PutMapping
    public String update (@ModelAttribute("transmission_roles") UserLoginDto userLoginDto) {
        //model.addAttribute("username",adUniqueNumber);
        System.out.println("Inside update");

        Connection connection = null;
        try {
            connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/txsis_registration",
                    "root", "");

            PreparedStatement st = (PreparedStatement) connection
                    .prepareStatement("update txsis_registration.transmission_roles set blocked = ? where ad_unique_number= ?");

            st.setString(1, userLoginDto.getBlocked());
            st.setString(2, userLoginDto.getAdUniqueNumber());
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return "index";
            } else {
                return "restrict";
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
