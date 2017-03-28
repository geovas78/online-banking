/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webbank.model;

/**
 *
 * @author George
 */
public class LoginDetails {

    private String username;
    private String password;
    private int accountNumer;
    
    public void setLoginDetails(String username, String password, int accountNumber)
    {
        this.username = username;
        this.password = password;
        this.accountNumer = accountNumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAccountNumer() {
        return accountNumer;
    }

    public void setAccountNumer(int accountNumer) {
        this.accountNumer = accountNumer;
    }

}
