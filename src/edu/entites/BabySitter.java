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
public class BabySitter extends User{
private String cv ; 
private String photo; 
private String cin ; 
 

    public BabySitter(String cv, String photo, String cin, int id, String nom, String prenom, String numTel, String adresse, String email, String login, String password) {
        super(id, nom, prenom, numTel, adresse, email, login, password);
        this.cv = cv;
        this.photo = photo;
        this.cin = cin;
    }




    public String getCv() {
        return cv;
    }

    public String getPhoto() {
        return photo;
    }

    public String getCin() {
        return cin;
    }

    public void setCv(String cv) {
        this.cv = cv;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final BabySitter other = (BabySitter) obj;
        if (!Objects.equals(this.cin, other.cin)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return  super.toString()  + "cv=" + cv + ", photo=" + photo + ", cin=" + cin + '}';
    }
    
}
