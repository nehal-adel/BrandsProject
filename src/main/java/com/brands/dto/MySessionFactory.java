package com.brands.dto;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class MySessionFactory {
    
    static Session session = null;

    private static SessionFactory sessionFactory = null;
     
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            // loads configuration and mappings
            Configuration configuration = new Configuration().configure();
            ServiceRegistry serviceRegistry
                = (ServiceRegistry) new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();
             
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);           
        }
         
        return sessionFactory;
    }
    public static Session getMySession() {
        sessionFactory = getSessionFactory();
        if(session == null){
         session = sessionFactory.openSession();
        }
        return session ;
    }
    
}