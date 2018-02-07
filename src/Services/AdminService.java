/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import DataStorage.MyDB;
import IServices.IAdmin;
import edu.entites.Admin;
import edu.entites.BabySitter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LENOVO
 */
public class AdminService implements IAdmin {
  public Connection cnx ;

public AdminService()
        {cnx = MyDB.getinstance().getConnexion(); }  

    @Override
    public void modifierAdmin( Admin a2) {
         String sql = "UPDATE `user` SET `nom`= ? ,`prenom`= ?  , `numTel` = ? , `adresse` = ? , `email` = ? , `login` = ? , `password` = ?  WHERE role = 'Admin' ";
  try {
        PreparedStatement statement = cnx.prepareStatement(sql);
        statement.setString(1, a2.getNom());
        statement.setString(2, a2.getPrenom());
        statement.setString(3, a2.getNumTel());
        statement.setString(4, a2.getAdresse());
        statement.setString(5, a2.getEmail());
        statement.setString(6, a2.getLogin());
        statement.setString(7, a2.getPassword());

        int rowsDeleted = statement.executeUpdate();
        if (rowsDeleted > 0) {
            System.out.println("Admin modifié");
        }} catch (SQLException ex) {
            Logger.getLogger(BabySitterService.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    }



