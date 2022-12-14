package com.example.authenticatingldap.service;

import com.example.authenticatingldap.dto.TransmissionRegistrationDto;
import com.example.authenticatingldap.model.TransmissionRoles;
import org.springframework.stereotype.Service;

@Service
public interface TransmissionRolesService {
    TransmissionRoles findByAdUniqueNumber(String adUniqueNumber);

    TransmissionRoles save(TransmissionRegistrationDto transmissionRegistrationDto);
}
