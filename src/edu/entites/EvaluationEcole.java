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
public class EvaluationEcole {
    
    
    int id;
    int note;
    int id_user;
    int id_egc;
    
   

    public EvaluationEcole(int id, int note, int id_user, int id_egc) {
        this.id = id;
        this.note = note;
        this.id_user = id_user;
        this.id_egc = id_egc;
    }
    
       public EvaluationEcole(int id, int note) {
        this.id = id;
        this.note = note;
   
    }

    public EvaluationEcole() {
    }
  

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getId_egc() {
        return id_egc;
    }

    public void setId_egc(int id_egc) {
        this.id_egc = id_egc;
    }
   
    
}
