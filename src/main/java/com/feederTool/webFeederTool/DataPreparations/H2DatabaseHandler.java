package com.feederTool.webFeederTool.DataPreparations;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


// the class contains an overloaded method which helps to execute queries on the db

public class H2DatabaseHandler {

    public static void H2DatabaseInput(String SqlQuery, String parameterOne ){
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("tool");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Query query = em.createNativeQuery(SqlQuery);
        query.setParameter(1, parameterOne.toString());
        query.executeUpdate();
        em.getTransaction().commit();
        em.close();

    }
    public static void H2DatabaseInput(String SqlQuery){
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("tool");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Query query = em.createNativeQuery(SqlQuery);
//        query.setParameter();
        query.executeUpdate();
        em.getTransaction().commit();
        em.close();

    }


}
