package com.mysql.dbeditor.entity;

import com.mysql.dbeditor.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.HashSet;
import java.util.Set;

public class DbInserter {
    public  static void insertUsers(){
        Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        ServerInfo serverInfo = new ServerInfo("asd", "sda", "asdsa", "sda");
        Set<ServerInfo> etoSet= new HashSet<>();
        etoSet.add(serverInfo);
        User user = new  User("Ertugrul", "Acar", "ertugrulacar@hotmail.com", "12345", etoSet);
        User user2 = new  User("Kadir", "Aydemir", "kadiraydemir@hotmail.com", "12345", null);
        session.save(user);
        session.save(user2);
        transaction.commit();
        session.close();
    }
}
