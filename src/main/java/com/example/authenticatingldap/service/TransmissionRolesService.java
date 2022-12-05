package com.example.authenticatingldap.service;

import org.springframework.security.core.userdetails.User;

public interface TransmissionRolesService {
    User findByAdUniqueNumber(String adUniqueNumber);
}
