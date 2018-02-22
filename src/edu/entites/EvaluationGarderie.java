/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.entites;

import Services.GarderieService;
import Services.ParentService;

/**
 *
 * @author PC
 */
public class EvaluationGarderie {
    private int id;
    private int note;
    private Parent Parent =new Parent();
    private ParentService ps=new ParentService();
    private Garderie Garderie=new Garderie();
    private GarderieService gs= new GarderieService();
   
    public EvaluationGarderie(){}
    public EvaluationGarderie(int id, int note, int id_user, int id_egc) {
        this.id = id;
        this.note = note;
        this.Parent= ps.consulterCompte(id_user);
        this.Garderie = gs.consulterGarderieID(id_egc);
    }

    public int getId() {
        return id;
    }

    public int getNote() {
        return note;
    }

    public int getId_user() {
        return this.Parent.getId();
    }

    public int getId_egc() {
        return this.Garderie.getId();
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public void setId_user(int id_user) {
        this.Parent.setId(id_user); 
    }

    public void setId_egc(int id_egc) {
        this.Garderie.setId(id_egc);
    }

    @Override
    public String toString() {
        return "EvaluationGarderie{" + "id=" + id + ", note=" + note + ", Parent={" + this.Parent.toString() + "}, Garderie={" + this.Garderie.toString() + "}}";
    }
    
}
