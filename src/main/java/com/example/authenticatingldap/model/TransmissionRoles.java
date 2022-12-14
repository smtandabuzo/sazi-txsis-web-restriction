package com.example.authenticatingldap.model;

import javax.persistence.*;

//@Entity
//@Table(name = "transmission_roles", uniqueConstraints = @UniqueConstraint(columnNames = "ad_unique_number"))
public class TransmissionRoles {

  //  @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@Column(name = "ad_account")
    private String adAccount;

    //@Column(name = "ad_unique_number")
    private String adUniqueNumber;

    //@Column(name = "ad_first_name")
    private String adFirstName;

    //@Column(name = "ad_last_name")
    private String adLastName;
    //@Column(name = "ad_email_address")
    private String adEmailAddress;

    //@Column(name = "txsis_role")
    private String txSisRole;

    public TransmissionRoles() {

    }

    public TransmissionRoles(Long id, String adAccount, String adUniqueNumber, String adFirstName, String adLastName, String adEmailAddress, String txSisRole) {
        this.id = id;
        this.adAccount = adAccount;
        this.adUniqueNumber = adUniqueNumber;
        this.adFirstName = adFirstName;
        this.adLastName = adLastName;
        this.adEmailAddress = adEmailAddress;
        this.txSisRole = txSisRole;
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

    public String getAdLastName() {
        return adLastName;
    }

    public void setAdLastName(String adLastName) {
        this.adLastName = adLastName;
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
}
