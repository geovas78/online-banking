/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webbank.servlets;

import com.webbank.database.DatabaseOperations;
import com.webbank.model.UserAccountDetails;
import java.io.IOException;
import java.text.DecimalFormat;
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
@WebServlet(name = "Options", urlPatterns = {"/options"}, loadOnStartup = 1)
public class Options extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        String action = request.getParameter("action");
        
        if(request.getParameter("action") == null)
        {
            action = "transactions";
        }
        
        switch(action)
        {
            case "transactions" : this.showTransactions(request, response);break;
            //case "register": this.registerForm(request, response);break;
            case "details" : this.showDetails(request, response); break;
            case "makePayment" : this.makePayment(request,response);break;
            case "changePass" : this.passwordChange(request,response);break;
            default : this.showTransactions(request, response);break;
        }
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        switch(action)
        {
            case "changePass" : this.processPassChange(request, response);break;
            case "makePayment":this.processPayment(request, response);break;
            //case "register": this.recordUserInDB(request, response);break;
            case "confirmPayment": this.proceedWithPayment(request,response);break;
        }
        
    }

    private void showTransactions(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
               request.getRequestDispatcher("/showTransactions")
               .forward(request, response);
    }

    private void showDetails(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/jsp/view/user-details.jsp")
               .forward(request, response);
    }

    private void makePayment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/jsp/view/make-payment.jsp")
               .forward(request, response);
    }
    /*
    private void registerForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/jsp/view/sign-up.jsp")
               .forward(request, response);
    }
    
    private void recordUserInDB(HttpServletRequest request, HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    */
    private void passwordChange(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/jsp/view/password-change.jsp")
               .forward(request, response);
    }

    private void processPassChange(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        UserAccountDetails details = (UserAccountDetails)session.getAttribute("userAccountDetails");
        
        
        String oldPassword = request.getParameter("old-password");
        String passwordChanged = request.getParameter("new-password");
        int accountNumber = details.getAccount();
        
        DatabaseOperations dbOps = new DatabaseOperations();
        boolean reportBack = dbOps.changePassword(oldPassword,passwordChanged,accountNumber);
        
        String message = null;
        String cssValue = null;
        
        if(reportBack)
        {
            message = "PASSWORD HAS BEEN UPDATED SUCCESSFULLY";
            cssValue = "success";
        }
        else
        {
            message = "OPERATION FAILED !";
            cssValue = "fail";
        }
        
        request.setAttribute("message",message);
        request.setAttribute("cssValue", cssValue);
        
        request.getRequestDispatcher("/WEB-INF/jsp/view/result.jsp")
               .forward(request, response);
        
    }

    private void processPayment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String titleOfRecipient = request.getParameter("title");
        String nameOfRecipient = request.getParameter("name");
        String accountNumber = request.getParameter("account-number");
        String amountP = request.getParameter("amount");
        
        DecimalFormat df = new DecimalFormat("######0.00");
        double amountD = Double.parseDouble(amountP);
        String amount = df.format(amountD);
        
        String name = titleOfRecipient + " " + nameOfRecipient;
        
        request.setAttribute("name", name);
        request.setAttribute("accountNumber", accountNumber);
        request.setAttribute("amount", amount);
        
        request.getRequestDispatcher("/WEB-INF/jsp/view/reviewRequest.jsp")
               .forward(request, response);
        
    }

    private void proceedWithPayment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        UserAccountDetails details = (UserAccountDetails)session.getAttribute("userAccountDetails");
        
        int senderAccountP = details.getAccount();
        String recipientName = request.getParameter("name");
        String recipientAccount = request.getParameter("account-number");
        String transferringAmount = request.getParameter("amount");
        
        
        //convert amount to double
        double amount = Double.parseDouble(transferringAmount);
        
        //convert account to a string
        String senderAccount = String.valueOf(senderAccountP);
        
        DatabaseOperations dbOps = new DatabaseOperations();
        
        boolean reportBack = dbOps.processTransferOfMoney(senderAccount, recipientAccount, recipientName, amount);
        
        String message = null;
        String cssValue = null;
        
        if(reportBack)
        {
            message = "TRANSACTION WAS SUCCESSFUL";
            cssValue = "success";
        }
        else
        {
            message = "TRANSACTION FAILED. CHECK IF NAME AND ACCOUNT NUMBER ARE CORRECT !";
            cssValue = "fail";
        }
        
        request.setAttribute("message",message);
        request.setAttribute("cssValue", cssValue);
        
        request.getRequestDispatcher("/WEB-INF/jsp/view/result.jsp")
               .forward(request, response);
    }

}
