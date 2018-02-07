/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import DataStorage.MyDB;
import IServices.IProprietaireEcole;
import edu.entites.ProprietaireEcole;
import edu.entites.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author windows
 */
public class ProprietaireEcoleService  implements IProprietaireEcole {
 Connection connexion;
    public ProprietaireEcoleService() {
        connexion = MyDB.getinstance().getConnexion();
    }
         @Override
    public void AjouterProprietaireEcole(ProprietaireEcole pe) {
    String sql = "INSERT INTO `user`(`nom`,`prenom`,`numTel`,`adresse`,`email`,`login`,`password`,`cin`,`role`) VALUES (?,?,?,?,?,?,?,?,'Ecole')";
   PreparedStatement statement;
       
        try {
       statement = connexion.prepareStatement(sql);
          //  System.out.println("test");
       statement.setString(1, pe.getNom());
       statement.setString(2, pe.getPrenom());
      // statement.setString(3, E.getType());
       statement.setString(3, pe.getNumTel()); 
       statement.setString(4, pe.getAdresse());
       statement.setString(5, pe.getEmail());
       statement.setString(6, pe.getLogin());
       statement.setString(7, pe.getPassword());
       statement.setString(8, pe.getCin());
       //statement.setString(9, pe.getVille());
       int rowsInserted = statement.executeUpdate();
        if (rowsInserted > 0) {
            System.out.println("PropEcole ajouté ");}
        } catch (SQLException ex) {
            Logger.getLogger(EcoleService.class.getName()).log(Level.SEVERE, null, ex);        
}}

    @Override
    public void SupprimerProprietaireEcole(ProprietaireEcole pe) {
          String sql = "DELETE FROM user WHERE cin = ? and role = 'Ecole'";
 try { 
        PreparedStatement statement = connexion.prepareStatement(sql);
        statement.setString(1, pe.getCin());

        int rowsDeleted = statement.executeUpdate();
        if (rowsDeleted > 0) {
            System.out.println("Prop Ecole supprimé");}
         } catch (SQLException ex) {
            Logger.getLogger(ProprietaireEcole.class.getName()).log(Level.SEVERE, null, ex);
    }}
    

  @Override
   public void ModifierProprietaireEcole(ProprietaireEcole pe) {
String sql = "UPDATE `user` SET numTel =?,`adresse`=?,`email`=?,`login`=?,`password`=? WHERE id = ?";
 
 PreparedStatement statement;
     try {
       statement = connexion.prepareStatement(sql);
       statement.setString(1, pe.getNumTel()); 
       statement.setString(2, pe.getAdresse());
       statement.setString(3, pe.getEmail());
       statement.setString(4, pe.getLogin());
       statement.setString(5, pe.getPassword());
      statement.setInt(6, pe.getId());
         System.out.println(pe.getNom());
       int rowsUpdated = statement.executeUpdate();
         System.out.println("abc");
     } catch (SQLException ex) { 
         System.out.println("Services..()");
        /* if (rowsUpdated > 0) 
    System.out.println("An existing user was updated successfully!")*/

     Logger.getLogger(ProprietaireEcoleService.class.getName()).log(Level.SEVERE, null, ex);  
     
/*   */} }

   

    @Override
public ProprietaireEcole consulterCompte(int id) { 
        ProprietaireEcole P= new ProprietaireEcole();
        String sql = "SELECT * FROM `user` WHERE id='"+id+"'";
        PreparedStatement statement;
        try {
            statement = connexion.prepareStatement(sql);
            ResultSet result = statement.executeQuery(sql); 
            while (result.next())
            {
                  
                  P.setId(result.getInt(1));
                  P.setNom(result.getString(2));
                  P.setPrenom(result.getString(3));
                  P.setNumTel(result.getString(4));
                  P.setAdresse(result.getString(5));
                  P.setEmail(result.getString(6));
                  P.setLogin(result.getString(7));
                  P.setPassword(result.getString(8));
                  P.setCin(result.getString(9));
                  
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProprietaireEcoleService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return P;
        
    } 
} 
  


        
  