package com.example.Entity;

import com.example.Entity.Enum.IsActive;
import com.example.Entity.Enum.Role;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

;

@Entity
public class Employe  implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String prenom;
    private String nom;
    private String email;
    private String password;
    @Enumerated
    @Column(name="is_active")
    private IsActive isActive;
    @Enumerated(EnumType.STRING)
    private Role role;
    @OneToOne(mappedBy = "employe")
    private Contrat contract;
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name="departement_employe")
    private List<Departement> departements ;
    @OneToMany(mappedBy = "employe")
    private List<TimeSheet> timesheet;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public IsActive getIsActive() {
        return isActive;
    }

    public void setIsActive(IsActive isActive) {
        this.isActive = isActive;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Contrat getContract() {
        return contract;
    }

    public void setContract(Contrat contract) {
        this.contract = contract;
    }

    public List<Departement> getDepartements() {
        return departements;
    }

    public void setDepartements(List<Departement> departements) {
        this.departements = departements;
    }

    public List<TimeSheet> getTimesheet() {
        return timesheet;
    }

    public void setTimesheet(List<TimeSheet> timesheet) {
        this.timesheet = timesheet;
    }

}
