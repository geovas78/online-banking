/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webbank.servlets;

import com.webbank.database.DatabaseOperations;
import com.webbank.model.LoginDetails;
import com.webbank.model.UserAccountDetails;
import com.webbank.services.LoginService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author George
 */
@WebServlet(name = "Login", urlPatterns = {"/login"})
public class Login extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        {
            HttpSession session = request.getSession();
            if (request.getParameter("logout") != null) {
                session.invalidate();
                response.sendRedirect("login");
                return;
            } else if (session.getAttribute("userAccountDetails") != null) {
                response.sendRedirect("options");
                return;
            }

            request.setAttribute("loginFailed", false);
            request.getRequestDispatcher("/WEB-INF/jsp/view/login.jsp")
                    .forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        
        HttpSession session = request.getSession();
        if (session.getAttribute("userAccountDetails") != null) {
            response.sendRedirect("options");
            return;
        }

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        LoginService loginService = new LoginService();
        LoginDetails checkLogin = loginService.getLoginDetails(username, password);
        if (username == null || password == null || !password.equals(checkLogin.getPassword())) {
            request.setAttribute("loginFailed", true);
            request.getRequestDispatcher("/WEB-INF/jsp/view/login.jsp")
                    .forward(request, response);
        }
        else
        {
            DatabaseOperations dbOps = new DatabaseOperations();
            UserAccountDetails userAccountDetails = new UserAccountDetails();
            userAccountDetails = dbOps.getUserDetails(checkLogin.getAccountNumer() + "");
            session.setAttribute("userAccountDetails", userAccountDetails);
            request.changeSessionId();
            response.sendRedirect("options");
        }

        
    }

}
