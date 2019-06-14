package com.mysql.dbeditor.repository;

import com.mysql.dbeditor.entity.ServerInfo;
import com.mysql.dbeditor.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class ServerInfoRepository {
   /* public static ServerInfo findServerInfosById(int id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("from ServerInfo where id= :id");
        query.setParameter("id", id);
        List<ServerInfo> serverInfos = query.list();
        session.close();
        return serverInfos.get(0);
    }*/
}
