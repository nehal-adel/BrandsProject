package com.brands.dto;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class MySessionFactory {
    static Session session = null;
    static SessionFactory sessionFactory = null;

    public static void configuration() {
        Configuration con = new Configuration();
//        con.setListener("save", new UserListener());
        con.configure();
        sessionFactory = con.buildSessionFactory();
    }

    public static Session getMySession() {
        configuration();
        if (session == null) {
            session = sessionFactory.openSession();
        }
        return session;
    }

}