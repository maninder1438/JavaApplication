package com.mani.it.java_application.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Transactions {
    private String accountHolderName;
    private String accountNumber;
    private String sortCode;
    private String benefName;
    private String reference;
    private double txAmount;
    private LocalDateTime txDateTime;

    //creating getter & setter for above assigned variables (right click then click generate then click getter & setter)


    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getSortCode() {
        return sortCode;
    }

    public void setSortCode(String sortCode) {
        this.sortCode = sortCode;
    }

    public String getBenefName() {
        return benefName;
    }

    public void setBenefName(String benefName) {
        this.benefName = benefName;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public double getTxAmount() {
        return txAmount;
    }

    public void setTxAmount(double txAmount) {
        this.txAmount = txAmount;
    }

    public LocalDateTime getTxDateTime() {
        return txDateTime;
    }

    public void setTxDateTime(LocalDateTime txDateTime) {
        this.txDateTime = txDateTime;
    }
}
