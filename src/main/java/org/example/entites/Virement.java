package org.example.entites;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "VIREMENT")
public class Virement extends Operation {

    @Column(name = "BENEFICIAIRE")
    private String beneficiaire;

    public Virement() {
    }

    public Virement(int ID, String beneficiaire) {
        this.beneficiaire = beneficiaire;
    }

    public Virement(int id, LocalDateTime date, double montant, String motif, Compte compte, int ID, String beneficiaire) {
        super(id, date, montant, motif, compte);
        this.beneficiaire = beneficiaire;
    }

    public String getBeneficiaire() {
        return beneficiaire;
    }

    public void setBeneficiaire(String beneficiaire) {
        this.beneficiaire = beneficiaire;
    }

    @Override
    public String toString() {
        return "Virement{" +
                ", beneficiaire='" + beneficiaire + '\'' +
                '}';
    }
}
