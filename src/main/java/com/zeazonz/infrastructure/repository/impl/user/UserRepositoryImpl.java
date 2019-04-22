package com.zeazonz.infrastructure.repository.impl.user;

import com.zeazonz.domain.model.user.Email;
import com.zeazonz.domain.model.user.User;
import com.zeazonz.domain.model.user.UserRepository;
import com.zeazonz.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.StoredProcedureQuery;
import java.util.Optional;

public class UserRepositoryImpl implements UserRepository {

    private SessionFactory sessionFactory;

    private Session getSession(){
        return sessionFactory.openSession();
    }

    public UserRepositoryImpl(){
        sessionFactory = HibernateUtils.getSessionFactory();
    }

    @Override
    public void save(User persisted) {
        Session session = getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Long id;
            id = (Long) session.save(persisted);
            transaction.commit();
            persisted.setId(id);
            session.close();
        }catch (Exception e){
            e.printStackTrace();
            if(transaction!=null){
                transaction.rollback();
            }
        }
        if(session!=null){
            session.close();
        }
    }

    @Override
    public Optional<User> findUserByEmailAndPassword(Email email, String password) {
        Session session = getSession();
        try {
            StoredProcedureQuery query = session.createStoredProcedureQuery("From com.zeazonz.domain.model.user.User where email=? and password=?");
            query.setParameter(1,email.getEmail());
            query.setParameter(2,password);
            User user = (User) query.getSingleResult();
            if (user!=null)
                return Optional.of(user);
        }catch (Exception e){
            e.printStackTrace();
        }
        if(session!=null){
            session.close();
        }
        return Optional.empty();
    }

    @Override
    public void delete(User user) {
        Session session = getSession();
        Transaction transaction = null;
        try{
            transaction = session.beginTransaction();
            session.delete(user);
            transaction.commit();
        }catch (Exception e){
            if(transaction!=null){
                transaction.rollback();
            }
        }
        if(session!=null){
            session.close();
        }

    }
}
