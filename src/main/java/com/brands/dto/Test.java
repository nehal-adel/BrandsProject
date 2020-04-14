package com.brands.dto;

import com.brands.dao.Cart;
import com.brands.dao.CreditAdding;
import com.brands.dao.Users;
import org.hibernate.Session;

public class Test {

    static Session session = MySessionFactory.getMySession();
    public static void main(String[] args) {
        Cart cart = new Cart();
        session.beginTransaction();
        session.persist(cart);
        session.getTransaction().commit();

        Users user = new Users(cart, "shimaa", "pass", "SS@", 1);

        session.beginTransaction();
//        session.persist(cart);
        session.persist(user);

        session.getTransaction().commit();
        UserImp userImp = new UserImp();
        // user=(Users) session.get(Users.class,7);
//        if(!userImp.login(user)){
//            System.out.println("false");
//        }
        CreditAdding creditAdding = new CreditAdding("5005", 10000);
        session.beginTransaction();
        session.persist(creditAdding);
        session.getTransaction().commit();
        Users user1 = (Users) session.get(Users.class, 2);
        userImp.addCredit(creditAdding.getCode(), user1);
        // userImp.register(user,cart);
        System.out.println("done");
        session.close();
    }
}
