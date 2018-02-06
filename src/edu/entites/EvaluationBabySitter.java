/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.entites;

/**
 *
 * @author LENOVO
 */
public class EvaluationBabySitter {
    private int id ; 
    private int note ; 
    private int id_user ; 
    private int id_babysitter ; 

    public EvaluationBabySitter(int id, int note, int id_user, int id_babysitter) {
        this.id = id;
        this.note = note;
        this.id_user = id_user;
        this.id_babysitter = id_babysitter;
    }

    public int getId() {
        return id;
    }

    public int getNote() {
        return note;
    }

    public int getId_user() {
        return id_user;
    }

    public int getId_babysitter() {
        return id_babysitter;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public void setId_babysitter(int id_babysitter) {
        this.id_babysitter = id_babysitter;
    }

    @Override
    public String toString() {
        return "EvaluationBabySitter{" + "id=" + id + ", note=" + note + ", id_user=" + id_user + ", id_babysitter=" + id_babysitter + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final EvaluationBabySitter other = (EvaluationBabySitter) obj;
        return true;
    }
        
}
