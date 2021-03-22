package com.example.Ejb;

import com.example.Entity.Departement;
import com.example.Entity.Employe;
import com.example.Entity.Mission;
import com.example.Entity.TimeSheet;
import com.example.Interface.TimeSheetable;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;

@Stateless
public class TimeSheetBean implements TimeSheetable {
    @PersistenceContext(unitName = "test-ejb")
    EntityManager em;

    /**
     * Add mission and return its Id
     * @param mission
     * @return int
     */
    @Override
    public int addMission(Mission mission) {
        em.persist(mission);
        return mission.getId();
    }

    /**
     * Assign Departement to a mission
     * @param missionID
     * @param depId
     */
    @Override
    public void assignDepartToMission(int missionID, int depId) {
        Mission mission = em.find(Mission.class, missionID);
        Departement dep =em.find(Departement.class, depId);
         mission.setDepartement(dep);
         em.persist(mission);
    }


    /**
     * Add timeSheet: the mission, the employee responsible for this mission, starting and ending date
     * @param missionId
     * @param employeeId
     * @param dateDebut
     * @param dateFin
     */
    @Override
    public void ajouterTimeSheet(int missionId, int employeeId, LocalDate dateDebut, LocalDate dateFin) {
        Mission mission = em.find(Mission.class, missionId);
        Employe employe = em.find(Employe.class, employeeId);
        TimeSheet timeSheet = new TimeSheet();
        timeSheet.setEmploye(employe);
        timeSheet.setMission(mission);
        timeSheet.setDateDebut(dateDebut);
        timeSheet.setDateFin(dateFin);
        em.persist(timeSheet);

    }

    public TimeSheetBean() {

    }
}
