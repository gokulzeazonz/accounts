package com.zeazonz.utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
    private static Configuration configuration;
    private static StandardServiceRegistry serviceRegistry;
    private static SessionFactory sessionFactory;

    static {
        try {
            serviceRegistry = new StandardServiceRegistryBuilder()
                    .configure().build();
            MetadataSources metadataSources = new MetadataSources(serviceRegistry);
            configuration = new Configuration(metadataSources);
        } catch (RuntimeException e) {
            e.printStackTrace();
            if (serviceRegistry != null) {
                StandardServiceRegistryBuilder.destroy(serviceRegistry);
            }
        }
    }

    public static SessionFactory getSessionFactory(Class<?>[] classes) {
        if (sessionFactory == null) {
            for(Class<?> classs:classes){
                configuration.addAnnotatedClass(classs);
            }
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        }
        return sessionFactory;
    }
}
