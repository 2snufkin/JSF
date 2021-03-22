package com.example.Entity.PK;
import com.example.Entity.Employe;
import com.example.Entity.Mission;

import java.io.Serializable;


public class TimeSheetPK implements Serializable {
     private Employe employe ;
     private Mission mission ;

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
}
