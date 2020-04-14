package com.brands.utils;

import com.brands.dao.Users;
import com.brands.dto.MySessionFactory;

import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

public class ValidateUser {
    public static boolean isExist(Users user) {
        Session session = MySessionFactory.getMySession();
        if (user != null) {
            String hql = "from com.brands.dao.Users c where c.id=?";
            Query query = session.createQuery(hql).setParameter(0, user.getUserId());

            List<Users> listUser = query.list();
            if (listUser != null) {

                System.out.println(listUser);
                return true;


            }
        }
        return false;
    }

}
