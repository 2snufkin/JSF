

package com.example.BackBean;

import com.example.Ejb.EmployeBean;
import com.example.Entity.Employe;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped
public class LoginBean implements Serializable {
    private static final long serialVersionUID =1L;
    private String login;
    private String password;

    private Employe employe;



     EmployeBean employeBean;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Employe getEmploye() {
        return employe;
    }

    public void setEmploye(Employe employe) {
        this.employe = employe;
    }

    public EmployeBean getEmployeBean() {
        return employeBean;
    }

    public void setEmployeBean(EmployeBean employeBean) {
        this.employeBean = employeBean;
    }

    public String logMe(){


        return  (login!=null) ?  "yes" :  "no";



    }

}
