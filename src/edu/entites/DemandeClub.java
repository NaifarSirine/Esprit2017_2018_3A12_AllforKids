/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.entites;

import Utils.EtatDemandeAjout;
import Utils.EtatDemandeAjout;

/**
 *
 * @author hamma
 */
public class DemandeClub {
    private int id ; 
    private String preuve1 ; 
    private String preuve2 ; 
    private EtatDemandeAjout etat ; 
       private int id_user ; 
    private int id_egc ; 

    public DemandeClub(int id, String preuve1, String preuve2, EtatDemandeAjout etat, int id_user, int id_egc) {
        this.id = id;
        this.preuve1 = preuve1;
        this.preuve2 = preuve2;
        this.etat = etat;
        this.id_user = id_user;
        this.id_egc = id_egc;
    }

    public DemandeClub() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPreuve1() {
        return preuve1;
    }

    public void setPreuve1(String preuve1) {
        this.preuve1 = preuve1;
    }

    public String getPreuve2() {
        return preuve2;
    }

    public void setPreuve2(String preuve2) {
        this.preuve2 = preuve2;
    }

    public EtatDemandeAjout getEtat() {
        return etat;
    }

    public void setEtat(EtatDemandeAjout etat) {
        this.etat = etat;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getId_egc() {
        return id_egc;
    }

    public void setId_egc(int id_egc) {
        this.id_egc = id_egc;
    }

    @Override
    public String toString() {
        return "DemandeClub{" + "id=" + id + ", preuve1=" + preuve1 + ", preuve2=" + preuve2 + ", etat=" + etat + ", id_user=" + id_user + ", id_egc=" + id_egc + '}';
    }
    
}
