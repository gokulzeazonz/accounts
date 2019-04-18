package com.zeazonz.application.impl;

import com.zeazonz.application.AccountManagement;
import com.zeazonz.domain.model.financial.Expenditure;
import com.zeazonz.domain.model.financial.Income;
import com.zeazonz.domain.model.user.User;
import com.zeazonz.domain.model.user.UserRepository;
import com.zeazonz.infrastructure.repository.impl.user.UserRepositoryImpl;

import java.util.Date;

public class AccountManagementImpl implements AccountManagement {
    @Override
    public void addNewUser(User user) {
        UserRepository userRepository= new UserRepositoryImpl();
        userRepository.save(user);
    }

    @Override
    public void deleteMyAccount(User user) {

    }

    @Override
    public void addExpense(Long userId, Expenditure expense) {

    }

    @Override
    public void addIncome(Long userId, Income income) {

    }

    @Override
    public Long totalExpense(Long userId) {
        return null;
    }

    @Override
    public Long totalIncome(Long userId) {
        return null;
    }

    @Override
    public Long getExpense(Long userId, Date start, Date end) {
        return null;
    }

    @Override
    public Long getIncome(Long userId, Date start, Date end) {
        return null;
    }

    @Override
    public Long getExpenseUsingCategory(Long userId, String category, Date start, Date end) {
        return null;
    }
}
