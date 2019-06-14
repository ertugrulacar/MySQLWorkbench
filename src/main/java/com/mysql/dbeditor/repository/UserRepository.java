package com.mysql.dbeditor.repository;

import com.mysql.dbeditor.entity.User;
import com.mysql.dbeditor.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class UserRepository {
    public static boolean findByEmailAndPassword(String email, String password){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("from User where email= :email and password= :password");
        query.setParameter("email", email);
        query.setParameter("password", password);
        List<User> users = query.list();
        session.close();
        return  !users.isEmpty();
    }
}
