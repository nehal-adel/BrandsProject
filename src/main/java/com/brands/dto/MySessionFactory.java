/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brands.dto;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MySessionFactory {
    
    static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
    
    static Session session = null;

    public static Session getMySession() {
        if(session == null){
         session = sessionFactory.openSession();
        }
        return session ;
    }
    
}
