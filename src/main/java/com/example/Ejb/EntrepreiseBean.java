package com.example.Ejb;

import com.example.Entity.Departement;
import com.example.Entity.Entreprise;
import com.example.Interface.Entreprisable;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless(name = "EntrepreiseBean")
public class EntrepreiseBean implements Entreprisable {
    @PersistenceContext(unitName = "test-ejb")
    EntityManager em;

    public EntrepreiseBean() {
    }

    /**
     * Add Entrprise to the DB
     *
     * @param entreprise: object
     * @return the Entrprise ID as an int
     */
    @Override
    public int addEntreprise(Entreprise entreprise) {
        System.out.println("check");
        em.persist(entreprise);
        return entreprise.getId();
    }

    /**
     * Add Entrprise to the DB
     *
     * @param department:object
     * @return the entreprise ID
     */

    @Override
    public int addDepartment(Departement department) {
        em.persist(department);
        return department.getId();

    }

    /**
     *
     * @param departId: the id of the departement
     * @param entrepriseId: the id of the entrepreise
     */
    @Override
    public void assignDepartment(int departId, int entrepriseId) {
        Departement dept = em.find(Departement.class, departId);
        Entreprise ent = em.find(Entreprise.class, entrepriseId);
        dept.setEntreprise(ent);
        em.persist(dept);
     }

    /**
     * Given an Id of a certain Entreprise it will return a list of the the Deprtements
     *
     * @param entrpriseId
     * @return a List<String>
     */
    @Override
    public List<String> getAllDepertmentsByEntrpriseId(int entrpriseId) {
        Entreprise entrprise = em.find(Entreprise.class, entrpriseId);
        String jql = "SELECT d.name FROM Departement d where d.entreprise = :ent";
        TypedQuery<String> query = em.createQuery(jql, String.class);
        query.setParameter( "ent",entrprise);
        List<String> dpartmentNames = query.getResultList();
        return dpartmentNames;
    }
}
