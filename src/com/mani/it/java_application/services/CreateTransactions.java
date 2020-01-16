package com.mani.it.java_application.services;

import com.mani.it.java_application.db.DBConnector;
import com.mani.it.java_application.model.Customer;
import com.mani.it.java_application.model.Transactions;

import java.io.FileInputStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Properties;

public class CreateTransactions {

    //creating an object of DBConnector main database & Transactions
    DBConnector dbConnctor = new DBConnector();
    Transactions tx1 = new Transactions();

    //below method to verify the authorization code which we will read from security.properties file
    public void VerifyAuthCode() throws Exception {

        Properties properties = new Properties();
        FileInputStream fs = new FileInputStream("C:\\Users\\MANI\\IdeaProjects\\mani-it-world\\src\\com\\mani\\it\\java_application\\security.properites");
        properties.load(fs);


        String authID = properties.get("authid").toString();
        if (!authID.equals("abc123")) {
            throw new RuntimeException("Unauthosized access .");
        }
    }

    public void creatingTransaction() {

        //sender details to do transaction
        tx1.setAccountHolderName("Singh");
        tx1.setReference("Borrow Money Returned");
        tx1.setTxAmount(100.00);
        tx1.setTxDateTime(LocalDateTime.now());

        // benef. account details
        tx1.setBenefName("Kaur");
        tx1.setAccountNumber("37578178");
        tx1.setSortCode("09 - 01 - 27");
    }

    //to verify that sender is exist using sender's dob & last name
    public void verifySenderAccountExist() {
        new CreateCustomer().create();
        String dob = "12-10-1986";
        String lastname = "Singh";
        List<Customer> reslutSet = dbConnctor.getCustomer(dob, lastname);
        if (reslutSet.size() == 0) {
            throw new RuntimeException("No Customer found with details having " + dob + " & Last Name: " + lastname);
        }
    }

    //verify both account exists
    public boolean isAccountExist(DBConnector dbConncetor) {
        int cust1 = dbConncetor.getCustomer("Singh").size();
        int cust2 = dbConncetor.getCustomer("Kaur").size();
        if (cust1 == 0) {
            throw new RuntimeException("cust1 is not exist");
        }
        if (cust2 == 0) {
            throw new RuntimeException("Cust2 is not exist");
        }
        return true;
    }

    //verify sender has enough money to send
    public void isUserGotEnoughMoney() {
        List<Customer> resultSet = dbConnctor.getCustomer("Singh");
        boolean enoughMoney = tx1.getTxAmount() <= resultSet.get(0).getBalance();
        if (!enoughMoney) {
            throw new RuntimeException("Sender does not have enough money");
        }
    }

    //updating the sender's balance after successful transaction
    public void newSenderBalance() {
        List<Customer> resultSet = dbConnctor.getCustomer("Singh");
        Double newBal = resultSet.get(0).getBalance() - tx1.getTxAmount();
        System.out.println("The New Balance of Sender is: £" + newBal);
    }

    //updating the Beneficiary's balance after successful transaction
    public void newBenefBalance() {
        List<Customer> resultSet = dbConnctor.getCustomer("Kaur");
        Double newBal = resultSet.get(0).getBalance() + tx1.getTxAmount();
        System.out.println("The New Balance of Beneficiary is: £" + newBal);
    }

    //Fetching and printing all the details of the sender
    public void printSenderDetails() {
        List<Customer> results = dbConnctor.getCustomer("Singh");
        String fName = results.get(0).getFirstName();
        String lName = results.get(0).getLastName();
        String dob = results.get(0).getDob();
        String pCode = results.get(0).getPostcode();
        LocalDate cdate = results.get(0).getCreateDated();
        Long id = results.get(0).getId();
        System.out.println("Below is the Sender's Full Details \nFull Name is: "
                + fName + " " + lName + " having DOB " + dob + " & Post Code: "
                + pCode + "\n& his account was created on " + cdate + " & his unique id is: " + id);


    }
}
