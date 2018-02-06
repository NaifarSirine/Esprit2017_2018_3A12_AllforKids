/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import DataStorage.MyDB;
import IServices.IGarderie;
import edu.entites.Garderie;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
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
        String sql = "INSERT INTO `ecolegarderieclub`(`nom`, `logo`, `type`, `description`, `numTel`, `email`, `adresse`, `site`, `id_prop`, `ville`) VALUES"
                + "                                  (?,?,'Garderie',?,?,?,?,?,?,?)";
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void supprimerGarderie(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Garderie rechercheGarderie(String nom) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Garderie> consulterGarderie() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
