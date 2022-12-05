package com.example.authenticatingldap.model;

import javax.persistence.*;

@Entity
@Table(name = "TRANSMISSION_ROLES", uniqueConstraints = @UniqueConstraint(columnNames = "AD_UNIQUE_NUMBER"))
public class TransmissionRoles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "AD_ACCOUNT")
    private String adAccount;

    @Column(name = "AD_UNIQUE_NUMBER")
    private String adUniqueNumber;

    @Column(name = "AD_NAME")
    private String adName;

    @Column(name = "AD_EMAIL_ADDRESS")
    private String adEmailAddress;

    @Column(name = "AD_ROLE")
    private String adRole;

    @Column(name = "BLOCKING_INDICATOR_SAP")
    private String blockingIndicatorSAP;

    @Column(name = "ACCOUNT")
    private String account;

    @Column(name = "AC_UNIQUE_NUMBER")
    private String acUniqueNumber;

    @Column(name = "AC_NAME")
    private String acName;

    @Column(name = "AC_EMAIL_ADDRESS")
    private String acEmailAddress;

    @Column(name = "AC_ROLE")
    private String acRole;

    @Column(name = "VALID")
    private String valid;

    @Column(name = "BLOCKING_INDICATOR_IDV")
    private String blockingIndicatorIDV;

    public TransmissionRoles() {

    }

    public TransmissionRoles(Long id, String adAccount, String adUniqueNumber, String adName, String adEmailAddress, String adRole, String blockingIndicatorSAP, String account,
                             String acUniqueNumber, String acName, String acEmailAddress, String acRole, String valid, String blockingIndicatorIDV) {
        this.id = id;
        this.adAccount = adAccount;
        this.adUniqueNumber = adUniqueNumber;
        this.adName = adName;
        this.adEmailAddress = adEmailAddress;
        this.adRole = adRole;
        this.blockingIndicatorSAP = blockingIndicatorSAP;
        this.account = account;
        this.acUniqueNumber = acUniqueNumber;
        this.acName = acName;
        this.acEmailAddress = acEmailAddress;
        this.acRole = acRole;
        this.valid = valid;
        this.blockingIndicatorIDV = blockingIndicatorIDV;
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

    public String getAdName() {
        return adName;
    }

    public void setAdName(String adName) {
        this.adName = adName;
    }

    public String getAdEmailAddress() {
        return adEmailAddress;
    }

    public void setAdEmailAddress(String adEmailAddress) {
        this.adEmailAddress = adEmailAddress;
    }

    public String getAdRole() {
        return adRole;
    }

    public void setAdRole(String adRole) {
        this.adRole = adRole;
    }

    public String getBlockingIndicatorSAP() {
        return blockingIndicatorSAP;
    }

    public void setBlockingIndicatorSAP(String blockingIndicatorSAP) {
        this.blockingIndicatorSAP = blockingIndicatorSAP;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getAcUniqueNumber() {
        return acUniqueNumber;
    }

    public void setAcUniqueNumber(String acUniqueNumber) {
        this.acUniqueNumber = acUniqueNumber;
    }

    public String getAcName() {
        return acName;
    }

    public void setAcName(String acName) {
        this.acName = acName;
    }

    public String getAcEmailAddress() {
        return acEmailAddress;
    }

    public void setAcEmailAddress(String acEmailAddress) {
        this.acEmailAddress = acEmailAddress;
    }

    public String getAcRole() {
        return acRole;
    }

    public void setAcRole(String acRole) {
        this.acRole = acRole;
    }

    public String getValid() {
        return valid;
    }

    public void setValid(String valid) {
        this.valid = valid;
    }

    public String getBlockingIndicatorIDV() {
        return blockingIndicatorIDV;
    }

    public void setBlockingIndicatorIDV(String blockingIndicatorIDV) {
        this.blockingIndicatorIDV = blockingIndicatorIDV;
    }
}
