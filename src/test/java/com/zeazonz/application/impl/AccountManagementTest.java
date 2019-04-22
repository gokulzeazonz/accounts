package com.zeazonz.application.impl;

import com.zeazonz.application.AccountManagement;
import com.zeazonz.domain.model.financial.Expenditure;
import com.zeazonz.domain.model.user.Address;
import com.zeazonz.domain.model.user.Email;
import com.zeazonz.domain.model.user.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class AccountManagementTest {

    private static AccountManagement accountManagement;

    @BeforeAll
    public static void init(){
        accountManagement = new AccountManagementImpl();
    }

    @Test
    public void test(){
        User user = new User("Zeazonz",new Address("Pvt ltd","Nadakkavu","Kochi","Ernakulam","Kerala","India"),
                new Email("hgfh@gmail.com"),
                "aa1aaA");
        accountManagement.addNewUser(user);

        Date date = new Date();
        Expenditure expenditure = new Expenditure(date,200L);
        accountManagement.addExpense(user,expenditure,"Food");
        Long amount = accountManagement.totalExpense(user.getId());

        System.out.println("\n----------------------------\n");
        System.out.println("Total Expense : "+amount);
        System.out.println("\n----------------------------\n");

        long day1 = 1000*60*60*24;
        amount = accountManagement.getExpense(user.getId(),new Date(date.getTime()-day1),new Date(date.getTime()+day1));

        System.out.println("\n----------------------------\n");
        System.out.println("Total Expense with in time range : "+amount);
        System.out.println("\n----------------------------\n");
    }

}
