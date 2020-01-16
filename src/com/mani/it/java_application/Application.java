package com.mani.it.java_application;

import com.mani.it.java_application.db.DBConnector;
import com.mani.it.java_application.services.CreateTransactions;


public class Application {

    public static void main(String[] args) throws Exception {

        DBConnector db = new DBConnector();
        CreateTransactions transactions = new CreateTransactions();

        transactions.VerifyAuthCode();
        transactions.verifySenderAccountExist();
        transactions.isAccountExist(db);
        transactions.creatingTransaction();
        transactions.isUserGotEnoughMoney();
        transactions.newBenefBalance();
        transactions.newSenderBalance();
        transactions.printSenderDetails();
        db.save(transactions);
    }
}

