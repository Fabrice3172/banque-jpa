package org.example.entites;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "COMPTE")
@Inheritance(strategy = InheritanceType.JOINED)
public class Compte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "NUMERO")
    private String numero;
    @Column(name = "SOLDE")
    private Double solde;

    @ManyToMany
    @JoinTable(name = "CLI_COMP",
            joinColumns = @JoinColumn(name = "ID_COMP", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "ID_CLI", referencedColumnName = "ID")
    )
    private Set<Client> clients;

    @OneToMany
    @JoinColumn(name = "ID")
    private Set<Operation> operations;


    public Compte() {

    }

    public Compte(String numero, Double solde) {
        this.numero = numero;
        this.solde = solde;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Double getSolde() {
        return solde;
    }

    public void setSolde(Double solde) {
        this.solde = solde;
    }

    public Set<Client> getClients() {
        return clients;
    }

    public void setClients(Set<Client> clients) {
        this.clients = clients;
    }

    public Set<Operation> getOperations() {
        return operations;
    }

    public void setOperations(Set<Operation> operations) {
        this.operations = operations;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Compte{" +
                "numero='" + numero + '\'' +
                ", solde=" + solde +
                '}';
    }

}
