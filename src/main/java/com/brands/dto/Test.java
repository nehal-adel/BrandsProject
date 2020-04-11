package com.brands.dto;

import com.brands.dao.Cart;
import com.brands.dao.Users;
import org.hibernate.Session;

public class Test {

    static Session session = MySessionFactory.getMySession();
    public static void main(String[] args) {
        Cart cart = new Cart(1) ;
        Users user =new Users(cart, "nehal", "hello", "hi@nn.cc", 0);
        session.beginTransaction();
        session.persist(user);
        session.getTransaction().commit();
        System.out.println("done");
    }
}
