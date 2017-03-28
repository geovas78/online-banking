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
@WebServlet(name = "TransactionsShow", urlPatterns = {"/showTransactions"})
public class TransactionsShow extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        UserAccountDetails details = (UserAccountDetails) session.getAttribute("userAccountDetails");
        DatabaseOperations dbOps = new DatabaseOperations();
        List<Transaction> listOfTransactions = new ArrayList<Transaction>();
        listOfTransactions = dbOps.getTransactions(details.getAccount());
        String balance = dbOps.getActualBalance(String.valueOf(details.getAccount()));
        request.setAttribute("balance",balance);
        request.setAttribute("listOfTransactions", listOfTransactions);
        request.getRequestDispatcher("/WEB-INF/jsp/view/transactionList.jsp")
               .forward(request, response);
        
    }
}
