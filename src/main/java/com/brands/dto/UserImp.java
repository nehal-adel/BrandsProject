package com.brands.dto;

import com.brands.dao.Cart;
import com.brands.dao.Products;
import com.brands.dao.Users;
import com.brands.utils.ValidateUser;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;
import java.util.Set;

public class UserImp implements UserDto {
    Session session = MySessionFactory.getMySession();

    @Override
    public boolean addCredit(String code, Users user) {

        String hql = "select value from com.brands.dao.CreditAdding c where c.code=?";
        Query query = session.createQuery(hql).setParameter(0, code);

        Double value = (Double) query.uniqueResult();
        if (value != null) {
            if (user.getCreditLimit() != null) {
                Double valueTwo = user.getCreditLimit() + value;
                user.setCreditLimit(valueTwo);
                session.beginTransaction();
                session.update(user);
                session.getTransaction().commit();
                return true;
            } else {
                user.setCreditLimit(value);
                session.beginTransaction();
                session.update(user);
                session.getTransaction().commit();

                return true;
            }

        } else {
            return false;
        }
    }

    @Override
    public boolean updateCreditWhenBuying(Users user) {
        String hql = "select cart from com.brands.dao.Users c where c.userId=?";

        Query query = session.createQuery(hql).setParameter(0, user.getUserId());
        Cart cart = (Cart) query.uniqueResult();

        if (cart != null) {
            Set<Products> products = cart.getProductses();
            Double sum = 0.0;
            Double amount = user.getCreditLimit();
            for (Products aproducts : products) {
                sum += aproducts.getPrice() * aproducts.getQuantity();

            }
            amount -= sum;
            if (amount < 0) {
                return false;
            } else {
                System.out.println(sum);
                session.beginTransaction();
                user.setCreditLimit(amount);
                session.update(user);
                session.getTransaction().commit();

                return true;
            }
        }

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

    public boolean loginNour(String EMail, String passwrod) {
        String hql = "from com.brands.dao.Users c where c.EMail=? and c.password=?";

        Query query = session.createQuery(hql);
        query.setString(0, EMail);
        query.setString(1, passwrod);

        List<Users> value = query.list();
        if (value != null && value.size() > 0) {
            Users user = value.get(0);
            user.setStatus("ONLINE");

            System.out.println(user);
            session.beginTransaction();
            session.update(user);
            session.getTransaction().commit();
            return true;
        }
        return false;

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
