package com.zeazonz.domain.model.financial;

import java.util.Date;
import java.util.List;

public interface FinancialRepository {
    void addExpense(Expenditure expenditure);
    void addIncome(Income income);

    //if date is null - getall
    List<Expenditure> getExpense(Long userId,Date start,Date end);
    List<Income> getIncome(Long userId,Date start,Date end);


}
