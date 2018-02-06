/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import DataStorage.MyDB;
import IServices.IGarderie;
import Utils.EtatDemandeAjoutGarderie;
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
       statement.setInt(8, G.getId_prop());
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
        
        String sql = "UPDATE `ecolegarderieclub` SET `logo`=?,`description`=?,`numTel`=?,`email`=?,`adresse`=?,`site`=?,`ville`=? WHERE `id`=?";
        PreparedStatement statement;
        try {
       statement = cnx.prepareStatement(sql);
       statement.setString(1, G.getLogo());
       statement.setString(2, G.getDescription());
       statement.setString(3, G.getNumTel());
       statement.setString(4, G.getEmail()); 
       statement.setString(5, G.getAdresse());
       statement.setString(6, G.getSite());
       statement.setString(7, G.getVille());
       statement.setInt(8, G.getId());
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
//        Garderie P= new Garderie();
//        String sql = "SELECT * FROM `ecolegarderieclub` join demande on demande.id_user=ecolegarderieclub.id_prop  WHERE nom='"+nom+"'";
//        PreparedStatement statement;
//        try {
//            statement = cnx.prepareStatement(sql);
//            ResultSet result = statement.executeQuery(sql); 
//            while (result.next())
//            {
//                  P.setId(result.getInt("id"));                 
//                  P.setNom(result.getString("nom"));
//                  P.setLogo(result.getString("logo"));
//                  P.setDescription(result.getString("description"));
//                  P.setNumTel(result.getString("numTel"));
//                  P.setEmail(result.getString("email"));
//                  P.setAdresse(result.getString("adresse"));
//                  P.setSite(result.getString("site"));
//                  P.setId_prop(result.getInt("id_prop"));
//                  P.setVille(result.getString("ville"));     
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(Garderie.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return P;
return null;
    }

    @Override
    public ArrayList<Garderie> consulterGarderie() {
//        String sql = "SELECT * FROM `ecolegarderieclub` join demande on demande.id_user=ecolegarderieclub.id_prop  WHERE  demande.etat='"+EtatDemandeAjoutGarderie.Acceptee+"'" ;
//        PreparedStatement statement;
//        ArrayList<Garderie> list = new ArrayList<Garderie>(); 
//       try {
//        statement = cnx.prepareStatement(sql);
//        ResultSet result = statement.executeQuery(sql); 
//
//        while (result.next()){
//            int id = result.getInt("id");
//            String nom = result.getString("nom");
//            String logo = result.getString("logo");
//            String description = result.getString("description");
//            String numTel = result.getString("numTel");
//            String email = result.getString("email");
//            String adresse = result.getString("adresse");
//            String site = result.getString("site");
//            int id_prop = result.getInt("id_prop");
//            String ville = result.getString("ville");
//            list.add(new Garderie(id,nom,logo,description,numTel,email,adresse,site,id_prop,ville)); 
//        }
//      
//      } catch (SQLException ex) {
//            Logger.getLogger(Garderie.class.getName()).log(Level.SEVERE, null, ex);}
//             return (list); 
                return null;  }
//     //String sql = "SELECT  `ecolegarderieclub`.`nom`, `logo`, `type`, `description`, `ecolegarderieclub`.`numTel`, `ecolegarderieclub`.`email`, `ecolegarderieclub`.`adresse`, `ville`, `site`, `typeClub`, `user`.`nom` ,`user`.`prenom`,`user`.`numTel`,`user`.`email` "
//              // + "FROM `ecolegarderieclub` Join `user` ON `user`.`id`=`ecolegarderieclub`.`id_prop` +
  @Override
   public ArrayList<Garderie> consulterGarderie(int id_p)//leprop consulte tous ses garderies 
    {
//        String sql= "SELECT * FROM `ecolegarderieclub` join demande on demande.id_user=ecolegarderieclub.id_prop  WHERE `id_prop`'"+id_p+"' and demande.etat='"+EtatDemandeAjoutGarderie.Acceptee+"'";
//        PreparedStatement statement;
//        ArrayList<Garderie> list = new ArrayList<Garderie>(); 
//       try {
//        statement = cnx.prepareStatement(sql);
//        ResultSet result = statement.executeQuery(sql); 
//
//        while (result.next()){
//            int id = result.getInt("id");
//            String nom = result.getString("nom");
//            String logo = result.getString("logo");
//            String description = result.getString("description");
//            String numTel = result.getString("numTel");
//            String email = result.getString("email");
//            String adresse = result.getString("adresse");
//            String site = result.getString("site");
//            int id_prop = result.getInt("id_prop");
//            String ville = result.getString("ville");
//            list.add(new Garderie(id,nom,logo,description,numTel,email,adresse,site,id_prop,ville)); 
//        }
//      
//      } catch (SQLException ex) {
//            Logger.getLogger(Garderie.class.getName()).log(Level.SEVERE, null, ex);}
//             return (list); 
      return null; }

    @Override
    public ArrayList<Garderie> rechercherGarderie(String ville) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    }
