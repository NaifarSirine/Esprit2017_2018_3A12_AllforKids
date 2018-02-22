/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.entites;

import Services.ProprietaireGarderieService;
import java.net.URL;


/**
 *
 * @author PC
 */
public class Garderie {
    private int id ; 
    private String nom ; 
    private String logo ;  
    private String description ; 
    private String numTel ; 
    private String email ; 
    private String adresse ; 
    private String site ;
    private ProprietaireGarderie Proprietaire = new ProprietaireGarderie();
    private ProprietaireGarderieService ps=new ProprietaireGarderieService();
    private String ville ;
    public Garderie() {}
    public Garderie(int id, String nom, String logo, String description, String numTel, String email, String adresse, String site, int id_prop, String ville) {
        this.id = id;
        this.nom = nom;
        this.logo = logo;
        this.description = description;
        this.numTel = numTel;
        this.email = email;
        this.adresse = adresse;
        this.site = site;
        Proprietaire= ps.consulterCompte(id_prop);
        this.ville = ville;
    }

   
    public int getId_prop()
    {
        return Proprietaire.getId();
    }
    public ProprietaireGarderie getProprietaire()
    {
        return Proprietaire;
    }
    public void setProprietaire(int id_prop)
    {
        this.Proprietaire=ps.consulterCompte(id_prop);
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getLogo() {
        return logo;
    }

    public String getDescription() {
        return description;
    }

    public String getNumTel() {
        return numTel;
    }

    public String getEmail() {
        return email;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getSite() {
        return site;
    }

    public String getVille() {
        return ville;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setNumTel(String numTel) {
        this.numTel = numTel;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setSite(String site) {
        this.site = site;
    }


    public void setVille(String ville) {
        this.ville = ville;
    }

    @Override
    public String toString() {
        return "Garderie{" + "id=" + id + ", nom=" + nom + ", logo=" + logo + ", description=" + description + ", numTel=" + numTel + ", email=" + email + ", adresse=" + adresse + ", site=" + site + ", Proprietaire ==>{" +Proprietaire.toString() + "}, ville=" + ville + '}';
    }
    
    
}
