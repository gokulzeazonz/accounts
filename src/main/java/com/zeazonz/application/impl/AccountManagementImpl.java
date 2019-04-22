package com.zeazonz.application.impl;

import com.zeazonz.application.AccountManagement;
import com.zeazonz.domain.model.category.Category;
import com.zeazonz.domain.model.category.CategoryRepository;
import com.zeazonz.domain.model.financial.Expenditure;
import com.zeazonz.domain.model.financial.FinancialRepository;
import com.zeazonz.domain.model.financial.Income;
import com.zeazonz.domain.model.user.Email;
import com.zeazonz.domain.model.user.User;
import com.zeazonz.domain.model.user.UserRepository;
import com.zeazonz.exception.UserInvalidException;
import com.zeazonz.infrastructure.repository.impl.category.CategoryRepositoryImpl;
import com.zeazonz.infrastructure.repository.impl.financial.FinancialRepositoryImpl;
import com.zeazonz.infrastructure.repository.impl.user.UserRepositoryImpl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public class AccountManagementImpl implements AccountManagement {

    private UserRepository userRepository;

    private CategoryRepository categoryRepository;

    private FinancialRepository financialRepository;

    private UserRepository getUserRepository() {
        if(userRepository==null)
            userRepository = new UserRepositoryImpl();
        return userRepository;
    }

    private CategoryRepository getCategoryRepository() {
        if(categoryRepository==null)
            categoryRepository = new CategoryRepositoryImpl();
        return categoryRepository;
    }

    private FinancialRepository getFinancialRepository() {
        if(financialRepository==null)
            financialRepository = new FinancialRepositoryImpl();
        return financialRepository;
    }

    @Override
    public Optional<User> isValidUser(String email, String password) throws UserInvalidException {
        Optional<User> user = getUserRepository().findUserByEmailAndPassword(new Email(email), password);
        return user;
    }

    @Override
    public void addNewUser(User user) {
        getUserRepository().save(user);
    }

    @Override
    public void deleteMyAccount(User user) {
        getUserRepository().delete(user);
    }

    @Override
    public void addExpense(User user, Expenditure expense, String categoryName) {
        expense.setUser(user);
        Category category = getCategoryRepository().addCategory(new Category(categoryName));
        expense.setCategory(category);
        getFinancialRepository().addExpense(expense);
    }

    @Override
    public void addIncome(User user, Income income, String categoryName) {
        income.setUser(user);
        Category category = getCategoryRepository().addCategory(new Category(categoryName));
        income.setCategory(category);
        getFinancialRepository().addIncome(income);
    }

    @Override
    public Long totalExpense(Long userId) {

        List<Expenditure> list = getFinancialRepository().getExpense(userId,null,null);
        Long amount=0L;
        for(Expenditure expenditure:list){
            amount +=expenditure.getAmount();
        }
        return amount;
    }

    @Override
    public Long totalIncome(Long userId) {
        List<Income> list = getFinancialRepository().getIncome(userId,null,null);
        Long amount=0L;
        for(Income income:list){
            amount +=income.getAmount();
        }
        return amount;
    }

    @Override
    public Long getExpense(Long userId, Date start, Date end) {
        List<Expenditure> list = getFinancialRepository().getExpense(userId,start,end);
        Long amount=0L;
        for(Expenditure expenditure:list){
            amount +=expenditure.getAmount();
        }
        return amount;
    }

    @Override
    public Long getIncome(Long userId, Date start, Date end) {
        List<Income> list = getFinancialRepository().getIncome(userId,start,end);
        Long amount=0L;
        for(Income income:list){
            amount +=income.getAmount();
        }
        return amount;
    }

    @Override
    public Long getExpenseUsingCategory(Long userId, String category, Date start, Date end) {
        return null;
    }
}
