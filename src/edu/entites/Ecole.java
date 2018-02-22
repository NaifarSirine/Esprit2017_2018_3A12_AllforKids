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
public class Ecole {
    
    int id;
    String nom;
    String logo;
    String type;
    String description;
    String numTel;
    String email;
    String adresse;
    String site;
    int id_prop;
    String ville;

    public Ecole(int id, String nom, String logo, String type, String description, String numTel, String email, String adresse, String site, int id_prop, String ville) {
        this.id = id;
        this.nom = nom;
        this.logo = logo;
        this.type = type;
        this.description = description;
        this.numTel = numTel;
        this.email = email;
        this.adresse = adresse;
        this.site = site;
        this.id_prop = id_prop;
        this.ville = ville;
    }
    //****************************************************************
/*
    public String getTypeClub() {
        return typeClub;
    }

    public void setTypeClub(String typeClub) {
        this.typeClub = typeClub;
    }
    */
    
         public Ecole( String nom, String logo) {
        //this.id = id;
        this.nom = nom;
        this.logo = logo;
        
    }
         
        public Ecole( int id ,String nom, String logo,  String description, String numTel, String email, String adresse, String site, int id_prop, String ville) {
        this.id = id;
        this.nom = nom;
        this.logo = logo;
      // this.type = type;
        this.description = description;
        this.numTel = numTel;
        this.email = email;
        this.adresse = adresse;
        this.site = site;
       // this.typeClub=typeClub;
        this.id_prop = id_prop;
        this.ville = ville;
    }
    
    //*************************************
        
  /*    
     public Ecole( String nom, String logo, String type, String description, String numTel, String email, String adresse, String site, int id_prop, String ville) {
        //this.id = id;
        this.nom = nom;
        this.logo = logo;
        this.type = type;
        this.description = description;
        this.numTel = numTel;
        this.email = email;
        this.adresse = adresse;
        this.site = site;
        this.id_prop = id_prop;
        this.ville = ville;
    }
    
    */
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNumTel() {
        return numTel;
    }

    public void setNumTel(String numTel) {
        this.numTel = numTel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public int getId_prop() {
        return id_prop;
    }

    public void setId_prop(int id_prop) {
        this.id_prop = id_prop;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }
    
    
    
    



    
}
