/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import DataStorage.MyDB;
import IServices.IProprietaireGarderie;
import edu.entites.ProprietaireGarderie;
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
public class ProprietaireGarderieService implements IProprietaireGarderie{
    public Connection cnx ;

    public ProprietaireGarderieService()
        {cnx = MyDB.getinstance().getConnexion(); }
    @Override
    public void ajouterCompte(ProprietaireGarderie PG){
        String sql = "INSERT INTO `user`( `nom`, `prenom`, `numTel`, `adresse`, `email`, `login`, `password`, `cin`, `role`  ) VALUES ( ? , ? , ? , ? , ? , ? , ? , ? , 'PGarderie')";
       PreparedStatement statement;
        try {
       statement = cnx.prepareStatement(sql);
       statement.setString(1, PG.getNom());
       statement.setString(2, PG.getPrenom());
       statement.setString(3, PG.getNumTel());
       statement.setString(4, PG.getAdresse()); 
       statement.setString(5, PG.getEmail());
       statement.setString(6, PG.getLogin());
       statement.setString(7, PG.getPassword());
       statement.setString(8, PG.getCin());
       int rowsInserted = statement.executeUpdate();
        if (rowsInserted > 0) {
            System.out.println("Propriétaire Garderie ajouté ");}
        } catch (SQLException ex) {
            Logger.getLogger(ProprietaireGarderie.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void modifierCompte(ProprietaireGarderie PG) {
        String sql = "UPDATE `user` SET `numTel`=?,`adresse`=?,`email`=?,`login`=?,`password`=? WHERE id=? ";
        PreparedStatement statement;
        try {
       statement = cnx.prepareStatement(sql);
       statement.setString(1, PG.getNumTel());
       statement.setString(2, PG.getAdresse());
       statement.setString(3, PG.getEmail());
       statement.setString(4, PG.getLogin()); 
       statement.setString(5, PG.getPassword());
       statement.setInt(6, PG.getId());
       int rowsInserted = statement.executeUpdate();
        if (rowsInserted > 0) {
            System.out.println("Propriétaire Garderie modifié avec succées  ");}
        } catch (SQLException ex) {
            Logger.getLogger(ProprietaireGarderie.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void supprimerCompte(ProprietaireGarderie PG) {
        
        String sql = "DELETE FROM `user` WHERE id=? ";
         PreparedStatement statement;
        try {
       statement = cnx.prepareStatement(sql);
       statement.setInt(1, PG.getId());
       int rowsInserted = statement.executeUpdate();
        if (rowsInserted > 0) {
            System.out.println("Propriétaire Garderie supprimé avec succées  ");}
        } catch (SQLException ex) {
            Logger.getLogger(ProprietaireGarderie.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ProprietaireGarderie consulterCompte(int id) { 
        ProprietaireGarderie P=new ProprietaireGarderie();
        String sql = "SELECT * FROM `user` WHERE id='"+id+"'";
        PreparedStatement statement;
        try {
            statement = cnx.prepareStatement(sql);
            ResultSet result = statement.executeQuery(sql); 
            while (result.next())
            {
                  
                  P.setId(result.getInt(1));
                  P.setNom(result.getString(2));
                  P.setPrenom(result.getString(3));
                  P.setNumTel(result.getString(4));
                  P.setAdresse(result.getString(5));
                  P.setEmail(result.getString(6));
                  P.setLogin(result.getString(7));
                  P.setPassword(result.getString(8));
                  P.setCin(result.getString(9));
                  
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProprietaireGarderieService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return P;
        
    } 
    @Override
    public ArrayList<ProprietaireGarderie> listerProprietaireGarderie() {
      String sql = "SELECT * FROM user  ";
       ArrayList<ProprietaireGarderie> list = new ArrayList<ProprietaireGarderie>(); 
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
            list.add(new ProprietaireGarderie(id, nom, prenom, numTel, adresse, email, login, password, cin)); 
        }
      
      } catch (SQLException ex) {
            Logger.getLogger(ProprietaireGarderieService.class.getName()).log(Level.SEVERE, null, ex);}
             return (list); 
    }
    @Override
    public boolean login_existe(String login) {
       boolean result = false ; 
       for(ProprietaireGarderie p:listerProprietaireGarderie() )
       {if (p.getLogin().equals(login))
           result = true ; 
           }
       return (result); 
    }

  
      
    
    
}
