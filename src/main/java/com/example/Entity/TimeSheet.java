package com.example.Entity;

import com.example.Entity.Enum.IsValide;
import com.example.Entity.PK.TimeSheetPK;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@IdClass(TimeSheetPK.class)
@Table(name = "employe_mission")
public class TimeSheet implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @ManyToOne
    @JoinColumn  (name="employe_id")
    private Employe employe;
    @Id
    @ManyToOne
    @JoinColumn(name="mission_id")
    private Mission mission;

    private LocalDate dateDebut;
    private LocalDate dateFin;
    @Enumerated(EnumType.STRING)
    private IsValide isValide;

    public Employe getEmploye() {
        return employe;
    }

    public void setEmploye(Employe employe) {
        this.employe = employe;
    }

    public Mission getMission() {
        return mission;
    }

    public void setMission(Mission mission) {
        this.mission = mission;
    }

    public LocalDate getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    public IsValide getIsValide() {
        return isValide;
    }

    public void setIsValide(IsValide isValide) {
        this.isValide = isValide;
    }
}
