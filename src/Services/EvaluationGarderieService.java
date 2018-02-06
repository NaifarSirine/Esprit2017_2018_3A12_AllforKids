/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import DataStorage.MyDB;
import IServices.IEvaluationGarderie;
import edu.entites.EvaluationGarderie;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class EvaluationGarderieService implements IEvaluationGarderie{
    public Connection cnx ;
    public EvaluationGarderieService()
        {cnx = MyDB.getinstance().getConnexion(); }
    @Override
    public void ajouterEvaluationGarderie(EvaluationGarderie E) {
       String sql = "INSERT INTO `evaluation`(`note`,`id_user`,`id_egc`) VALUES (?,?,?)";
       PreparedStatement statement;
        try {
       statement = cnx.prepareStatement(sql);
       statement.setInt(1, E.getNote());
       statement.setInt(2, E.getId_user());
       statement.setInt(3, E.getId_egc());
       int rowsInserted = statement.executeUpdate();
        if (rowsInserted > 0) {
            System.out.println("Evaluation Garderie ajouté ");}
        } catch (SQLException ex) {
            Logger.getLogger(EvaluationGarderie.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public void modifierEvaluationGarderie(EvaluationGarderie E) {
      String sql = "UPDATE `evaluation` SET `note`=? WHERE id=?";
        PreparedStatement statement;
        try {
       statement = cnx.prepareStatement(sql);
       statement.setInt(1,E.getNote());
       statement.setInt(2,E.getId());
       int rowsInserted = statement.executeUpdate();
        if (rowsInserted > 0) {
            System.out.println("Evaluation Garderie modifié avec succées  ");}
        } catch (SQLException ex) {
            Logger.getLogger(EvaluationGarderie.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    
    
}
