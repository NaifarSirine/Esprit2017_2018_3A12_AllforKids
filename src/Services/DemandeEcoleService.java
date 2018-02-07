/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import DataStorage.MyDB;
import IServices.IDemandeEcole;
import edu.entites.DemandeEcole;
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
 * @author windows
 */
public class DemandeEcoleService implements IDemandeEcole {
 Connection connexion;
    public DemandeEcoleService() {
        connexion = MyDB.getinstance().getConnexion();
    }
    @Override
    public void AjouterDemandeEcole(DemandeEcole de) {
   String sql =" INSERT INTO `demande`(`id`, `preuve1`, `preuve2`, `etat`, `id_user`, `id_egc`) VALUES (?,?,?,?,?,?)";
 PreparedStatement statement;
       
        try {
       statement = connexion.prepareStatement(sql);
 
      statement.setInt(1, de.getId());
       statement.setString(2, de.getPreuve1());
       statement.setString(3, de.getPreuve2());
       statement.setString(4, de.getEtat());
        statement.setInt(5, de.getId_user());
       statement.setInt(6, de.getId_egc());
       
            System.out.println(sql);
       int rowsInserted = statement.executeUpdate();
        if (rowsInserted > 0) {
            System.out.println("Demande ajouté ");}
        } catch (SQLException ex) {
            Logger.getLogger(EvaluationEcoleService.class.getName()).log(Level.SEVERE, null, ex);        
}    }

    @Override
    public void ModifierDemandeEcole(DemandeEcole de) {
     
 String sql="UPDATE `demande` SET `etat`=? WHERE id=?";  
 PreparedStatement statement;
     try {
       statement = connexion.prepareStatement(sql);
       statement.setString(1, de.getEtat()); 
        statement.setInt(2, de.getId());
        
       int rowsUpdated = statement.executeUpdate();
         System.out.println("abc");
     } catch (SQLException ex) { 
         System.out.println("Services..()");
    

     Logger.getLogger(ProprietaireEcoleService.class.getName()).log(Level.SEVERE, null, ex);  
     
}    }

    @Override
    public ArrayList<DemandeEcole> consulterDemandeEcole() {
        
   String sql = "SELECT * FROM demande " ;

       ArrayList<DemandeEcole> list = new ArrayList<DemandeEcole>(); 
       try {
        Statement statement = connexion.createStatement();
        ResultSet result = statement.executeQuery(sql);

        while (result.next()){
          int id = result.getInt("id");
            String preuve1 = result.getString("preuve1");
            String preuve2 = result.getString("preuve2");
            String etat= result.getString("etat");
           // System.out.println(id);
            //System.out.println(etat);       
           int id_user = result.getInt("id_user");
          // int id_egc = result.getInt("id_egc");   
           // list.add(new DemandeEcole(id, preuve1, preuve2, etat)); 
         list.add(new DemandeEcole(id, preuve1, preuve2, etat,id_user));
        }
      
      } catch (SQLException ex) {
           System.out.println("erreur");
            Logger.getLogger(DemandeEcole.class.getName()).log(Level.SEVERE, null, ex);}
             return (list); 
    }
        
    }
    

