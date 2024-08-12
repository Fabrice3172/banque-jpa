package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.example.entites.*;
import org.hibernate.type.descriptor.java.LocalDateJavaType;

import java.sql.Array;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emFact = Persistence.createEntityManagerFactory("persitUnit");
        EntityManager em = emFact.createEntityManager();

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        //Ajout de deux clients à un compte
        String str = "1972-01-01";
        String str2 = "1982-12-24";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dateTime = LocalDate.parse(str, formatter);
        LocalDate dateTime2 = LocalDate.parse(str2, formatter);

        Client cl1 = new Client("UnNom", "UnPrenom",dateTime);
        Client cl2 = new Client("AutreNom", "AutrePrenom",dateTime2);

        Compte compte1 = new Compte("1234", 4567890.0);
        Compte compte2 = new Compte("21234", 24567890.0);

        Set<Compte> comptes2 = new HashSet<Compte>();
        comptes2.add(compte2);
        cl2.setComptes(comptes2);

        Set<Client> clients = new HashSet<Client>();
        clients.add(cl1);
        clients.add(cl2);
        compte1.setClients(clients);

        Banque b = new Banque();
        b.setNom("LaBanqueDuSud");
       // b.setClients(clients);
        cl1.setBanque(b);
        cl2.setBanque(b);

        em.persist(compte1);
        em.persist(compte2);
        em.persist(b);

        // Associer une assurance vie et un livret A au client cl1
        LivretA l1 = new LivretA();
        l1.setNumero("1234LA");
        l1.setTaux(5);
        l1.setSolde(10000.0);

        em.persist(l1);

        AssuranceVie av1 = new AssuranceVie();
        av1.setNumero("1234AV");
        av1.setTaux(10);
        av1.setSolde(15000.0);
        String str3 = "2050-12-24";
        LocalDate dateTime3 = LocalDate.parse(str3, formatter);
        av1.setDateFin(dateTime3);

        em.persist(av1);

        Set<Compte> comptes = new HashSet<Compte>();
        comptes.add(l1);
        comptes.add(av1);
        cl1.setComptes(comptes);
        Adresse addA = new Adresse();
        addA.setRue("Midi");
        addA.setCodePostal(31400);
        addA.setNumero(41);
        addA.setVille("ToLoose");
        cl1.setAdresse(addA);

        Adresse addB = new Adresse();
        addB.setRue("Minuit");
        addB.setCodePostal(34000);
        addB.setNumero(14);
        addB.setVille("MonPellier");
        cl2.setAdresse(addB);

        //em.persist(cl1);

        // Insérer un virement dans un compte du client cl2
        String str4 = "2024-12-24";
        LocalDate dateTime4 = LocalDate.parse(str4, formatter);
        Virement v1 = new Virement();
        v1.setBeneficiaire("Client2");
        v1.setDate(dateTime4.atStartOfDay());
        v1.setMontant(4000.0);
        v1.setMotif("Loyer");

        v1.setCompte(compte2);

        em.persist(v1);

        // Insérer une opération de débit sur le compte1
        Operation ope2 = new Operation();
        ope2.setDate(dateTime4.atStartOfDay());
        ope2.setMontant(4000.0);
        ope2.setMotif("Débit");
        ope2.setCompte(compte1);

        em.persist(ope2);

        em.persist(cl1);
        em.persist(cl2);

        transaction.commit();

        //l1 = (LivretA) em.find(Compte.class, 2);
        //av1 = (AssuranceVie) em.find(Compte.class, 3);
        //v1 = (Virement) em.find(Operation.class, 4);

        em.close();
        emFact.close();
    }
}