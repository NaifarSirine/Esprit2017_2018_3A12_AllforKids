/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import DataStorage.MyDB;
import IServices.IDemandeBabySitter;
import edu.entites.BabySitter;
import edu.entites.DemandeBabySitter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LENOVO
 */
public class DemandeBabySitterService implements IDemandeBabySitter{
public Connection cnx ;

public DemandeBabySitterService()
    {cnx = MyDB.getinstance().getConnexion(); }

    @Override
    public void ajoutDemandeBabySitter(DemandeBabySitter d) {
          String sql = "INSERT INTO `demandebabysitter`( `id_babysitter`,  `preuve1`, `preuve2`, `etat`) VALUES ( ? , ? , ? , 'attente')";
       PreparedStatement statement;
        try {
       statement = cnx.prepareStatement(sql);
       statement.setInt(1, d.getId_babysitter());
       statement.setString(2, d.getPreuve1());
       statement.setString(3, d.getPreuve2()); 
       
       int rowsInserted = statement.executeUpdate();
        if (rowsInserted > 0) {
            System.out.println("Demande ajouté ");}
        } catch (SQLException ex) {
            Logger.getLogger(BabySitterService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void modifierDemandeBabySitter(DemandeBabySitter d, String etat) {
       String sql = "UPDATE `demandebabysitter` SET `etat`= ?  WHERE `id`= ?";
  try {
        PreparedStatement statement = cnx.prepareStatement(sql);
        statement.setString(1, etat );
        statement.setInt(2, d.getId());
        
        int rowsDeleted = statement.executeUpdate();
        if (rowsDeleted > 0) {
            System.out.println("Demande modifié");
        }} catch (SQLException ex) {
            Logger.getLogger(BabySitterService.class.getName()).log(Level.SEVERE, null, ex);
    }}

    @Override
    public ArrayList<DemandeBabySitter> rechercheDemandeBabySitter(BabySitter b) {
       String sql = "SELECT * FROM demandebabysitter where id_babysitter = "+b.getId() ;

       ArrayList<DemandeBabySitter> list = new ArrayList<DemandeBabySitter>(); 
       try {
        Statement statement = cnx.createStatement();
        ResultSet result = statement.executeQuery(sql);

        while (result.next()){
            int id = result.getInt("id");
            int id_babysitter = result.getInt("id_babysitter");
            String preuve1 = result.getString("preuve1");
            String preuve2 = result.getString("preuve2");
            String etat = result.getString("etat");
           
            list.add(new DemandeBabySitter(id, id_babysitter, preuve1, preuve2, etat)); 
        }
      
      } catch (SQLException ex) {
            Logger.getLogger(BabySitterService.class.getName()).log(Level.SEVERE, null, ex);}
             return (list); 
    }

    @Override
    public ArrayList<DemandeBabySitter> listerDemandeBabySitter() {
        String sql = "SELECT * FROM demandebabysitter" ;

       ArrayList<DemandeBabySitter> list = new ArrayList<DemandeBabySitter>(); 
       try {
        Statement statement = cnx.createStatement();
        ResultSet result = statement.executeQuery(sql);

        while (result.next()){
            int id = result.getInt("id");
            int id_babysitter = result.getInt("id_babysitter");
            String preuve1 = result.getString("preuve1");
            String preuve2 = result.getString("preuve2");
            String etat = result.getString("etat");
           
            list.add(new DemandeBabySitter(id, id_babysitter, preuve1, preuve2, etat)); 
        }
      
      } catch (SQLException ex) {
            Logger.getLogger(BabySitterService.class.getName()).log(Level.SEVERE, null, ex);}
             return (list); 
    }
}
