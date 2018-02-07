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
public class ProprietaireEcole extends User {
    
    
      String cin;

    public ProprietaireEcole() { super();
    }

      
    public ProprietaireEcole(int id, String nom, String prenom, String numTel, String adresse, String email, String login, String password,String cin) {
        super(id, nom, prenom, numTel, adresse, email, login, password);
         this.cin=cin;
      
    }

   

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

   
    
    
    
}
