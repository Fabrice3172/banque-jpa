package org.example.entites;

import jakarta.persistence.*;

@Entity
@Table(name = "LIVRETA")
public class LivretA extends Compte {

    @Column(name = "TAUX")
    private double taux;

    public LivretA() {
    }

    public LivretA(int id, double taux) {
        this.taux = taux;
    }

    public LivretA(String numero, Double solde, int id, double taux) {
        super(numero, solde);
        this.taux = taux;
    }

    public double getTaux() {
        return taux;
    }

    public void setTaux(double taux) {
        this.taux = taux;
    }

    @Override
    public String toString() {
        return "LivretA{" +
                "taux=" + taux +
                '}';
    }
}
