package com.brands.dto;

import com.brands.dao.Cart;
import com.brands.dao.Products;
import com.brands.dao.Users;
import org.hibernate.Session;

public class Test {

    static Session session = MySessionFactory.getMySession();
    public static void main(String[] args) {
        Cart cart = new Cart();
        session.beginTransaction();
        session.persist(cart);
        session.getTransaction().commit();

        Users user = new Users(cart, "nour", "pass", "nourrr@", 1);

        session.beginTransaction();
//       session.persist(cart);
//        session.persist(user);

        session.getTransaction().commit();
        UserImp userImp = new UserImp();
        // user=(Users) session.get(Users.class,7);
//        if(!userImp.login(user)){
//            System.out.println("false");
//        }
//        CreditAdding creditAdding = new CreditAdding("501010x", 1500);
//        session.beginTransaction();
//        session.persist(creditAdding);
//        session.getTransaction().commit();
//        Users user1 = (Users) session.get(Users.class, 3);
        Users user2 = (Users) session.get(Users.class, 9);
//        userImp.addCredit(creditAdding.getCode(), user2);
//         userImp.register(user,cart);
//        System.out.println("done");

//        Products products = new Products(2, user1.getCart(), user1, 2, 500);
//        session.beginTransaction();
//        session.persist(products);
//        session.getTransaction().commit();
//        userImp.updateCreditWhenBuying(user1);
//        System.out.println("done");
        Products products = new Products(2, user2.getCart(), user2, 2, 1000);
        session.beginTransaction();
        session.persist(products);
        session.getTransaction().commit();
        userImp.updateCreditWhenBuying(user2);
        System.out.println("done");


    }
}
