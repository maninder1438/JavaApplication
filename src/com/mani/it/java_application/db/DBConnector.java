package com.mani.it.java_application.db;

import com.mani.it.java_application.model.Customer;
import com.mani.it.java_application.model.Transactions;
import com.mani.it.java_application.services.CreateTransactions;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class DBConnector {
  public static List<Customer> customerStore=new ArrayList<>();
  public static List<CreateTransactions> transactionStore=new ArrayList<>();

  public void save (Customer customer) {customerStore.add(customer);}
  public void save (CreateTransactions transactions) {transactionStore.add(transactions);}

  public List<Customer> getCustomer (String dob, String lastname){
      return customerStore.stream().filter(customer->customer.getDob().equalsIgnoreCase(dob)).filter(last->last.getLastName().equalsIgnoreCase(lastname)).collect(Collectors.toList());
  }

  public void deleteCustomer (String lastname){
      customerStore.stream().filter(customer->customer.getLastName().equalsIgnoreCase(lastname)).collect(Collectors.toList());
      customerStore.remove(0);

  }

  public List<Customer> getCustomer (String lastname){
      return customerStore.stream().filter(customer->customer.getLastName().equalsIgnoreCase(lastname)).collect(Collectors.toList());
  }
}

