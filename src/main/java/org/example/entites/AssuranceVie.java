package org.example.entites;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "ASSURANCEVIE")
public class AssuranceVie extends Compte {

    @Column(name = "DATEFIN")
    private LocalDate dateFin;

    @Column(name = "TAUX")
    private double taux;


    public AssuranceVie() {
    }

    public AssuranceVie(int ID, LocalDate dateFin, double taux) {
        this.dateFin = dateFin;
        this.taux = taux;
    }

    public AssuranceVie(String numero, Double solde, int ID, LocalDate dateFin, double taux) {
        super(numero, solde);
        this.dateFin = dateFin;
        this.taux = taux;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    public double getTaux() {
        return taux;
    }

    public void setTaux(double taux) {
        this.taux = taux;
    }

    @Override
    public String toString() {
        return "AssuranceVie{" +
                ", dateFin=" + dateFin +
                '}';
    }
}
