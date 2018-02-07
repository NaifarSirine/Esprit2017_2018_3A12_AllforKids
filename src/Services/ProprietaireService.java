/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;


import IServices.ICompte;
import edu.entites.ProprietaireClub;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import edu.entites.User;
import DataStorage.MyDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author hamma
 */
public class ProprietaireService implements ICompte{
    Connection connexion;
    private String role;
    public ProprietaireService() {
        connexion = MyDB.getinstance().getConnexion();
    }
    
    @Override
    public void ajouterCompte(ProprietaireClub p) {
        try {
            String query = "INSERT INTO `user` (`nom`, `prenom`, `numTel`, `adresse`, `email`, `login`, `password`,`role`) values ( ?,?,?,?,?,?,?,?)" ;
            PreparedStatement statement;
       
       statement = connexion.prepareStatement(query);
       statement.setString(1, p.getNom());
       statement.setString(2, p.getPrenom());
       statement.setString(3, p.getNumTel());
       statement.setString(4, p.getAdresse()); 
       statement.setString(5, p.getEmail());
       statement.setString(6, p.getLogin());
       statement.setString(7, p.getPassword());
       statement.setString(8, p.getRole());
       int rowsInserted = statement.executeUpdate();
        if (rowsInserted > 0) {
            System.out.println("**************prop ajouté************* ");}
        } catch (SQLException ex) {
            System.out.println("**************echec d'ajout***********");
        }
    }
        
    

    @Override
    public void supprimerCompte(ProprietaireClub p) {
         String sql = "DELETE FROM user WHERE id = ? ";
 try { 
        PreparedStatement statement = connexion.prepareStatement(sql);
        statement.setInt(1, p.getId());

        int rowsDeleted = statement.executeUpdate();
        if (rowsDeleted > 0) {
            System.out.println("prop supprimé");}
         } catch (SQLException ex) {
            Logger.getLogger(ProprietaireService.class.getName()).log(Level.SEVERE, null, ex);
    }}

       

    @Override
    public void modifierCompte(ProprietaireClub p) {


String sql = "UPDATE user SET numTel =?,`adresse`=?,`email`=?,`login`=?,`password`=?,`role`=? WHERE id = ?";
 
 PreparedStatement statement;
     try {
       statement = connexion.prepareStatement(sql);
    
       statement.setString(1, p.getNumTel()); 
       statement.setString(2, p.getAdresse());
       statement.setString(3, p.getEmail());
       statement.setString(4, p.getLogin());
       statement.setString(5, p.getPassword());
        statement.setString(6, p.getRole());
      statement.setInt(7, p.getId());
         System.out.println(sql);
       int rowsUpdated = statement.executeUpdate();
     } catch (SQLException ex) {
         System.out.println("Services..()");
     Logger.getLogger(ProprietaireClub.class.getName()).log(Level.SEVERE, null, ex);  
     
} }


    @Override
     public ProprietaireClub consulterProprietaireClubs(int id)
     {
          ProprietaireClub P=new ProprietaireClub();
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
                  P.setPassword(result.getString(9));
                  
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProprietaireService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return P;
     }

    
    
}
    

   
    

