/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import DataStorage.MyDB;
import IServices.IEcole;
import edu.entites.Ecole;
import edu.entites.ProprietaireEcole;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author windows
 */
public class EcoleService implements IEcole{
    
     Connection connexion;
    public EcoleService() {
        connexion = MyDB.getinstance().getConnexion();
    }

    @Override
    public void AjouterEcole(Ecole E) {
        /*
         try {
           String query = "INSERT INTO ecolegarderieclub ( nom, logo, type, description, numTel, emil, adresse, site, typeClub, id_prop, ville) "
                    + "values ('"+E.getNom()+"','"+E.getLogo()+"','"+E.getType()+"','"+E.getDescription()+"','"+E.getNumTel()+"','"+E.getEmail()+"','"+E.getAdresse()+"','"+E.getSite()+"','"+"',"+E.getId_prop()+",'"+E.getVille()+"' )";
          */
        /* String query = "INSERT INTO ecolegarderieclub ( nom, logo) "
                    + "values ('"+E.getNom()+"','"+E.getLogo()+"' )";*/
       /* String query = "INSERT INTO ecolegarderieclub ( nom, logo, type, description, numTel, emil, adresse, site, typeClub, id_prop, ville) "
                    + "values ('"+E.getNom()+"','"+E.getLogo()+"','"+E.getType()+"','"+E.getDescription()+"','"+E.getNumTel()+"','"+E.getEmail()+"','"+E.getAdresse()+"','"+E.getSite()+"','"+E.getTypeClub()+"','"+E.getId_prop()+"','"+E.getVille()+"' )";*/
         
     /*    Statement stm= connexion.createStatement();
           //PreparedStatement statement = conn.prepareStatement(sql);
             //System.out.println("test1");
            stm.executeUpdate(query);
             //System.out.println("test2");
            System.out.println("Ajout effectué");
        } catch (SQLException ex) {
            System.out.println("Echec d'ajout");
        }
        */
        
   //*****************************************
     
  
   //****************************
    String sql = "INSERT INTO `ecolegarderieclub`( `nom`, `logo`, `type`, `description`, `numTel`, `email`, `adresse`, `site`, `id_prop`, `ville`) VALUES (?,?,'Ecole',?,?,?,?,?,?,?)";
   PreparedStatement statement;
       
        try {
       statement = connexion.prepareStatement(sql);
          //  System.out.println("test");
       statement.setString(1, E.getNom());
       statement.setString(2, E.getLogo());
       statement.setString(3, E.getDescription());
       statement.setString(4, E.getNumTel());
       statement.setString(5, E.getEmail());
       statement.setString(6, E.getAdresse());
       statement.setString(7, E.getSite());
        statement.setInt(8,E.getId_prop());
         statement.setString(9, E.getVille());
       //statement.setString(9, pe.getVille());
       int rowsInserted = statement.executeUpdate();
        if (rowsInserted > 0) {
            System.out.println("Ecole ajouté ");}
        } catch (SQLException ex) {
            Logger.getLogger(EcoleService.class.getName()).log(Level.SEVERE, null, ex);        
}
    }

    @Override
    public void SupprimerEcole(Ecole E) {
   String sql = "DELETE FROM `ecolegarderieclub` WHERE id = ? and type = 'Ecole'";
 try { 
        PreparedStatement statement = connexion.prepareStatement(sql);
        statement.setInt(1, E.getId());

        int rowsDeleted = statement.executeUpdate();
        if (rowsDeleted > 0) {
            System.out.println(" Ecole supprimé");}
         } catch (SQLException ex) {
            Logger.getLogger(EcoleService.class.getName()).log(Level.SEVERE, null, ex);
    }    }

    @Override
    public void ModifierEcole(Ecole E) {


String sql = "UPDATE `ecolegarderieclub` SET `logo`=?,`description`=?,`numTel`=?,`email`=?,`adresse`=?,`site`=?,`ville`=? WHERE id = ?";
 
 PreparedStatement statement;
     try {
       statement = connexion.prepareStatement(sql);
    
       statement.setString(1, E.getLogo()); 
       statement.setString(2, E.getDescription());
       statement.setString(3, E.getNumTel());
       statement.setString(4, E.getEmail());
       statement.setString(5, E.getAdresse());
       statement.setString(6, E.getSite());
       statement.setString(7, E.getVille());
      statement.setInt(8, E.getId());
        System.out.println(E.getNom());
        System.out.println(E.getId());
         System.out.println(sql);
       int rowsUpdated = statement.executeUpdate();
     } catch (SQLException ex) { 
         System.out.println("test");
        /* if (rowsUpdated > 0) 
    System.out.println("An existing user was updated successfully!")*/

     Logger.getLogger(ProprietaireEcoleService.class.getName()).log(Level.SEVERE, null, ex);  
     

    }}

    @Override
    public Ecole chercherProduitParNom(String nom) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Ecole> lireEcole() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
