package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {


        EntityManagerFactory emFact = Persistence.createEntityManagerFactory("persitUnit");
        EntityManager em = emFact.createEntityManager();


        em.close();
        emFact.close();
    }
}