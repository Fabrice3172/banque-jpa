package org.example.entites;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "OPERATION")
public class Operation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private int id;

    @Column(name = "DATE")
    private LocalDateTime date;
    @Column(name = "MONTANT")
    private double montant;
    @Column(name = "MOTIF")
    private String motif;

    @ManyToOne
    @JoinColumn(name = "ID_COMP")
    private Compte compte;



    public Operation() {
        compte = new Compte();
    }

    public Operation(int id, LocalDateTime date, double montant, String motif, Compte compte) {
        this.id = id;
        this.date = date;
        this.montant = montant;
        this.motif = motif;
        this.compte = compte;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    @Override
    public String toString() {
        return "Operation{" +
                "date=" + date +
                ", montant=" + montant +
                ", motif='" + motif + '\'' +
                '}';
    }
}
