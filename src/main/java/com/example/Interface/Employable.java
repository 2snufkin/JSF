package com.example.Interface;
import com.example.Entity.Contrat;
import com.example.Entity.Employe;

import javax.ejb.Local;
import java.util.List;

@Local
public interface Employable  {
    public int addEmploye(Employe employe);
    public void assignToDepartment(int employeId, int depId);
    public int addContrat(Contrat contrat);
    public void assignContract(int contractId, int employeId);
    public String  getNamebyId(int employeId);
    public long getEmployeNumber();
    public List<String> getAlltheNames();
    int savEmploye(Employe employe);
    void removeemploye(int id);
    void updateemploye(Employe employeNewValues);
    Employe findemployeByid (int id);
}
