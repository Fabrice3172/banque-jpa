package org.example.entites;

import jakarta.persistence.Embeddable;

@Embeddable
public class Adresse {
    private Integer numero;
    private String rue;
    private int codePostal;
    private String ville;
}
