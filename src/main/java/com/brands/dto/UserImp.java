package com.brands.dto;

import com.brands.dao.Cart;
import com.brands.dao.Users;
import com.brands.utils.ValidateUser;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

public class UserImp implements UserDto {
    Session session = MySessionFactory.getMySession();

    @Override
    public boolean addCredit(String code, Users user) {

        String hql = "select value from com.brands.dao.CreditAdding c where c.code=?";
        Query query = session.createQuery(hql).setParameter(0, code);

        Double value = (Double) query.uniqueResult();
        if (value != null) {
            //   if( user.getCreditLimit()!=null){
            Double valueTwo = user.getCreditLimit() + value;
            user.setCreditLimit(valueTwo);
            session.beginTransaction();
            session.update(user);
            session.getTransaction().commit();
            return true;


        } else {
            return false;
        }
    }

    @Override
    public boolean updateCreditWhenBuying(int user_id) {
        return false;
    }

    @Override
    public boolean addUser(Users user) {
        return false;
    }

    @Override
    public boolean updateUser(Users user) {
        return false;
    }

    @Override
    public Users getUserById(int id) {
        return null;
    }

    @Override
    public List<Users> getAllUsers() {
        return null;
    }

    @Override
    public boolean login(Users user) {
        if (!ValidateUser.isExist(user)) {

            return false;
        } else {

            user.setStatus("ONLINE");

            session.beginTransaction();
            if (user.getUserId() != null) {
                session.update(user);
                session.getTransaction().commit();
            }
            return true;
        }
    }

    @Override
    public boolean register(Users user, Cart cart) {
        if (!ValidateUser.isExist(user)) {

            return false;
        } else {

            session.beginTransaction();
            session.persist(cart);
            session.persist(user);
            session.getTransaction().commit();
            System.out.println("register here ");
            return true;
        }

    }

    @Override
    public boolean logOut(Users user) {
        if (!ValidateUser.isExist(user)) {

            return false;
        } else {

            user.setStatus("OFFLINE");

            session.beginTransaction();
            if (user.getUserId() != null) {
                session.update(user);
                session.getTransaction().commit();
            }
            return true;
        }
    }
}
