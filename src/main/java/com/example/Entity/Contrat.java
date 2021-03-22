package com.example.Entity;

import com.example.Entity.Enum.TypeContrat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
public class Contrat implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="reference")
    private int id   ;
    private LocalDate date;
    private int salaire;
    @Enumerated(EnumType.STRING)
    @Column(name = "type_contrat")
    private TypeContrat typeContrat;
     @OneToOne (optional = true)
     private Employe employe;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getSalaire() {
        return salaire;
    }

    public void setSalaire(int salaire) {
        this.salaire = salaire;
    }

    public TypeContrat getTypeContrat() {
        return typeContrat;
    }

    public void setTypeContrat(TypeContrat typeContrat) {
        this.typeContrat = typeContrat;
    }

    public Employe getEmploye() {
        return employe;
    }

    public void setEmploye(Employe employe) {
        this.employe = employe;
    }
}
