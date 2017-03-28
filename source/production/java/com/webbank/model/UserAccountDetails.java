/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webbank.model;

import java.io.Serializable;

/**
 *
 * @author George
 */
public class UserAccountDetails implements Serializable{

    private int account;
    private String name;
    private String accountType;
    private double overdraftLimit;
    private String dateOfCreation;
    private String houseNumber;
    private String streetName;
    private String town;
    private String postcode;
    private long telephoneNumber;
    
    
    public void setdetails(int account, String name, String accountType, double overdraftLimit,
            String dateOfCreation, String houseNumber, String streetName, String town,
            String postcode, long telephoneNumber) {
        this.account = account;
        this.name = name;
        this.accountType = accountType;
        this.overdraftLimit = overdraftLimit;
        this.dateOfCreation = dateOfCreation;
        this.houseNumber = houseNumber;
        this.streetName = streetName;
        this.town = town;
        this.postcode = postcode;
        this.telephoneNumber = telephoneNumber;
    }

    public int getAccount() {
        return account;
    }

    public void setAccount(int account) {
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public double getOverdraftLimit() {
        return overdraftLimit;
    }

    public void setOverdraftLimit(double overdraftLimit) {
        this.overdraftLimit = overdraftLimit;
    }

    public String getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(String dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public long getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(long telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

}
