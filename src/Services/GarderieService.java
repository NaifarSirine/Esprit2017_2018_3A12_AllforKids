/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import DataStorage.MyDB;
import IServices.IGarderie;
import Utils.EtatDemandeAjout;
import edu.entites.Garderie;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class GarderieService implements IGarderie {
    
    public Connection cnx ;
    public GarderieService()
        {cnx = MyDB.getinstance().getConnexion(); }
    @Override
    public void ajouterGarderie(Garderie G) {
        String sql = "INSERT INTO `ecolegarderieclub`(`nom`, `logo`, `type`, `description`, `numTel`, `email`, `adresse`, `site`, `id_prop`, `ville`) VALUES  (?,?,'Garderie',?,?,?,?,?,?,?)";
       PreparedStatement statement;
        try {
       statement = cnx.prepareStatement(sql);
       statement.setString(1, G.getNom());
       statement.setString(2, G.getLogo());
       statement.setString(3, G.getDescription());
       statement.setString(4, G.getNumTel());
       statement.setString(5, G.getEmail());
       statement.setString(6, G.getAdresse());
       statement.setString(7, G.getSite());
       statement.setInt(8,G.getId_prop());
       statement.setString(9, G.getVille());
       int rowsInserted = statement.executeUpdate();
        if (rowsInserted > 0) {
            System.out.println("Garderie ajouté ");}
        } catch (SQLException ex) {
            Logger.getLogger(Garderie.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void modifierGarderie(Garderie G) {
        
        String sql = "UPDATE `ecolegarderieclub` SET `logo`=?,`description`=?,`numTel`=?,`email`=?,`site`=? WHERE `id`=?";
        PreparedStatement statement;
        try {
       statement = cnx.prepareStatement(sql);
       statement.setString(1, G.getLogo());
       statement.setString(2, G.getDescription());
       statement.setString(3, G.getNumTel());
       statement.setString(4, G.getEmail()); 
       statement.setString(5, G.getSite());
       statement.setInt(6, G.getId());
       int rowsInserted = statement.executeUpdate();
        if (rowsInserted > 0) {
            System.out.println(" Garderie modifié avec succées  ");}
        } catch (SQLException ex) {
            Logger.getLogger(Garderie.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void supprimerGarderie(Garderie G) {
        String sql = "DELETE FROM `ecolegarderieclub` WHERE id=? ";
         PreparedStatement statement;
        try {
       statement = cnx.prepareStatement(sql);
       statement.setInt(1,G.getId());
       int rowsInserted = statement.executeUpdate();
        if (rowsInserted > 0) {
            System.out.println("Propriétaire Garderie supprimé avec succées  ");}
        } catch (SQLException ex) {
            Logger.getLogger(Garderie.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Garderie rechercheGarderie(String nom) {
        Garderie P= new Garderie();
        String sql = "SELECT * FROM `ecolegarderieclub` JOIN `demande` on `demande`.`id_egc`=`ecolegarderieclub`.`id`"
                + " WHERE `demande`.`etat`='"+EtatDemandeAjout.Acceptee+"' AND `ecolegarderieclub`.`type`='Garderie' AND ecolegarderieclub.nom='"+nom+"'";
        PreparedStatement statement;
        try {
            statement = cnx.prepareStatement(sql);
            ResultSet result = statement.executeQuery(sql); 
            while (result.next())
            {
                  P.setId(result.getInt("id"));                 
                  P.setNom(result.getString("nom"));
                  P.setLogo(result.getString("logo"));
                  P.setDescription(result.getString("description"));
                  P.setNumTel(result.getString("numTel"));
                  P.setEmail(result.getString("email"));
                  P.setAdresse(result.getString("adresse"));
                  P.setSite(result.getString("site"));
                  P.setProprietaire(result.getInt("id_prop"));
                  P.setVille(result.getString("ville"));     
            }
        } catch (SQLException ex) {
            Logger.getLogger(Garderie.class.getName()).log(Level.SEVERE, null, ex);
        }
        return P;

    }

    @Override
    public ArrayList<Garderie> consulterGarderie() {
        String sql = "SELECT * FROM `ecolegarderieclub` JOIN `demande` on `demande`.`id_egc`=`ecolegarderieclub`.`id` WHERE`demande`.`etat`='"+EtatDemandeAjout.Acceptee+"' AND `ecolegarderieclub`.`type`='Garderie'" ;
        PreparedStatement statement;
        ArrayList<Garderie> list = new ArrayList<Garderie>(); 
       try {
        statement = cnx.prepareStatement(sql);
        ResultSet result = statement.executeQuery(sql); 

        while (result.next()){
            int id = result.getInt("id");
            String nom = result.getString("nom");
            String logo = result.getString("logo");
            String description = result.getString("description");
            String numTel = result.getString("numTel");
            String email = result.getString("email");
            String adresse = result.getString("adresse");
            String site = result.getString("site");
            int id_prop = result.getInt("id_prop");
            String ville = result.getString("ville");
            list.add(new Garderie(id,nom,logo,description,numTel,email,adresse,site,id_prop,ville)); 
        }
      
      } catch (SQLException ex) {
            Logger.getLogger(Garderie.class.getName()).log(Level.SEVERE, null, ex);}
             return (list); 
                }

  @Override
   public ArrayList<Garderie> consulterGarderie(int id_p)
    {
        String sql= "SELECT * FROM `ecolegarderieclub` JOIN `demande` on `demande`.`id_egc`=`ecolegarderieclub`.`id` WHERE`demande`.`etat`='"+EtatDemandeAjout.Acceptee+"' AND `ecolegarderieclub`.`type`='Garderie'AND ecolegarderieclub.id_prop='"+id_p+"'";
        PreparedStatement statement;
        ArrayList<Garderie> list = new ArrayList<Garderie>(); 
       try {
        statement = cnx.prepareStatement(sql);
        ResultSet result = statement.executeQuery(sql); 

        while (result.next()){
            int id = result.getInt("id");
            String nom = result.getString("nom");
            String logo = result.getString("logo");
            String description = result.getString("description");
            String numTel = result.getString("numTel");
            String email = result.getString("email");
            String adresse = result.getString("adresse");
            String site = result.getString("site");
            int id_prop = result.getInt("id_prop");
            String ville = result.getString("ville");
            list.add(new Garderie(id,nom,logo,description,numTel,email,adresse,site,id_prop,ville)); 
        }
      
      } catch (SQLException ex) {
            Logger.getLogger(Garderie.class.getName()).log(Level.SEVERE, null, ex);}
             return (list); 
       }

    @Override
    public ArrayList<Garderie> rechercherGarderie(String v) {
        String sql= "SELECT * FROM `ecolegarderieclub` JOIN `demande` on `demande`.`id_egc`=`ecolegarderieclub`.`id` WHERE`demande`.`etat`='"+EtatDemandeAjout.Acceptee+"' AND `ecolegarderieclub`.`type`='Garderie'AND ecolegarderieclub.ville='"+v+"'";
        PreparedStatement statement;
        ArrayList<Garderie> list = new ArrayList<Garderie>(); 
       try {
        statement = cnx.prepareStatement(sql);
        ResultSet result = statement.executeQuery(sql); 

        while (result.next()){
            int id = result.getInt("id");
            String nom = result.getString("nom");
            String logo = result.getString("logo");
            String description = result.getString("description");
            String numTel = result.getString("numTel");
            String email = result.getString("email");
            String adresse = result.getString("adresse");
            String site = result.getString("site");
            int id_prop = result.getInt("id_prop");
            String ville = result.getString("ville");
            list.add(new Garderie(id,nom,logo,description,numTel,email,adresse,site,id_prop,ville)); 
        }
      
      } catch (SQLException ex) {
            Logger.getLogger(Garderie.class.getName()).log(Level.SEVERE, null, ex);}
             return (list); 
    }

    @Override
    public Garderie consulterGarderieID(int i) {
        String sql= "SELECT * FROM `ecolegarderieclub` JOIN `demande` on `demande`.`id_egc`=`ecolegarderieclub`.`id` WHERE`demande`.`etat`='"+EtatDemandeAjout.Acceptee+"' AND `ecolegarderieclub`.`type`='Garderie'AND ecolegarderieclub.id='"+i+"'";
        PreparedStatement statement;
       try {
        statement = cnx.prepareStatement(sql);
        ResultSet result = statement.executeQuery(sql); 

        while (result.next()){
            int id = result.getInt("id");
            String nom = result.getString("nom");
            String logo = result.getString("logo");
            String description = result.getString("description");
            String numTel = result.getString("numTel");
            String email = result.getString("email");
            String adresse = result.getString("adresse");
            String site = result.getString("site");
            int id_prop = result.getInt("id_prop");
            String ville = result.getString("ville");
            Garderie G=new Garderie(id,nom,logo,description,numTel,email,adresse,site,id_prop,ville); 
            return G; 
        }
      
      } catch (SQLException ex) {
            Logger.getLogger(Garderie.class.getName()).log(Level.SEVERE, null, ex);}
     return null;        
    }

    @Override
    public int ChercherIdGarderie(Garderie G) {
        int id=0;
        String sql= "SELECT * FROM `ecolegarderieclub` Where `ecolegarderieclub`.`type`='Garderie'AND "
                + "  ecolegarderieclub.nom='"+G.getNom()+"' AND ecolegarderieclub.description='"+G.getDescription()+"'  "
                + "  AND ecolegarderieclub.adresse='"+G.getAdresse()+"'";
        PreparedStatement statement;
       try {
        statement = cnx.prepareStatement(sql);
        ResultSet result = statement.executeQuery(sql); 

        while (result.next()){
           id = result.getInt("id");    
        }
      
      } catch (SQLException ex) {
            Logger.getLogger(Garderie.class.getName()).log(Level.SEVERE, null, ex);}
        return id;        
    }
    @Override
   public ArrayList<Garderie> consulterGarderie2(int id_p)
    {
        String sql= "SELECT * FROM `ecolegarderieclub` JOIN `demande` on `demande`.`id_egc`=`ecolegarderieclub`.`id` WHERE`demande`.`etat`='EnTraitement' AND `ecolegarderieclub`.`type`='Garderie' AND ecolegarderieclub.id_prop='"+id_p+"'";
        PreparedStatement statement;
        ArrayList<Garderie> list = new ArrayList<Garderie>(); 
       try {
        statement = cnx.prepareStatement(sql);
        ResultSet result = statement.executeQuery(sql); 

        while (result.next()){
            int id = result.getInt("id");
            String nom = result.getString("nom");
            String logo = result.getString("logo");
            String description = result.getString("description");
            String numTel = result.getString("numTel");
            String email = result.getString("email");
            String adresse = result.getString("adresse");
            String site = result.getString("site");
            int id_prop = result.getInt("id_prop");
            String ville = result.getString("ville");
            list.add(new Garderie(id,nom,logo,description,numTel,email,adresse,site,id_prop,ville)); 
        }
      
      } catch (SQLException ex) {
            Logger.getLogger(Garderie.class.getName()).log(Level.SEVERE, null, ex);}
             return (list); 
       }

   public ArrayList<Garderie> consulterGarderie3()
    {
        String sql= "SELECT * FROM `ecolegarderieclub` JOIN `demande` on `demande`.`id_egc`=`ecolegarderieclub`.`id` WHERE`demande`.`etat`='"+EtatDemandeAjout.EnTraitement+"' AND `ecolegarderieclub`.`type`='Garderie'";
        PreparedStatement statement;
        ArrayList<Garderie> list = new ArrayList<Garderie>(); 
       try {
        statement = cnx.prepareStatement(sql);
        ResultSet result = statement.executeQuery(sql); 

        while (result.next()){
            int id = result.getInt("id");
            String nom = result.getString("nom");
            String logo = result.getString("logo");
            String description = result.getString("description");
            String numTel = result.getString("numTel");
            String email = result.getString("email");
            String adresse = result.getString("adresse");
            String site = result.getString("site");
            int id_prop = result.getInt("id_prop");
            String ville = result.getString("ville");
            list.add(new Garderie(id,nom,logo,description,numTel,email,adresse,site,id_prop,ville)); 
        }
      
      } catch (SQLException ex) {
            Logger.getLogger(Garderie.class.getName()).log(Level.SEVERE, null, ex);}
             return (list); 
       }
      

    }
