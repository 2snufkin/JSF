package com.example.Ejb;

import com.example.Entity.Contrat;
import com.example.Entity.Departement;
import com.example.Entity.Employe;
import com.example.Interface.Employable;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class EmployeBean implements Employable  {
    @PersistenceContext(unitName = "test-ejb")
    EntityManager em;

    /**
     * Add employe to the DB and return his ID
     * @param employe
     * @return employe ID
     */
    public int addEmploye(Employe employe) {
        em.persist(employe);
        em.flush();
        return employe.getId();
    }

    /**
     * Add employe to a department. It put both of them in the Join Table
     * @param employeId
     * @param depId
     */

    @Override
    public void assignToDepartment(int employeId, int depId) {
        Employe employe = em.find(Employe.class, employeId);
        Departement dept = em.find(Departement.class, depId);
        employe.setDepartements(new ArrayList<>());
        employe.getDepartements().add(dept);
        em.persist(employe);
        em.persist(dept);
    }



    /**
     * Add a new Contract to the DB
     * @param contrat
     * @return The contract Id which is its Reference Column as int
     */
    @Override
    public int addContrat(Contrat contrat) {
         em.persist(contrat);
         return contrat.getId();
    }

    /**
     * Assign an employe to a contract type
     * @param contractId
     * @param employeId
     */
    @Override
    public void assignContract(int contractId, int employeId) {
        Contrat contrat = em.find(Contrat.class, contractId);
        Employe employe = em.find(Employe.class, employeId);
        contrat.setEmploye(employe);
        em.persist(contrat);
     }

    /**
     * By being given the ID - it will return the employe's name
     * @param employeId
     * @return The employe's Name as a String
     */

    @Override
    public String getNamebyId(int employeId) {
        Employe employe = em.find(Employe.class, employeId);
        return employe.getNom();
    }

    /**
     *
     * @return the number of Employes as a long
     */
    @Override
    public long getEmployeNumber() {
        String jpql = "SELECT COUNT (e) FROM Employe e";
        TypedQuery<Long> query = em.createQuery(jpql, Long.class);//creation
        long sum = query.getSingleResult();//excute
        return sum;
    }

    /**
     *
     * @return A list<String>  of all the Employes
     */

    @Override
    public List<String> getAlltheNames() {
        String jpql = "SELECT e.nom FROM Employe e";
        TypedQuery<String> query = em.createQuery(jpql,String.class);
        List<String> list = query.getResultList();
        return list;
    }
    public int savEmploye(Employe employe) {
        System.out.println("starting add action");
        em.persist(employe);
        int id = employe.getId();
        System.out.println("add has been finished");

        return id;
    }

    public void removeemploye(int id) {
        System.out.println("starting remove");
        Employe delete = em.find(Employe.class, id);
        em.remove(delete);
        System.out.println("remove has been finished");

    }

    public void updateemploye(Employe employeNewValues) {
        System.out.println("starting update");
        Employe employe = em.find(Employe.class, employeNewValues.getId());
        employe.setEmail(employeNewValues.getEmail());
    }

    public Employe findemployeByid (int id) {
        System.out.println("searching for the employe");
        Employe search = em.find(Employe.class, id);
        if (search == null) System.out.println("well. r u sure that it's exist in your DB?");
        return search;

    }


    public Employe finByLoginPassword(String login, String password) {

        String jql = "SELECT e FROM Employe  e where e.email= :log AND e.password = :pass";
        TypedQuery<Employe> query = em.createQuery(jql, Employe.class);
        query.setParameter( "log",login);
        query.setParameter( "pass",password);

        return query.getSingleResult();

    }
    public EmployeBean() {
    }


}
