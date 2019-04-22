package com.zeazonz.application;

import com.zeazonz.domain.model.financial.Expenditure;
import com.zeazonz.domain.model.financial.Income;
import com.zeazonz.domain.model.user.Email;
import com.zeazonz.domain.model.user.User;
import com.zeazonz.exception.UserInvalidException;

import java.util.Date;
import java.util.Optional;

public interface AccountManagement {

    Optional<User> isValidUser(String email, String password)  throws UserInvalidException;

    void addNewUser(User user);

    void deleteMyAccount(User user);

    void addExpense(User user,Expenditure expense, String categoryName);

    void addIncome(User user,Income income, String categoryName);

    Long totalExpense(Long userId);

    Long totalIncome(Long userId);

    Long getExpense(Long userId, Date start, Date end);

    Long getIncome(Long userId,Date start,Date end);

    Long getExpenseUsingCategory(Long userId,String category,Date start, Date end);

}
