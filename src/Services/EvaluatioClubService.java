/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;
import IServices.IEvaluationClub;
import edu.entites.EvaluationClub;
import java.util.List;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import DataStorage.MyDB;
import edu.entites.Club;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hamma
 */
public class EvaluatioClubService implements IEvaluationClub {
    
    
    Connection connexion;
    public EvaluatioClubService() {
        connexion = MyDB.getinstance().getConnexion();
    }
    
    @Override
    public void AjouterEvaluationClub(EvaluationClub cc)
    {
       String sql = "INSERT INTO `evaluation`(`id`, `note`, `id_user`, `id_egc`) VALUES (?,?,?,?)";
   PreparedStatement statement;
        try {
       statement = connexion.prepareStatement(sql);
 
       statement.setInt(1, cc.getId());
       statement.setInt(2, cc.getNote());
       statement.setInt(3, cc.getId_user());
       statement.setInt(4, cc.getId_egc());
       System.out.println(sql);
         int rowsInserted = statement.executeUpdate();
         if (rowsInserted > 0) {
            System.out.println("**************Evaluation  ajouté************* ");}
        } catch (SQLException ex) {
            System.out.println("**************echec d'ajout***********");
        }}

    

    @Override
    public void ModifierEvaluationClub(EvaluationClub cc) {
       String sql = " UPDATE `evaluation` SET `note`=? WHERE id_user = ? and id_egc= ?";

 PreparedStatement statement;
     try {
       statement = connexion.prepareStatement(sql);
    
       //statement.setInt(1, ee.getId()); 
        // System.out.println("Services.ProprietaireEcoleService.ModifierProprietaireEcole()");
       statement.setInt(1, cc.getNote());
       statement.setInt(2, cc.getId_user());
       statement.setInt(3, cc.getId_egc());
         System.out.println(sql);
       int rowsUpdated = statement.executeUpdate();
     } catch (SQLException ex) { 
         System.out.println("Services..()");

     Logger.getLogger(EvaluatioClubService.class.getName()).log(Level.SEVERE, null, ex);  
     }    }
    
    
    @Override
     public void supprimerEvaluationClub(EvaluationClub cc) {
         String sql = "DELETE FROM evaluation WHERE id = ? ";
 try { 
        PreparedStatement statement = connexion.prepareStatement(sql);
        statement.setInt(1, cc.getId());

        int rowsDeleted = statement.executeUpdate();
        if (rowsDeleted > 0) {
            System.out.println("evaluation supprimé");}
         } catch (SQLException ex) {
            Logger.getLogger(ClubService.class.getName()).log(Level.SEVERE, null, ex);
    }}

    
}
