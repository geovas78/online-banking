/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webbank.servlets;

import com.webbank.database.DatabaseOperations;
import com.webbank.model.Transaction;
import com.webbank.model.UserAccountDetails;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
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
@WebServlet(name = "TestServlet", urlPatterns = {"/test"})
public class TestServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        /*
        HttpSession session = request.getSession();
        UserAccountDetails details = (UserAccountDetails) session.getAttribute("userAccountDetails");
        DatabaseOperations dbOps = new DatabaseOperations();
        List<Transaction> listOfTransactions = new ArrayList<Transaction>();
        listOfTransactions = dbOps.getTransactions(details.getAccount());
        session.setAttribute("listOfTransactions", listOfTransactions);
        request.getRequestDispatcher("/WEB-INF/jsp/view/transactionList.jsp")
               .forward(request, response);*/
        String message = (String) request.getAttribute("message");
        
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet TestServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>message : " + message+ "</h1>");
            //out.println("<h1>Account number : " + request.getParameter("account-number") + "</h1>");
            //out.println("<h1>Account number : " + request.getParameter("amount")+ "</h1>");
            out.println("<br />");
            //for(Transaction tr : listOfTransactions)
            //{
                //System.out.println(tr.getDate());
                //out.println("<h1>Date : " + tr.getDate() + "</h1><br />");
            //}
            //out.println("<h1>Account number : " + details.getAccount() + "</h1>");
            //out.println("</body>");
            //out.println("</html>");
        }
    }
}
