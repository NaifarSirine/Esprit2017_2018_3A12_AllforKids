/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.entites;

import java.util.Objects;

/**
 *
 * @author LENOVO
 */
public class DemandeBabySitter {
    private int id ; 
    private int id_babysitter; 
    private String preuve1 ; 
    private String preuve2 ; 
    private String Etat; 

    public DemandeBabySitter(int id , int id_babysitter, String preuve1, String preuve2, String Etat) {
        this.id = id;
        this.id_babysitter = id_babysitter;
        this.preuve1 = preuve1;
        this.preuve2 = preuve2;
        this.Etat = Etat;
    }

    public int getId() {
        return id;
    }

    public int getId_babysitter() {
        return id_babysitter;
    }


    public String getPreuve1() {
        return preuve1;
    }

    public String getPreuve2() {
        return preuve2;
    }

    public String getEtat() {
        return Etat;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setId_babysitter(int id_babysitter) {
        this.id_babysitter = id_babysitter;
    }


    public void setPreuve1(String preuve1) {
        this.preuve1 = preuve1;
    }

    public void setPreuve2(String preuve2) {
        this.preuve2 = preuve2;
    }

    public void setEtat(String Etat) {
        this.Etat = Etat;
    }

 


    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DemandeBabySitter other = (DemandeBabySitter) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.id_babysitter != other.id_babysitter) {
            return false;
        }
       
        if (!Objects.equals(this.preuve1, other.preuve1)) {
            return false;
        }
        if (!Objects.equals(this.preuve2, other.preuve2)) {
            return false;
        }
        if (!Objects.equals(this.Etat, other.Etat)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DemandeBabySitter{" + "id=" + id + ", id_babysitter=" + id_babysitter + ", preuve1=" + preuve1 + ", preuve2=" + preuve2 + ", Etat=" + Etat + '}';
    } 
    
}
