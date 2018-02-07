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
public class Parent extends User{
private String photo ;     
    
    public Parent(int id, String nom, String prenom, String numTel, String adresse, String email, String login, String password,String photo) {
        super(id, nom, prenom, numTel, adresse, email, login, password);
    this.photo = photo ; 
    }
public Parent(){}
    @Override
    public String toString() {
        return super.toString();
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
    
}
