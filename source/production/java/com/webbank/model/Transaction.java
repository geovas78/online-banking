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
public class Transaction implements Serializable{
    
    private String date;
    private String type;
    private String amount;
    private String balancePrior;
    private String balancePost;
    
    public void setListOfTransactions(String date, String type, String amount,
            String balancePrior, String balancePost)
    {
        this.date = date;
        this.type = type;
        this.amount = amount;
        this.balancePrior = balancePrior;
        this.balancePost = balancePost;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getBalancePrior() {
        return balancePrior;
    }

    public void setBalancePrior(String balancePrior) {
        this.balancePrior = balancePrior;
    }

    public String getBalancePost() {
        return balancePost;
    }

    public void setBalancePost(String balancePost) {
        this.balancePost = balancePost;
    }
    
}
