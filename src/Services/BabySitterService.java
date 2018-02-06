/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import DataStorage.MyDB;
import IServices.IBabySitter;
import edu.entites.BabySitter;
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
public class BabySitterService implements IBabySitter{
public Connection cnx ;

public BabySitterService()
        {cnx = MyDB.getinstance().getConnexion(); }
    @Override
    public void ajoutBabySitter(BabySitter b) {
        String sql = "INSERT INTO `user`( `nom`, `prenom`, `numTel`, `adresse`, `email`, `login`, `password`, `cin`, `cv`, `photo` , `role` ) VALUES ( ? , ? , ? , ? , ? , ? , ? , ? , ? , ?  , 'BabySitter')";
       PreparedStatement statement;
        try {
       statement = cnx.prepareStatement(sql);
       statement.setString(1, b.getNom());
       statement.setString(2, b.getPrenom());
       statement.setString(3, b.getNumTel());
       statement.setString(4, b.getAdresse()); 
       statement.setString(5, b.getEmail());
       statement.setString(6, b.getLogin());
       statement.setString(7, b.getPassword());
       statement.setString(8, b.getCin());
       statement.setString(9, b.getCv());
       statement.setString(10, b.getPhoto());
       int rowsInserted = statement.executeUpdate();
        if (rowsInserted > 0) {
            System.out.println("babySitter ajouté ");}
        } catch (SQLException ex) {
            Logger.getLogger(BabySitterService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void modifierBabySitter(BabySitter b1, BabySitter b2) {
        String sql = "UPDATE `user` SET `nom`= ? ,`prenom`= ?  , `numTel` = ? , `adresse` = ? , `email` = ? , `login` = ? , `password` = ? , `cv` = ? , `photo` = ? WHERE `cin` = ? and role = 'BabySitter' ";
  try {
        PreparedStatement statement = cnx.prepareStatement(sql);
        statement.setString(1, b2.getNom());
        statement.setString(2, b2.getPrenom());
        statement.setString(3, b2.getNumTel());
        statement.setString(4, b2.getAdresse());
        statement.setString(5, b2.getEmail());
        statement.setString(6, b2.getLogin());
        statement.setString(7, b2.getPassword());
        statement.setString(8, b2.getCv());
        statement.setString(9, b2.getPhoto());
        statement.setString(10, b1.getCin());
        int rowsDeleted = statement.executeUpdate();
        if (rowsDeleted > 0) {
            System.out.println("BabySitter modifié");
        }} catch (SQLException ex) {
            Logger.getLogger(BabySitterService.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    @Override
    public void supprimerBabySitter(BabySitter b) {
       String sql = "DELETE FROM user WHERE cin = ? and role = 'BabySitter'";
 try { 
        PreparedStatement statement = cnx.prepareStatement(sql);
        statement.setString(1, b.getCin());

        int rowsDeleted = statement.executeUpdate();
        if (rowsDeleted > 0) {
            System.out.println("babySitter supprimé");}
         } catch (SQLException ex) {
            Logger.getLogger(BabySitterService.class.getName()).log(Level.SEVERE, null, ex);
    }}

    @Override
    public BabySitter rechercheBabySitterParCin(String cinr) {
       String sql = "SELECT * FROM user where role = 'BabySitter' and cin = " +cinr ;
       BabySitter b = null ; 
       
        Statement statement;
    try {
        statement = cnx.createStatement();
        ResultSet result = statement.executeQuery(sql);

        while (result.next()){
            int id = result.getInt("id");
            String nom = result.getString("nom");
            String prenom = result.getString("prenom");
            String numTel = result.getString("numTel");
            String adresse = result.getString("adresse");
            String email = result.getString("email");
            String login = result.getString("login");
            String password = result.getString("password");
            String cin = result.getString("cin");
            String cv = result.getString("cv");
            String photo = result.getString("photo");
            b = new BabySitter(cv, photo, cin, id, nom, prenom, numTel, adresse, email, login, password); 
        }}  catch (SQLException ex) {
            Logger.getLogger(BabySitterService.class.getName()).log(Level.SEVERE, null, ex);}
             
        return b ; 
    }

    @Override
    public ArrayList<BabySitter> listerBabySitter() {
      String sql = "SELECT * FROM user where role = 'BabySitter' ";
       ArrayList<BabySitter> list = new ArrayList<BabySitter>(); 
       try {
        Statement statement = cnx.createStatement();
        ResultSet result = statement.executeQuery(sql);

        while (result.next()){
            int id = result.getInt("id");
            String nom = result.getString("nom");
            String prenom = result.getString("prenom");
            String numTel = result.getString("numTel");
            String adresse = result.getString("adresse");
            String email = result.getString("email");
            String login = result.getString("login");
            String password = result.getString("password");
            String cin = result.getString("cin");
            String cv = result.getString("cv");
            String photo = result.getString("photo");
            list.add(new BabySitter(cv, photo, cin, id, nom, prenom, numTel, adresse, email, login, password)); 
        }
      
      } catch (SQLException ex) {
            Logger.getLogger(BabySitterService.class.getName()).log(Level.SEVERE, null, ex);}
             return (list); 
    }}
    

