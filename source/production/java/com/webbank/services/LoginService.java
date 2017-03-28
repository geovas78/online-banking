/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webbank.services;

import com.webbank.database.DatabaseOperations;
import com.webbank.model.LoginDetails;
import com.webbank.model.UserAccountDetails;
import javax.servlet.http.HttpSession;

/**
 *
 * @author George
 */
public class LoginService{
    
    DatabaseOperations dbOps;
    
    //boolean loginStatus;
    
    public LoginDetails getLoginDetails(String username, String password)
    {
        DatabaseOperations dbOps = new DatabaseOperations();
        LoginDetails loginDetails = dbOps.getLoginDetails(username);
        return loginDetails;
        
        /*
        DatabaseOperations dbOps = new DatabaseOperations();
        LoginDetails loginDetails = dbOps.getLoginDetails(username);
        
        if(username != null && password.equals(loginDetails.getPassword()))
        {
            UserAccountDetails userAccountDetails = new UserAccountDetails();
            session.setAttribute("userAccountDetails", userAccountDetails);
            dbOps.getUserDetails("" + loginDetails.getAccountNumer());
            
            loginStatus = true;
        }
        else
        {
            loginStatus = false;
        }
        
        return loginStatus;
        */
    }
    
}
