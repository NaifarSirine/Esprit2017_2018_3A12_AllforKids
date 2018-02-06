/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import DataStorage.MyDB;
import IServices.IEvaluationBabySitter;
import edu.entites.BabySitter;
import edu.entites.DemandeBabySitter;
import edu.entites.EvaluationBabySitter;
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
 * @author LENOVO
 */
public class EvaluationBabySitterService implements IEvaluationBabySitter{
public Connection cnx ;

public EvaluationBabySitterService()
        {cnx = MyDB.getinstance().getConnexion(); }
    @Override
    public void ajoutEvaluation(EvaluationBabySitter e) {
       String sql = "INSERT INTO `evaluationbabysitter`(`note`, `id_user`, `id_babysitter`) VALUES ( ? , ? , ? )";
       PreparedStatement statement;
        try {
       statement = cnx.prepareStatement(sql);
       statement.setInt(1, e.getNote());
       statement.setInt(2, e.getId_user());
       statement.setInt(3, e.getId_babysitter()); 
       
       int rowsInserted = statement.executeUpdate();
        if (rowsInserted > 0) {
            System.out.println("Evaluation ajouté ");}
        } catch (SQLException ex) {
            Logger.getLogger(BabySitterService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void modifierEvaluation(EvaluationBabySitter e1 , int nb ) {
      String sql = "UPDATE `evaluationbabysitter` SET `note`= ? WHERE `id` = ? and id_user = ? and id_babysitter = ? ";
  try {
        PreparedStatement statement = cnx.prepareStatement(sql);
        statement.setInt( 1, nb );
        statement.setInt(2, e1.getId() );
        statement.setInt(3, e1.getId_user());
        statement.setInt(4, e1.getId_babysitter());
        int rowsDeleted = statement.executeUpdate();
        if (rowsDeleted > 0) {
            System.out.println("Evaluation  modifié");
        }} catch (SQLException ex) {
            Logger.getLogger(BabySitterService.class.getName()).log(Level.SEVERE, null, ex);
    }}    

    @Override
    public ArrayList<EvaluationBabySitter> rechercheEvaluationBabySitter(BabySitter b) {
         String sql = "SELECT * FROM evaluationbabysitter where id_babysitter = "+b.getId() ;

       ArrayList<EvaluationBabySitter> list = new ArrayList<EvaluationBabySitter>(); 
       try {
        Statement statement = cnx.createStatement();
        ResultSet result = statement.executeQuery(sql);

        while (result.next()){
            int id = result.getInt("id");
            int note = result.getInt("note");
            int id_user = result.getInt("id_user");
            int id_babysitter = result.getInt("id_babysitter");
           
            list.add(new EvaluationBabySitter(id, note, id_user, id_babysitter)); 
        }
      
      } catch (SQLException ex) {
            Logger.getLogger(BabySitterService.class.getName()).log(Level.SEVERE, null, ex);}
             return (list); 
    
    }

    @Override
    public ArrayList<EvaluationBabySitter> listerEvaluationBabySitter() {
               String sql = "SELECT * FROM evaluationbabysitter" ;

       ArrayList<EvaluationBabySitter> list = new ArrayList<EvaluationBabySitter>(); 
       try {
        Statement statement = cnx.createStatement();
        ResultSet result = statement.executeQuery(sql);

        while (result.next()){
            int id = result.getInt("id");
            int note = result.getInt("note");
            int id_user = result.getInt("id_user");
            int id_babysitter = result.getInt("id_babysitter");
           
            list.add(new EvaluationBabySitter(id, note, id_user, id_babysitter)); 
        }
      
      } catch (SQLException ex) {
            Logger.getLogger(BabySitterService.class.getName()).log(Level.SEVERE, null, ex);}
             return (list); 
    }
}
