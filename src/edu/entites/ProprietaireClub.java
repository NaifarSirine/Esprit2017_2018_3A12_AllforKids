/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.entites;

/**
 *
 * @author hamma
 */
public class ProprietaireClub extends User{

    public ProprietaireClub(int id, String nom, String prenom, String numTel, String adresse, String email, String login, String password) {
        super(id, nom, prenom, numTel, adresse, email, login, password);
    }
    public  ProprietaireClub (){}

    @Override
    public String toString() {
        return super.toString();
    }

    public String getRole() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    
}
