package com.zeazonz.infrastructure.repository.impl.category;

import com.zeazonz.domain.model.category.Category;
import com.zeazonz.domain.model.category.CategoryRepository;
import com.zeazonz.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.Query;
import java.util.Optional;

public class CategoryRepositoryImpl implements CategoryRepository {

    private SessionFactory sessionFactory;

    private Session getSession(){
        return sessionFactory.openSession();
    }

    public CategoryRepositoryImpl(){
        this.sessionFactory = HibernateUtils.getSessionFactory();
    }

    @Override
    public Category addCategory(Category category) {
        Session session = getSession();
        session.beginTransaction();

        Optional<Category> category1 = getCategory(category.getName());
        Long id;
        if(category1.isPresent()) {
            id = category1.get().getId();
        }else{
            id = (Long) session.save(category);
        }
        session.getTransaction().commit();
        session.close();
        category.setId(id);

        return category;
    }

    @Override
    public Optional<Category> getCategory(Long id) {

        Session session = getSession();
        Category category = session.get(Category.class,id);
        if(category == null)
            return Optional.empty();
        return Optional.of(category);
    }



    @Override
    public Optional<Category> getCategory(String name) {
        Session session = getSession();
        try {
            Query query = session.createQuery("From com.zeazonz.domain.model.category.Category where name=?1");
            query.setParameter(1,name);

            Category category = (Category) query.getSingleResult();
            if (category!=null)
                return Optional.of(category);
        }catch (Exception e){
            e.printStackTrace();
        }
        if(session!=null){
            session.close();
        }
        return Optional.empty();
    }

    @Override
    public Long getCategoryId(String name) {
        Optional<Category> category = getCategory(name);
        return category.map(Category::getId).orElse(null);
    }
}
