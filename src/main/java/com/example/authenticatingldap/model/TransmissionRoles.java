package com.example.authenticatingldap.model;

import javax.persistence.*;

@Entity
@Table(name = "transmission_roles", uniqueConstraints = @UniqueConstraint(columnNames = "ad_unique_number"))

public class TransmissionRoles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ad_account")
    private String adAccount;

    @Column(name = "ad_unique_number")
    private String adUniqueNumber;

    @Column(name = "ad_firstname")
    private String adFirstName;

    @Column(name = "ad_surname")
    private String adSurname;
    @Column(name = "ad_email_address")
    private String adEmailAddress;

    @Column(name = "txsis_role")
    private String txSisRole;

    @Column(name = "status")
    private String status;

    @Column(name = "role")
    private String role;

    @Column(name = "blocked")
    private String blocked;

    public TransmissionRoles() {
    }

    public TransmissionRoles(Long id, String adAccount, String adUniqueNumber, String adFirstName, String adSurname,
                             String adEmailAddress, String txSisRole, String status, String role, String blocked) {
        this.id = id;
        this.adAccount = adAccount;
        this.adUniqueNumber = adUniqueNumber;
        this.adFirstName = adFirstName;
        this.adSurname = adSurname;
        this.adEmailAddress = adEmailAddress;
        this.txSisRole = txSisRole;
        this.status = status;
        this.role = role;
        this.blocked = blocked;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAdAccount() {
        return adAccount;
    }

    public void setAdAccount(String adAccount) {
        this.adAccount = adAccount;
    }

    public String getAdUniqueNumber() {
        return adUniqueNumber;
    }

    public void setAdUniqueNumber(String adUniqueNumber) {
        this.adUniqueNumber = adUniqueNumber;
    }

    public String getAdFirstName() {
        return adFirstName;
    }

    public void setAdFirstName(String adFirstName) {
        this.adFirstName = adFirstName;
    }

    public String getAdSurname() {
        return adSurname;
    }

    public void setAdSurname(String adSurname) {
        this.adSurname = adSurname;
    }

    public String getAdEmailAddress() {
        return adEmailAddress;
    }

    public void setAdEmailAddress(String adEmailAddress) {
        this.adEmailAddress = adEmailAddress;
    }

    public String getTxSisRole() {
        return txSisRole;
    }

    public void setTxSisRole(String txSisRole) {
        this.txSisRole = txSisRole;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getBlocked() {
        return blocked;
    }

    public void setBlocked(String blocked) {
        this.blocked = blocked;
    }
}
