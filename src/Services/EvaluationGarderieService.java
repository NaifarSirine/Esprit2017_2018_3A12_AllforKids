/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import DataStorage.MyDB;
import IServices.IEvaluationGarderie;
import edu.entites.EvaluationGarderie;
import edu.entites.Garderie;
import edu.entites.Parent;
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

    @Override
    public ArrayList<EvaluationGarderie> consulterEvaluationGarderie(int id_eg) {
       String sql= "SELECT * FROM `evaluation` WHERE `id_egc`'"+id_eg+"' order by note DESC ";
        PreparedStatement statement;
        ArrayList<EvaluationGarderie> list = new ArrayList<EvaluationGarderie>(); 
       try {
        statement = cnx.prepareStatement(sql);
        ResultSet result = statement.executeQuery(sql); 

        while (result.next()){
            int id = result.getInt("id");
            int note = result.getInt("note");
            int id_user = result.getInt("id_user");
            int id_egc = result.getInt("id_egc");
            int id_prop = result.getInt("id_prop");
            list.add(new EvaluationGarderie(id,note,id_egc,id_prop)); 
        }
      
      } catch (SQLException ex) {
            Logger.getLogger(EvaluationGarderie.class.getName()).log(Level.SEVERE, null, ex);}
             return (list); 
    }

    @Override
    public float CalculerMoyenneNote(int id_garderie) {
        String sql= "SELECT AVG(note) as 'moyenne' FROM `evaluation` WHERE id_egc='"+id_garderie+"'";
        float moyenne=0;
        PreparedStatement statement;
         try {
        statement = cnx.prepareStatement(sql);
        ResultSet result = statement.executeQuery(sql); 

        while (result.next()){
            moyenne=result.getFloat("moyenne");
        }
      
      } catch (SQLException ex) {
            Logger.getLogger(EvaluationGarderie.class.getName()).log(Level.SEVERE, null, ex);}
              return moyenne;
    }

    @Override
    public EvaluationGarderie RechercheEvaluationParent(Parent p, Garderie g) {
        String sql = "SELECT * FROM `evaluation` WHERE `id_user`='"+p.getId()+"' AND `id_egc` ='"+g.getId()+"'";
        EvaluationGarderie ag = new EvaluationGarderie();
       try {
        Statement statement = cnx.createStatement();
        ResultSet result = statement.executeQuery(sql);
        while (result.next()){
            int id = result.getInt("id");
            int id_user = result.getInt("id_user");
            int id_egc= result.getInt("id_egc");
            String note = result.getString("note");
            
        }
      } catch (SQLException ex) {
            Logger.getLogger(EvaluationGarderieService.class.getName()).log(Level.SEVERE, null, ex);}
             return (ag); 
    }
    }
    


    
    

