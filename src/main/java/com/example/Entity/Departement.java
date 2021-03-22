package com.example.Entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Departement implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @ManyToOne
    private Entreprise entreprise;
    @ManyToMany(mappedBy = "departements", cascade = CascadeType.PERSIST)
    private List<Employe> employeList;
    @OneToMany(mappedBy = "departement")
    private List<Mission> mission;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Entreprise getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(Entreprise entreprise) {
        this.entreprise = entreprise;
    }

    public List<Employe> getEmployeList() {
        return employeList;
    }

    public void setEmployeList(List<Employe> employeList) {
        this.employeList = employeList;
    }

    public List<Mission> getMission() {
        return mission;
    }

    public void setMission(List<Mission> mission) {
        this.mission = mission;
    }
}
