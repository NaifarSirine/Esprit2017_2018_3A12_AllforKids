/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import IServices.IClub;
import edu.entites.Club;
import java.util.List;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import DataStorage.MyDB;
import Utils.EtatDemandeAjout;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.List;


/**
 *
 * @author hamma
 */
public class ClubService implements IClub{
     Connection connexion;
    
        public ClubService() {
        connexion = MyDB.getinstance().getConnexion();
    }

    @Override
    public void ajouterClub(Club c) {
       
      try {
            String query = "INSERT INTO `ecolegarderieclub` (`nom`, `logo`, `type`, `description`, `numTel`, `email`, `adresse`,`site`, `typeClub`, `id_prop`,`ville`) values ( ?,?,?,?,?,?,?,?,?,?,?)" ;
            PreparedStatement statement;
       
       statement = connexion.prepareStatement(query);
       statement.setString(1, c.getNom());
       statement.setString(2, c.getLogo());
       statement.setString(3, c.getType());
       statement.setString(4, c.getDescription()); 
       statement.setString(5, c.getNum_tel());
       statement.setString(6, c.getEmail());
       statement.setString(7, c.getAdresse());
       statement.setString(8, c.getSite());
       statement.setString(9, c.getTypeclub());
       statement.setInt(10, c.getId_prop());
        statement.setString(11, c.getVille());
        
       int rowsInserted = statement.executeUpdate();
        if (rowsInserted > 0) {
            System.out.println("**************Club ajouté************* ");}
        } catch (SQLException ex) {
            System.out.println("**************echec d'ajout Club ***********");
        }
    }
        
    

    @Override
    public void supprimerClub(Club c) {
         String sql = "DELETE FROM ecolegarderieclub WHERE id = ? ";
 try { 
        PreparedStatement statement = connexion.prepareStatement(sql);
        statement.setInt(1, c.getId());

        int rowsDeleted = statement.executeUpdate();
        if (rowsDeleted > 0) {
            System.out.println("Club supprimé");}
         } catch (SQLException ex) {
            Logger.getLogger(ClubService.class.getName()).log(Level.SEVERE, null, ex);
    }}

    

    @Override
    public void modifierClub(Club c) {
     
String sql = "UPDATE ecolegarderieclub SET logo =?,`type`=?,`description`=?,`numTel`=?,`email`=?,`adresse`=?,`site`=?,`typeClub`=?,`id_prop`=?,`ville`=? WHERE id = ?";
 
 PreparedStatement statement;
     try {
       statement = connexion.prepareStatement(sql);
    
       statement.setString(1, c.getLogo()); 
        statement.setString(2, c.getType()); 
       statement.setString(3, c.getDescription());
       statement.setString(4, c.getNum_tel());
       statement.setString(5, c.getEmail());
       statement.setString(6, c.getAdresse());
        statement.setString(7, c.getSite());
        statement.setString(8, c.getTypeclub());
       statement.setInt(9, c.getId_prop());
        statement.setString(10, c.getVille());
      statement.setInt(11, c.getId());
         System.out.println(sql);
       int rowsUpdated = statement.executeUpdate();
     } catch (SQLException ex) {
         System.out.println("Services..()");
     Logger.getLogger(Club.class.getName()).log(Level.SEVERE, null, ex);  
     
} }

    

    @Override
    public List<Club> consulterClubs() {
       
        String query="SELECT d.*,egc.* FROM ecolegarderieclub egc join demande d on egc.id=d.id WHERE etat = '"+EtatDemandeAjout.Acceptee+"'";
        List<Club> res= new ArrayList<Club>();
         PreparedStatement statement = null;
        
        try {
             Statement st=connexion.createStatement();
             ResultSet result=st.executeQuery(query);
             
             while (result.next()) { 
            int id = result.getInt("id");
            String nom = result.getString("nom");
            String logo = result.getString("logo");
            String type = result.getString("type");
            String description = result.getString("description");
            String numTel = result.getString("numTel");
            String email = result.getString("email");
            String adresse = result.getString("adresse");
            String site = result.getString("site");
            String typeClub = result.getString("typeClub");
            int id_prop = result.getInt("id_prop");
              String ville = result.getString("ville");
         
            res.add(new Club( id,  nom, logo,  type,  description,  numTel,  email,  adresse,  site,  typeClub,  id_prop,  ville)); 
                
            }
         } catch (SQLException ex) {
             Logger.getLogger(Club.class.getName()).log(Level.SEVERE, null, ex);
         }
         return  (ArrayList<Club>) res;
    }
    
    @Override
    public Club chercherClubs(String nom)
     {
          Club c=new Club();
        String sql = "SELECT * FROM `ecolegarderieclub` WHERE nom='"+nom+"'";
        PreparedStatement statement;
        try {
            statement = connexion.prepareStatement(sql);
            ResultSet result = statement.executeQuery(sql); 
            while (result.next())
            {
                  
                  c.setId(result.getInt(1));
                  c.setNom(result.getString(2));
                  c.setLogo(result.getString(3));
                  c.setType(result.getString(4));
                  c.setDescription(result.getString(5));
                  c.setNum_tel(result.getString(6));
                  c.setEmail(result.getString(7));
                  c.setAdresse(result.getString(8));
                  c.setSite(result.getString(9));
                   c.setTypeclub(result.getString(10));
                  c.setId_prop(result.getInt(11));
                  c.setVille(result.getString(12));
                  
                  
                  
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProprietaireService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return c;
     }

    }
    

