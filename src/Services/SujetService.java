/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import DataStorage.MyDB;
import IServices.ISujet;
import edu.entites.Parent;
import edu.entites.Sujet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author intel
 */
public class SujetService implements ISujet{
          Connection cnx;
    public SujetService() {
        cnx = MyDB.getinstance().getConnexion();
    }

    @Override
    public void ajouterSujet(Sujet s) {
            String sql = "INSERT INTO `sujet`(  `description`, `id_user`  ) VALUES (  ? , ? )";
       PreparedStatement statement;
        try {
       statement = cnx.prepareStatement(sql);
    statement.setString(1, s.getDescription());
       statement.setInt(2, s.getId_user());
       
     // statement.setInt(3, s.getId_user());
       int rowsInserted = statement.executeUpdate();
        if (rowsInserted > 0) {
            System.out.println("Sujet ajouté ");}
        } catch (SQLException ex) {
            System.out.println("echec d'ajout sujet");
        } 
        
    }
    

    @Override
    public void supprimerSujet(Sujet s) {
          String sql = "DELETE FROM sujet WHERE id = ? ";
 try { 
        PreparedStatement statement = cnx.prepareStatement(sql);
     
       statement.setInt(1, s.getId());

        int rowsDeleted = statement.executeUpdate();
        if (rowsDeleted > 0) {
            System.out.println("sujet supprimé");}
         } catch (SQLException ex) {
            Logger.getLogger(ParentService.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
          
   @Override
    public ArrayList<Sujet> consulterSujet() {
        String sql = "SELECT * FROM sujet" ;

       ArrayList<Sujet> list = new ArrayList<Sujet>(); 
       try {
        Statement statement = cnx.createStatement();
        ResultSet result = statement.executeQuery(sql);

        while (result.next()){
            int id = result.getInt("id");
            int id_user = result.getInt("id_user");
            String description = result.getString("description");
         
           
            list.add(new Sujet(id, description, id_user)); 
        }
      
      } catch (SQLException ex) {
            Logger.getLogger(Sujet.class.getName()).log(Level.SEVERE, null, ex);}
             return (list); 
    }

    @Override
    
   public ArrayList<Sujet> rechercherSujets() {
        String sql = "SELECT * FROM sujet" ;

       ArrayList<Sujet> list = new ArrayList<Sujet>(); 
       try {
        Statement statement = cnx.createStatement();
        ResultSet result = statement.executeQuery(sql);

        while (result.next()){
            int id = result.getInt("id");
            int id_user = result.getInt("id_user");
           
            String description = result.getString("description");
           
            list.add(new Sujet(id, description, id_user)); 
        }
      
      } catch (SQLException ex) {
            Logger.getLogger(Sujet.class.getName()).log(Level.SEVERE, null, ex);}
             return (list); 
    }
   
    }

    

