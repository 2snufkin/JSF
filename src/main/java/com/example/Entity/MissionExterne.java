package com.example.Entity;

import javax.persistence.*;

@Entity

public  class MissionExterne extends Mission {
    @Column(name="email_facture")
    private String emailFacturation;
    @Column(name="taux_jour_moyene")
    private int tauxJournlierMoyen;


    public MissionExterne() {
    }

    public String getEmailFacturation() {
        return emailFacturation;
    }

    public void setEmailFacturation(String emailFacturation) {
        this.emailFacturation = emailFacturation;
    }

    public int getTauxJournlierMoyen() {
        return tauxJournlierMoyen;
    }

    public void setTauxJournlierMoyen(int tauxJournlierMoyen) {
        this.tauxJournlierMoyen = tauxJournlierMoyen;
    }
}
