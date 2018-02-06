/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.entites;

import java.net.URL;
import Utils.EtatDemandeAjoutGarderie;
/**
 *
 * @author PC
 */
public class DemandeAjoutGarderie {
    private int id;
    private String preuve;
    private String preuve2;
    private EtatDemandeAjoutGarderie etat;
    private int id_user;
    private int id_egc;
    
    public DemandeAjoutGarderie(){}
    public DemandeAjoutGarderie(int id, String preuve, String preuve2, EtatDemandeAjoutGarderie etat, int id_user,int id_egc) {
        this.id = id;
        this.preuve = preuve;
        this.preuve2 = preuve2;
        this.etat = etat;
        this.id_user = id_user;
        this.id_egc=id_egc;
    }

    public int getId() {
        return id;
    }

    public String getPreuve() {
        return preuve;
    }

    public String getPreuve2() {
        return preuve2;
    }

    public EtatDemandeAjoutGarderie getEtat() {
        return etat;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPreuve(String preuve) {
        this.preuve = preuve;
    }

    public void setPreuve2(String preuve2) {
        this.preuve2 = preuve2;
    }

    public void setEtat(EtatDemandeAjoutGarderie etat) {
        this.etat = etat;
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
        return "DemandeAjoutGarderie{" + "id=" + id + ", preuve=" + preuve + ", preuve2=" + preuve2 + ", etat=" + etat + ", id_user=" + id_user + ", id_egc=" + id_egc + '}';
    }

    
    
    
}
