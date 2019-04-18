package com.zeazonz.infrastructure.repository.impl.financial;

import com.zeazonz.domain.model.financial.Expenditure;
import com.zeazonz.domain.model.financial.FinancialRepository;
import com.zeazonz.domain.model.financial.Income;

import java.util.Date;
import java.util.List;

public class FinancialRepositoryImpl implements FinancialRepository {
    @Override
    public void addExpense(Expenditure expenditure) {

    }

    @Override
    public void addIncome(Income income) {

    }

    @Override
    public List<Expenditure> getExpense(Long userId, Date start, Date end) {
        return null;
    }

    @Override
    public List<Income> getIncome(Long userId, Date start, Date end) {
        return null;
    }
}
