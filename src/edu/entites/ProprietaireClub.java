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

    public ProprietaireClub(int id, String nom, String prenom, String numTel, String adresse, String email, String login, String password,String role) {
        super(id, nom, prenom, numTel, adresse, email, login, password,role);
    }
    public  ProprietaireClub (){}

    @Override
    public String toString() {
        return super.toString();
    }

    
    
    
}
