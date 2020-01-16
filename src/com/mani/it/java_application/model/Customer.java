package com.mani.it.java_application.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Customer {
    private String firstName;
    private String lastName;
    private String dob;
    private String postcode;
    private LocalDate createDated;
    private Double balance;
    private long id;

    //assigning default opening balance of £500.00
    public Customer(){this.balance=500.00;}

    //creating getter & setter for above assigned variables (right click then click generate then click getter & setter)


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public LocalDate getCreateDated() {
        return createDated;
    }

    public void setCreateDated(LocalDate createDated) {
        this.createDated = createDated;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
