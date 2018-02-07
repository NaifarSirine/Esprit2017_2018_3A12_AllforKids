/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import DataStorage.MyDB;
import IServices.ICommentaire;
import edu.entites.Commentaire;
import edu.entites.Sujet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author intel
 */
public class CommentaireService implements ICommentaire {
          Connection cnx;
    public CommentaireService() {
        cnx = MyDB.getinstance().getConnexion();
    }
    @Override
    public void ajouterCommentaire(Commentaire cm) {
        
      
            String sql = "INSERT INTO `commentaire`(`description`,`id_sujet`,`id_user`) VALUES (?,?,?)";
       PreparedStatement statement;
        try {
       statement = cnx.prepareStatement(sql);
       
    statement.setString(1, cm.getDescription());
    statement.setInt(3, cm.getId_user());
       statement.setInt(2, cm.getId_sujet());
      
          
       int rowsInserted = statement.executeUpdate();
         
        if (rowsInserted > 0) {
            
            System.out.println("Commentaire ajouté ");}
        } catch (SQLException ex) {
            System.out.println("echec d'ajout");
        } 
        
    }
    

    @Override
    public void supprimerCommentaire(Commentaire cm) {
         String sql = "DELETE FROM commentaire WHERE id=?";
 try { 
        PreparedStatement statement = cnx.prepareStatement(sql);
     
       statement.setInt(1, cm.getId());

        int rowsDeleted = statement.executeUpdate();
        if (rowsDeleted > 0) {
            System.out.println("commentaire supprimé");}
         } catch (SQLException ex) {
            Logger.getLogger(ParentService.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    @Override
    public ArrayList<Commentaire> consulterCommentaire() {
         String sql = "SELECT * FROM commentaire" ;

       ArrayList<Commentaire> list = new ArrayList<Commentaire>(); 
       try {
        Statement statement = cnx.createStatement();
        ResultSet result = statement.executeQuery(sql);

        while (result.next()){
            int id = result.getInt("id");
                String description = result.getString("description");
            int id_sujet = result.getInt("id_sujet");
            int id_user = result.getInt("id_user");
         
           
            list.add(new Commentaire(id, description, id_user, id_user)); 
        }
      
      } catch (SQLException ex) {
            Logger.getLogger(Sujet.class.getName()).log(Level.SEVERE, null, ex);}
             return (list); 
    }
    }
    

 

