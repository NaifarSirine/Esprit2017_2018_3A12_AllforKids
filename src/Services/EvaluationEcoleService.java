/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import DataStorage.MyDB;
import IServices.IEvaluationEcole;
import edu.entites.EvaluationEcole;
import edu.entites.ProprietaireEcole;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author windows
 */
public class EvaluationEcoleService implements IEvaluationEcole{

     Connection connexion;
    public EvaluationEcoleService() {
        connexion = MyDB.getinstance().getConnexion();
    }
    
    
    @Override
    public void AjouterEvaluationEcole(EvaluationEcole ee) {
       
        String sql = "INSERT INTO `evaluation`(`id`, `note`, `id_user`, `id_egc`) VALUES (?,?,?,?)";
   PreparedStatement statement;
       
        try {
       statement = connexion.prepareStatement(sql);
 
      statement.setInt(1, ee.getId());
       statement.setInt(2, ee.getNote());
       statement.setInt(3, ee.getId_user());
       statement.setInt(4, ee.getId_egc());
            System.out.println(sql);
       int rowsInserted = statement.executeUpdate();
        if (rowsInserted > 0) {
            System.out.println("Evaluation ajouté ");}
        } catch (SQLException ex) {
            Logger.getLogger(EvaluationEcoleService.class.getName()).log(Level.SEVERE, null, ex);        
}
    }

    @Override
    public void ModifierEvaluationEcole(EvaluationEcole ee) {
String sql = " UPDATE `evaluation` SET `note`=? WHERE id_user = ? and id_egc= ?";

 PreparedStatement statement;
     try {
       statement = connexion.prepareStatement(sql);
    
       //statement.setInt(1, ee.getId()); 
        // System.out.println("Services.ProprietaireEcoleService.ModifierProprietaireEcole()");
       statement.setInt(1, ee.getNote());
       statement.setInt(2, ee.getId_user());
       statement.setInt(3, ee.getId_egc());
         System.out.println(sql);
       int rowsUpdated = statement.executeUpdate();
     } catch (SQLException ex) { 
         System.out.println("Services..()");

     Logger.getLogger(EvaluationEcoleService.class.getName()).log(Level.SEVERE, null, ex);  
     }    }

    @Override
    public EvaluationEcole ConsulterEvaluationEcole(int id_egc) {
           EvaluationEcole ee= new EvaluationEcole();
 String sql = "SELECT * FROM `evaluation` WHERE id_egc='"+id_egc+"'";
        PreparedStatement statement;
        try {
            statement = connexion.prepareStatement(sql);
            ResultSet result = statement.executeQuery(sql); 
            while (result.next())
            {
                  
                  ee.setId(result.getInt(1));
                  ee.setNote(result.getInt(2));
                  ee.setId_user(result.getInt(3));
                  ee.setId_egc(result.getInt(4));              
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProprietaireEcoleService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ee;
    }
    
}
