/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webbank.database;

import com.webbank.model.LoginDetails;
import com.webbank.model.Transaction;
import com.webbank.model.UserAccountDetails;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author George
 */
public class DatabaseOperations {

    DecimalFormat df = new DecimalFormat("######0.00");

    private final DatabaseConnection databaseConn = new DatabaseConnection();
    private final Connection conn = databaseConn.getDBConnection();

    public String getActualBalance(String accountNumberIn) {
        String balanceFormatted = null;

        try {
            Statement stmt = conn.createStatement();
            String sql = "SELECT Balance FROM accounts WHERE AccountNumber = '" + accountNumberIn + "'";

            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                double balance = rs.getDouble("Balance");

                balanceFormatted = df.format(balance);

            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseOperations.class.getName()).log(Level.SEVERE, null, ex);
        }

        return balanceFormatted;
    }

    public UserAccountDetails getUserDetails(String accountNumberIn) {
        UserAccountDetails userAccountDetails = new UserAccountDetails();

        try {
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM accounts WHERE AccountNumber = '" + accountNumberIn + "'";

            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int accountNumber = rs.getInt("AccountNumber");
                String name = rs.getString("AccountName");
                String accountType = rs.getString("AccountType");
                double overdraftLimit = rs.getDouble("Overdraft");
                String dateOfCreation = rs.getString("Date_");
                String houseNumber = rs.getString("houseNumber");
                String streetName = rs.getString("StreetName");
                String town = rs.getString("Town");
                String postcode = rs.getString("PostCode");
                long telephoneNumber = rs.getLong("Telephone");

                userAccountDetails.setdetails(accountNumber, name, accountType, overdraftLimit, dateOfCreation,
                        houseNumber, streetName, town, postcode, telephoneNumber);

            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseOperations.class.getName()).log(Level.SEVERE, null, ex);
        }

        return userAccountDetails;
    }

    public LoginDetails getLoginDetails(String usernameIn) {
        LoginDetails loginDetails = new LoginDetails();

        try {
            Statement stmt = conn.createStatement();
            String sql = "SELECT USERNAME,PASSWORD,AccountNumber FROM accounts WHERE USERNAME = '" + usernameIn + "'";

            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int accountNumber = rs.getInt("AccountNumber");
                String username = rs.getString("USERNAME");
                String password = rs.getString("PASSWORD");

                loginDetails.setLoginDetails(username, password, accountNumber);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseOperations.class.getName()).log(Level.SEVERE, null, ex);
        }

        return loginDetails;

    }

    public List<Transaction> getTransactions(int accountNumber) {
        List<Transaction> listTransactions = new ArrayList<Transaction>();

        try {
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM transactions WHERE AccountNumber = '" + accountNumber + "'";

            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Transaction transaction = new Transaction();
                String date = rs.getString("Date_");
                String type = rs.getString("Type_");
                double amountD = rs.getDouble("Amount");
                double balancePriorD = rs.getDouble("BalancePrior");
                double balancePostD = rs.getDouble("BalancePost");

                String amount = df.format(amountD);
                String balancePrior = df.format(balancePriorD);
                String balancePost = df.format(balancePostD);

                transaction.setListOfTransactions(date, type, amount, balancePrior, balancePost);
                listTransactions.add(transaction);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseOperations.class.getName()).log(Level.SEVERE, null, ex);
        }

        Collections.reverse(listTransactions);
        return listTransactions;
    }

    public boolean changePassword(String oldPassword, String passwordChanged, int accountNumber) {

        boolean report = false;
        String passwordFromDB = null;

        try {
            Statement stmt = conn.createStatement();
            String sql = "SELECT PASSWORD FROM accounts WHERE AccountNumber = '" + accountNumber + "'";

            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                passwordFromDB = rs.getString("PASSWORD");
            }

            if (passwordFromDB != null && oldPassword.equals(passwordFromDB)) {

                boolean updated = updateDB(passwordChanged, accountNumber);
                if (updated) {
                    report = true;
                }
            } else {
                report = false;
            }

        } catch (SQLException ex) {
            Logger.getLogger(DatabaseOperations.class.getName()).log(Level.SEVERE, null, ex);
        }

        return report;
    }

    private boolean updateDB(String passwordChanged, int accountNumber) {
        int result = 0;
        try {
            Statement stmt = conn.createStatement();
            String sql = "UPDATE accounts SET PASSWORD = '" + passwordChanged + "'"
                    + "WHERE AccountNumber = " + accountNumber + ";";

            result = stmt.executeUpdate(sql);

        } catch (SQLException e) {

        }
        return result == 1;
    }

    // all following method are to process payment
    public boolean processTransferOfMoney(String senderAccount, String recipientAccount, String recipientName, double amount) {

        Connection conn = databaseConn.getDBConnection();
        String nameDB = null;
        boolean report = false;
        boolean success = false;

        try {
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM accounts WHERE AccountNumber = '" + recipientAccount + "'";

            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                nameDB = rs.getString("AccountName");
            }

            if (nameDB != null && nameDB.equals(recipientName)) {

                success = updateDbForPayment(senderAccount, recipientAccount, amount);

                if (success) {
                    report = true;
                }
            } else {
                report = false;
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        return report;

    }

    private boolean updateDbForPayment(String senderAccount, String recipientAccount, double amount) {

        Connection conn = databaseConn.getDBConnection();
        boolean ok = false;

        try {
            conn.setAutoCommit(false);

            double balanceOrigin = query(senderAccount);
            double balanceTarget = query(recipientAccount);

            StatusAndPostbalance successOrigin = transactionProcess(senderAccount, balanceOrigin, amount, 0);
            StatusAndPostbalance successTarget = transactionProcess(recipientAccount, balanceTarget, amount, 1);

            transactionLog(senderAccount, amount, "Online PAY", balanceOrigin, successOrigin.getPostBalance());
            transactionLog(recipientAccount, amount, "Online TRF", balanceTarget, successTarget.getPostBalance());

            if (successOrigin.isOk() == true && successTarget.isOk() == true) {
                conn.commit();
                ok = true;
            } else {
                conn.rollback();
                conn.setAutoCommit(true);
                ok = false;
            }

        } catch (SQLException ex) {
            Logger.getLogger(DatabaseOperations.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ok;

    }

    public String getDate() {
        Calendar c = Calendar.getInstance();
        String d = new String();
        d = String.valueOf(c.get(Calendar.DATE) + "/" + (c.get(Calendar.MONTH) + 1) + "/" + c.get(Calendar.YEAR));
        return d;
    }

    private double query(String accountIn) {

        Connection conn = databaseConn.getDBConnection();
        String sql = "SELECT Balance FROM accounts Where AccountNumber = " + accountIn;

        PreparedStatement pst = null;

        double balanceReturned = 0;

        try {
            pst = conn.prepareStatement(sql);
            ResultSet result = pst.executeQuery();

            while (result.next()) {
                balanceReturned = result.getDouble("Balance");
            }
        } catch (java.sql.SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
        return balanceReturned;

    }

    private StatusAndPostbalance transactionProcess(String accountIn, double balanceIn, double amount, int transType) {

        Connection conn = databaseConn.getDBConnection();
        double postBalance = 0;
        if (transType == 0) {
            postBalance = balanceIn - amount;
        }
        if (transType == 1) {
            postBalance = balanceIn + amount;
        }

        PreparedStatement stm = null;
        boolean ok = false;

        String sql = "UPDATE accounts SET Balance = " + df.format(postBalance) + " WHERE AccountNumber = " + accountIn;

        try {
            stm = conn.prepareStatement(sql);

            stm.executeUpdate();

            ok = true;
        } catch (SQLException ex) {
            ok = false;
            ex.printStackTrace();
        } finally {
            if (stm != null) {
                try {
                    stm.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }

        //set the values for boolean and the post balance for the transaction log
        StatusAndPostbalance sb = new StatusAndPostbalance();
        sb.setPostPalance(postBalance);
        sb.setOk(ok);

        return sb;

    }

    private void transactionLog(String accountIn, double amount, String typeOfTrans, double balancePrior, double postBalance) {

        Connection conn = databaseConn.getDBConnection();
        String date = getDate();
        Statement stm = null;

        try {

            stm = conn.createStatement();

            String statement = "INSERT INTO transactions(AccountNumber,Amount,Type_,Date_,BalancePrior,BalancePost)"
                    + " VALUES(" + accountIn + "," + amount + "," + "'" + typeOfTrans + "',"
                    + "'" + date + "'," + balancePrior + "," + postBalance + ")";

            int result = stm.executeUpdate(statement);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            if (stm != null) {
                try {
                    stm.close();
                } catch (SQLException ex) {
                }
            }

        }

    }

    public String registerNewUser(String name, String accountNumber, String username, String password) {

        Connection conn = databaseConn.getDBConnection();
        String message = "error";
        Statement stmt = null;
        //check first if the user is not registered already
        //check if username is not taken
        //check if all given details are correctly spelled
        //register if all given details are correctly spelled
        try {
            String nameFromDB = null;
            String accountFromDB = null;
            String usernameFromDB = null;
            String passwordFromDB = null;
            stmt = conn.createStatement();
            String makeRecord = "UPDATE accounts SET USERNAME = '" + username + "', " + "PASSWORD = '" + password + "'"
                    + "WHERE AccountNumber = '" + accountNumber + "';";
            String getUserDetails = "SELECT * FROM accounts WHERE AccountName = '" + name + "'";
            String getUsers = "SELECT USERNAME FROM accounts WHERE USERNAME = '" + username + "'";

            stmt = conn.createStatement();

            ResultSet detailsResult = stmt.executeQuery(getUserDetails);

            while (detailsResult.next()) {
                nameFromDB = detailsResult.getString("AccountName");
                accountFromDB = detailsResult.getString("AccountNumber");
                usernameFromDB = detailsResult.getString("USERNAME");
                passwordFromDB = detailsResult.getString("PASSWORD");
            }
            //start with checks
            if (nameFromDB != null && nameFromDB.equals(name) && accountFromDB.equals(accountNumber)) {
                if (usernameFromDB != null && passwordFromDB != null) {
                    message = "USER HAS BEEN ALREADY REGISTER. TRY TO LOGIN INSTEAD";
                } else {
                    String usernameDB = null;
                    ResultSet users = stmt.executeQuery(getUsers);
                    while (users.next()) {
                        usernameDB = users.getString("USERNAME");
                    }
                    if (usernameDB != null) {
                        message = "USERNAME IS TAKEN";
                    } else {
                        int result = stmt.executeUpdate(makeRecord);
                        if (result > 0) {
                            message = "DONE";
                        }
                    }
                }
            } else {
                message = "CHECK YOUR NAME AND ACCOUNT NUMBER ARE CORRECT";
            }

        } catch (SQLException ex) {
            Logger.getLogger(DatabaseOperations.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                }
            }

        }

        return message;
    }
        
}
