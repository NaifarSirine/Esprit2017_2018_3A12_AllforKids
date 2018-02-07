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
public class Sujet {
    private int id ;
    private String description ;
    private int  id_user;
    public Sujet(){
    }

    public Sujet(int id, String description, int id_user) {
        this.id = id;
        this.description = description;
        this.id_user = id_user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    @Override
    public String toString() {
        return "Sujet{" + "id=" + id + ", description=" + description + ", id_user=" + id_user + '}';
    }
    
    
    }
   

