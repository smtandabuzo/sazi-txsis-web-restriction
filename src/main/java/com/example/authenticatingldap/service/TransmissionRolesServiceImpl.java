package com.example.authenticatingldap.service;

import com.example.authenticatingldap.model.TransmissionRoles;
import com.example.authenticatingldap.repository.TransmissionRoleRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Collection;

public class TransmissionRolesServiceImpl implements TransmissionRolesService{

    private TransmissionRoleRepository transmissionRoleRepository;

    public TransmissionRolesServiceImpl(TransmissionRoleRepository transmissionRoleRepository) {
        this.transmissionRoleRepository = transmissionRoleRepository;
    }

    @Override
    public User findByAdUniqueNumber(String adUniqueNumber) {
        System.out.println("Inside by ad unique number");
        TransmissionRoles transmissionRoles = transmissionRoleRepository.findByAdUniqueNumber(adUniqueNumber);
        if(transmissionRoles == null){
            System.out.println("Transmission roles not found");
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(transmissionRoles.getAdEmailAddress(), transmissionRoles.getAdUniqueNumber(), mapRolesToAuthorities((Collection<TransmissionRoles>) transmissionRoles));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<TransmissionRoles> transmissionRoles){
        System.out.println("Inside map roles to authorities");
        System.out.println((Collection<? extends GrantedAuthority>) transmissionRoles.stream().map(role -> new SimpleGrantedAuthority(role.getAdRole())));
        return (Collection<? extends GrantedAuthority>) transmissionRoles.stream().map(role -> new SimpleGrantedAuthority(role.getAdRole()));
    }

}
