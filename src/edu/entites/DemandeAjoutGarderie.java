/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.entites;

import Services.GarderieService;
import Services.ProprietaireGarderieService;
import java.net.URL;
import Utils.EtatDemandeAjout;
/**
 *
 * @author PC
 */
public class DemandeAjoutGarderie {
    private int id;
    private String preuve;
    private String preuve2;
    private EtatDemandeAjout etat;
    private ProprietaireGarderie Proprietaire = new ProprietaireGarderie();
    private ProprietaireGarderieService ps=new ProprietaireGarderieService();
    private Garderie Garderie= new Garderie();
    private GarderieService gs=new GarderieService();
    public DemandeAjoutGarderie(){}
    public DemandeAjoutGarderie(int id, String preuve, String preuve2, EtatDemandeAjout etat, int id_user,int id_egc) {
        this.id = id;
        this.preuve = preuve;
        this.preuve2 = preuve2;
        this.etat = etat;
        Proprietaire= ps.consulterCompte(id_user);
        Garderie=gs.consulterGarderieID(id_egc);
    }

    public int getId() {
        return id;
    }

    public String getPreuve() {
        return preuve;
    }

    public String getPreuve2() {
        return preuve2;
    }

    public EtatDemandeAjout getEtat() {
        return etat;
    }

    public int getId_user() {
        return Proprietaire.getId();
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPreuve(String preuve) {
        this.preuve = preuve;
    }

    public void setPreuve2(String preuve2) {
        this.preuve2 = preuve2;
    }

    public void setEtat(EtatDemandeAjout etat) {
        this.etat = etat;
    }

    public void setId_user(int id_user) {
       this.Proprietaire.setId(id_user); 
    }

    public int getId_egc() {
        return this.Garderie.getId();
    }

    public void setId_egc(int id_egc) {
        this.Garderie.setId(id_egc);
    }

    public Garderie getGarderie() {
      return this.Garderie;    }

    @Override
    public String toString() {
        return "DemandeAjoutGarderie{" + "id=" + id + ", preuve=" + preuve + ", preuve2=" + preuve2 + ", etat=" + etat + ", Proprietaire=" + Proprietaire + ", ps=" + ps + ", Garderie=" + Garderie + ", gs=" + gs + '}';
    }

    
    
    
}
