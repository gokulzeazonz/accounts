package com.zeazonz.infrastructure.repository.impl.financial;

import com.zeazonz.domain.model.financial.Expenditure;
import com.zeazonz.domain.model.financial.FinancialRepository;
import com.zeazonz.domain.model.financial.Income;
import com.zeazonz.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FinancialRepositoryImpl implements FinancialRepository {

    private SessionFactory sessionFactory;

    private Session getSession(){
        return sessionFactory.openSession();
    }

    public FinancialRepositoryImpl(){
        sessionFactory = HibernateUtils.getSessionFactory();
    }

    @Override
    public void addExpense(Expenditure expenditure) {
        Session session = getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Long id;
            id = (Long) session.save(expenditure);
            transaction.commit();
            expenditure.setId(id);
            session.close();
        }catch (Exception e){
            if(transaction!=null){
                transaction.rollback();
            }
        }
        if(session!=null){
            session.close();
        }
    }

    @Override
    public void addIncome(Income income) {
        Session session = getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Long id;
            id = (Long) session.save(income);
            transaction.commit();
            session.close();
            income.setId(id);
        }catch (Exception e){
            if(transaction!=null){
                transaction.rollback();
            }
        }
        if(session!=null){
            session.close();
        }
    }

    @Override
    public List<Expenditure> getExpense(Long userId, Date start, Date end) {
        List<Expenditure> list = new ArrayList<>();
        Session session = getSession();
        try {
            Query query;
            if(start==null||end==null){
                query = session.createQuery("FROM com.zeazonz.domain.model.financial.Expenditure AS e WHERE e.user.id=?1");
                query.setParameter(1,userId);
            }else {
                query = session.createQuery("FROM com.zeazonz.domain.model.financial.Expenditure AS e " +
                        "WHERE e.user.id=?1 AND e.date<=?2 AND e.date>=?3");
                query.setParameter(1, userId);
                query.setParameter(2, end);
                query.setParameter(3, start);
            }
            list = query.getResultList();

        }catch (Exception e){
            e.printStackTrace();
        }
        if(session!=null){
            session.close();
        }
        return list;
    }

    @Override
    public List<Income> getIncome(Long userId, Date start, Date end) {
        List<Income> list = new ArrayList<>();
        Session session = getSession();
        try {
            Query query;
            if(start==null||end==null){
                query = session.createQuery("FROM com.zeazonz.domain.model.financial.Income AS i WHERE i.user.id=?1");
                query.setParameter(1,userId);
            }else {
                query = session.createQuery("FROM com.zeazonz.domain.model.financial.Income AS i " +
                        "WHERE i.user.id=?1 AND i.date<=?2 and i.date>=?3");
                query.setParameter(1, userId);
                query.setParameter(2, end);
                query.setParameter(3, start);
            }
            list = query.getResultList();

        }catch (Exception e){
            e.printStackTrace();
        }
        if(session!=null){
            session.close();
        }
        return list;
    }
}
