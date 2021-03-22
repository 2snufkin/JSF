package com.example.Interface;
import com.example.Entity.Departement;
import com.example.Entity.Entreprise;

import javax.ejb.Local;
import java.util.List;

@Local
public interface Entreprisable {
    public int addEntreprise(Entreprise entreprise);
    public int addDepartment(Departement department);
    public void assignDepartment(int departId, int entrepriseId);
     public List<String> getAllDepertmentsByEntrpriseId(int entrpriseId);


}
