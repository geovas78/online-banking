/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webbank.servlets;

import com.webbank.database.DatabaseOperations;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author George
 */
@WebServlet(name = "Register", urlPatterns = {"/register"})
public class Register extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.getRequestDispatcher("/WEB-INF/jsp/view/sign-up.jsp")
               .forward(request, response);
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //get all parameters passed from the register form
        String name = request.getParameter("name");
        String accountNumber = request.getParameter("account-number");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        
        DatabaseOperations dbOps = new DatabaseOperations();
        String result = dbOps.registerNewUser(name, accountNumber, username, password);
        
        //if result is returning true redirect to the login page after showing the confirmation page
        if(result.equals("USERNAME IS TAKEN") || result.equals("CHECK YOUR NAME AND ACCOUNT NUMBER ARE CORRECT"))
        {
            request.setAttribute("error",true);
            request.setAttribute("message", result);
            request.getRequestDispatcher("/WEB-INF/jsp/view/sign-up.jsp")
               .forward(request, response);
        }
        if(result.equals("USER HAS BEEN ALREADY REGISTER. TRY TO LOGIN INSTEAD") || result.equals("DONE"))
        {
            request.setAttribute("message", result);
            request.setAttribute("cssValue","success");
            request.getRequestDispatcher("/WEB-INF/jsp/view/result.jsp")
               .forward(request, response);
        }
    }
}
