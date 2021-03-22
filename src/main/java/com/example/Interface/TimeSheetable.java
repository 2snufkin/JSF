package com.example.Interface;

import com.example.Entity.Mission;

import javax.ejb.Local;
import java.time.LocalDate;

@Local
public interface TimeSheetable {
    public int addMission(Mission mission);
     public void assignDepartToMission(int mission, int depId);
     public void ajouterTimeSheet (int missionId, int employeeId, LocalDate dateDebut, LocalDate dateFin);



}
