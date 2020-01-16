package com.mani.it.java_application.services;

import com.mani.it.java_application.db.DBConnector;
import com.mani.it.java_application.model.Customer;

import java.time.LocalDate;

public class CreateCustomer {

    public void  create(){

        // creating the 1st customer from Customer class in model by creating an object of Customer class
        // and use the set method to set the variable values
        Customer customer1= new Customer();
        customer1.setFirstName("Maninder");
        customer1.setLastName("Singh");
        customer1.setDob("12-10-1986");
        customer1.setPostcode("UB4 9TH");
        customer1.setId(1L);
        //below i am using (LocalDateTime.now().minusDays(20) to set the date from now to 20 days before
        customer1.setCreateDated(LocalDate.now().minusDays(20));

        // creating the 2nd customer from Customer class in model by creating an object of Customer class
        // and use the set method to set the variable values
        Customer customer2= new Customer();
        customer2.setFirstName("Manpreet");
        customer2.setLastName("Kaur");
        customer2.setDob("12-02-1993");
        customer2.setPostcode("UB3 4QF");
        customer2.setId(2L);
        customer2.setCreateDated(LocalDate.now());

        // creating the 3rd customer from Customer class in model by creating an object of Customer class
        // and use the set method to set the variable values
        Customer customer3= new Customer();
        customer3.setFirstName("Aman");
        customer3.setLastName("Sharma");
        customer3.setDob("10-10-1990");
        customer3.setPostcode("EC18 9NX");
        customer3.setId(3L);
        customer3.setCreateDated(LocalDate.now());

        //saving the above created 3 customers data in the database by creating creating its object
        DBConnector db = new DBConnector();
        db.save(customer1);
        db.save(customer2);
        db.save(customer3);
        return;
    }
}
