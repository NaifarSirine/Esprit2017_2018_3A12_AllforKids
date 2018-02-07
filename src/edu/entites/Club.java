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
public class Club {
     private int id ; 
    private String nom ; 
    private String logo ; 
    private String type ; 
    private String description ; 
    private String num_tel ; 
    private String email ; 
    private String adresse ;
    private String site ;
     private String typeclub ; 
    private int id_prop ; 
    private String ville ;

    public Club(int id, String nom, String logo, String type, String description, String num_tel, String email, String adresse, String site, String typeclub, int id_prop, String ville) {
        this.id = id;
        this.nom = nom;
        this.logo = logo;
        this.type = type;
        this.description = description;
        this.num_tel = num_tel;
        this.email = email;
        this.adresse = adresse;
        this.site = site;
        this.typeclub = typeclub;
        this.id_prop = id_prop;
        this.ville = ville;
    }
    
    public Club()
    {}

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

    public String getNum_tel() {
        return num_tel;
    }

    public void setNum_tel(String num_tel) {
        this.num_tel = num_tel;
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

    public String getTypeclub() {
        return typeclub;
    }

    public void setTypeclub(String typeclub) {
        this.typeclub = typeclub;
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

    @Override
    public String toString() {
        return "Club{" + "id=" + id + ", nom=" + nom + ", logo=" + logo + ", type=" + type + ", description=" + description + ", num_tel=" + num_tel + ", email=" + email + ", adresse=" + adresse + ", site=" + site + ", typeclub=" + typeclub + ", id_prop=" + id_prop + ", ville=" + ville + '}';
    }
    
}
