package com.example.authenticatingldap;//package com.example.authenticatingldap;

import com.example.authenticatingldap.dto.TransmissionBlockDto;
import com.example.authenticatingldap.dto.UserLoginDto;
import com.example.authenticatingldap.model.TransmissionRoles;
import com.example.authenticatingldap.repository.TransmissionRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/block")
public class BlockController {

    @Autowired
    private TransmissionRoleRepository transmissionRoleRepository;

    /*@Autowired
    private TransmissionRolesService transmissionRolesService;*/

   /* public BlockController(TransmissionRolesService transmissionRolesService) {
        super();
        this.transmissionRolesService = transmissionRolesService;
    }*/

    @ModelAttribute("transmission_roles")
    public TransmissionBlockDto transmissionBlockDto() {
        return new TransmissionBlockDto();
    }

    @GetMapping
    public String showBlockForm(Model model) {
        Connection connection = null;
        try {
            connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/txsis_registration",
                    "root", "");

            PreparedStatement st2 = (PreparedStatement) connection
                    .prepareStatement("Select * from txsis_registration.transmission_roles");

            ResultSet rs = st2.executeQuery();

            System.out.println("Transmission roles " + transmissionRoleRepository.findAll());

            List<TransmissionRoles> transmissionRolesList = new ArrayList<>();

            TransmissionRoles transmissionRoles = new TransmissionRoles();

            if (rs.next()) {
                transmissionRoles.setAdUniqueNumber(rs.getString("AD_UNIQUE_NUMBER"));
                transmissionRoles.setRole(rs.getString("ROLE"));
                transmissionRoles.setAdFirstName(rs.getString("AD_FIRSTNAME"));
                transmissionRoles.setAdAccount(rs.getString("AD_ACCOUNT"));
                transmissionRoles.setTxSisRole(rs.getString("TXSIS_ROLE"));
                transmissionRoles.setAdEmailAddress(rs.getString("AD_EMAIL_ADDRESS"));
                transmissionRoles.setAdSurname(rs.getString("AD_SURNAME"));
                transmissionRoles.setStatus(rs.getString("STATUS"));
                transmissionRoles.setBlocked(rs.getString("BLOCKED"));

                transmissionRolesList.add(transmissionRoles);

                model.addAttribute("transmissionRolesList",transmissionRolesList);

                String role = rs.getString("role");
                if (role.equals("ADMIN")) {
                    return "block";
                }
            } else {
                return "restrict";
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return "restrict";
    }

    @PutMapping
    public String updateTransmissionRoles(@ModelAttribute("transmission_roles") UserLoginDto userLoginDto, Model model){
        Connection connection = null;
        try {
            connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/txsis_registration",
                    "root", "");

            PreparedStatement st = (PreparedStatement) connection
                    .prepareStatement("Select role from txsis_registration.transmission_roles where ad_unique_number=?");

            st.setString(1, userLoginDto.getAdUniqueNumber());
            ResultSet rs = st.executeQuery();

            System.out.println("Transmission roles " + transmissionRoleRepository.findAll());

            model.addAttribute("transmission_roles", transmissionRoleRepository.findAll());

            if (rs.next()) {

                TransmissionRoles transmissionRoles = new TransmissionRoles();
                transmissionRoles.setAdUniqueNumber(rs.getString("adUniqueNumber"));
                transmissionRoles.setRole(rs.getString("role"));
                transmissionRoles.setAdFirstName(rs.getString("adFirstName"));
                transmissionRoles.setAdAccount(rs.getString("account"));
                transmissionRoles.setTxSisRole(rs.getString("txSisRole"));
                transmissionRoles.setAdEmailAddress(rs.getString("adEmailAddress"));
                transmissionRoles.setAdSurname(rs.getString("adSurname"));

                String role = rs.getString("role");
                if (role.equals("ADMIN")) {
                    return "block";
                }else if(role.equals("USER")){
                    return "restrict";
                }
            } else {
                return "restrict";
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return "welcome";
    }
}
