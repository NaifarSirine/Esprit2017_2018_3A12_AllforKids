/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.entites;

/**
 *
 * @author intel
 */
public class Boutique extends User{
 private String Cin;
 
 
    public Boutique() {
    }

    public Boutique(int id, String nom, String prenom, String numTel, String adresse, String email, String login, String password,String Cin) {
        super(id, nom, prenom, numTel, adresse, email, login, password);
    this.Cin=Cin;
    }

    public String getCin() {
        return Cin;
    }

    public void setCin(String Cin) {
        this.Cin = Cin;
    }

    @Override
    public String toString() {
        return super.toString();
    }


 

    



    
    
    
}
