/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.entites;

/**
 *
 * @author windows
 */
public class DemandeEcole {
    
    int id;
   String preuve1;
   String preuve2;
   String etat;
   int id_user;
      int id_egc;

    public DemandeEcole(int id, String preuve1, String preuve2, String etat, int id_user, int id_egc) {
        this.id = id;
        this.preuve1 = preuve1;
        this.preuve2 = preuve2;
        this.etat = etat;
        this.id_user = id_user;
        this.id_egc = id_egc;
    }

    public DemandeEcole(int id, String preuve1, String preuve2, String etat) {
        this.id = id;
        this.preuve1 = preuve1;
        this.preuve2 = preuve2;
        this.etat = etat;
    }

    public DemandeEcole(int id, String preuve1, String preuve2, String etat, int id_user) {
        this.id = id;
        this.preuve1 = preuve1;
        this.preuve2 = preuve2;
        this.etat = etat;
        this.id_user = id_user;
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

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
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
    public int hashCode() {
      
        return 7;
    }

    @Override
    public String toString() {
        return "DemandeEcole{" + "id=" + id + ", preuve1=" + preuve1 + ", preuve2=" + preuve2 + ", etat=" + etat + ", id_user=" + id_user + ", id_egc=" + id_egc + '}';
    }
    

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DemandeEcole other = (DemandeEcole) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
}
