package com.zeazonz.application;

import com.zeazonz.domain.model.financial.Expenditure;
import com.zeazonz.domain.model.financial.Income;
import com.zeazonz.domain.model.user.User;

import java.util.Date;

public interface AccountManagement {

    void addNewUser(User user);

    void deleteMyAccount(User user);

    void addExpense(Long userId,Expenditure expense);

    void addIncome(Long userId,Income income);

    Long totalExpense(Long userId);

    Long totalIncome(Long userId);

    Long getExpense(Long userId, Date start, Date end);

    Long getIncome(Long userId,Date start,Date end);

    Long getExpenseUsingCategory(Long userId,String category,Date start, Date end);

}
