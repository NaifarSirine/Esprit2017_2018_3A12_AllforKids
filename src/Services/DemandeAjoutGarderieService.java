/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import DataStorage.MyDB;
import IServices.IDemandeAjoutGarderie;
import Utils.EtatDemandeAjoutGarderie;
import edu.entites.DemandeAjoutGarderie;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class DemandeAjoutGarderieService implements IDemandeAjoutGarderie {
    public Connection cnx ;
    public DemandeAjoutGarderieService()
        {cnx = MyDB.getinstance().getConnexion(); }
    @Override
    public void modifierEtat(int id, EtatDemandeAjoutGarderie etat) {
        String sql = "UPDATE `demande` SET `etat`=? WHERE id=?";
        PreparedStatement statement;
        try {
       statement = cnx.prepareStatement(sql);
       String e=etat.toString();
       statement.setString(1,e);
       statement.setInt(2,id);
       int rowsInserted = statement.executeUpdate();
        if (rowsInserted > 0) {
            System.out.println("Demande Ajout Garderie modifié avec succées  ");}
        } catch (SQLException ex) {
            Logger.getLogger(DemandeAjoutGarderie.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void ajouterDemandeAjoutGarderie(DemandeAjoutGarderie DAG) {
        
       String sql = "INSERT INTO `demande`(`preuve1`, `preuve2`, `etat`, `id_user`) VALUES (?,?,'EnTraitement',?)";
       PreparedStatement statement;
        try {
       statement = cnx.prepareStatement(sql);
       statement.setString(1, DAG.getPreuve());
       statement.setString(2, DAG.getPreuve2());
       statement.setInt(3, DAG.getId_user());
       int rowsInserted = statement.executeUpdate();
        if (rowsInserted > 0) {
            System.out.println("Demande Ajout Garderie  ajouté ");}
        } catch (SQLException ex) {
            Logger.getLogger(DemandeAjoutGarderie.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
