/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.entites;

import Services.GarderieService;
import Services.ParentService;
import Utils.EtatAbonnement;

/**
 *
 * 
 */
public class AbonnementGarderie {
    private int id ; 
    private EtatAbonnement etat ;
    private Parent Parent ; 
    private Garderie Garderie ; 
    
    public AbonnementGarderie(){}
    public AbonnementGarderie(int id,EtatAbonnement etat,int id_parent,int id_garderie) {
        ParentService ps=new ParentService();
        GarderieService gs=new GarderieService();
        this.id = id;
        this.etat = etat ; 
        this.Parent =ps.consulterCompte(id_parent);
        this.Garderie =gs.consulterGarderieID(id_garderie);  
    }

    public int getId() {
        return id;
    }

    public EtatAbonnement getEtat() {
        return etat;
    }

    public Parent getParent() {
        return Parent;
    }

    public Garderie getGarderie() {
        return Garderie;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEtat(EtatAbonnement etat) {
        this.etat = etat;
    }

    public void setParent(Parent Parent) {
        this.Parent = Parent;
    }

    public void setGarderie(Garderie Garderie) {
        this.Garderie = Garderie;
    }

    @Override
    public String toString() {
        return "AbonnementGarderie{" + "id=" + id + ", etat=" + etat + ", Parent=" + Parent + ", Garderie=" + Garderie + '}';
    }
    
    

   

   
    
    
    
    
    
}
