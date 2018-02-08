/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import DataStorage.MyDB;
import IServices.IDemandeAjoutGarderie;
import Utils.EtatDemandeAjout;
import edu.entites.DemandeAjoutGarderie;
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
public class DemandeAjoutGarderieService implements IDemandeAjoutGarderie {
    public Connection cnx ;
    public DemandeAjoutGarderieService()
        {cnx = MyDB.getinstance().getConnexion(); }
    @Override
    public void modifierEtat(int id, EtatDemandeAjout etat) {
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
        
       String sql = "INSERT INTO `demande`(`preuve1`, `preuve2`, `etat`, `id_user`,`id_egc`) VALUES (?,?,'EnTraitement',?,?)";
       PreparedStatement statement;
        try {
       statement = cnx.prepareStatement(sql);
       statement.setString(1, DAG.getPreuve());
       statement.setString(2, DAG.getPreuve2());
       statement.setInt(3, DAG.getId_user());
       statement.setInt(4, DAG.getId_egc());
       int rowsInserted = statement.executeUpdate();
        if (rowsInserted > 0) {
            System.out.println("Demande Ajout Garderie  ajouté ");}
        } catch (SQLException ex) {
            Logger.getLogger(DemandeAjoutGarderie.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ArrayList<DemandeAjoutGarderie> consulterDemandeAjoutGarderie() { //les demandes en traitement 
     String sql="SELECT * FROM `demande` JOIN `ecolegarderieclub` on `ecolegarderieclub`.`id`=`demande`.`id_egc` WHERE `ecolegarderieclub`.`type`='Garderie' AND `demande`.`etat`='"+EtatDemandeAjout.EnTraitement+"'";
     PreparedStatement statement;
        ArrayList<DemandeAjoutGarderie> list = new ArrayList<DemandeAjoutGarderie>(); 
       try {
        statement = cnx.prepareStatement(sql);
        ResultSet result = statement.executeQuery(sql); 

        while (result.next()){
            int id = result.getInt("id");
            String preuve1 = result.getString("preuve1");
            String preuve2 = result.getString("preuve2");
            int id_user = result.getInt("id_user");
            int id_egc = result.getInt("id_egc");
            list.add(new DemandeAjoutGarderie(id,preuve1,preuve2,EtatDemandeAjout.EnTraitement,id_user,id_egc)); 
        }
      
      } catch (SQLException ex) {
            Logger.getLogger(DemandeAjoutGarderie.class.getName()).log(Level.SEVERE, null, ex);}
             return (list); 
    }
 
    @Override
          public int compterNombreDemandeEnTraitement() {
              String sql = "SELECT COUNT(*) FROM `demande` JOIN `ecolegarderieclub` on `ecolegarderieclub`.`id`=`demande`.`id_egc` WHERE `ecolegarderieclub`.`type`='Garderie' AND `demande`.`etat`='"+EtatDemandeAjout.EnTraitement+"'";
       int nb = 0 ; 
       try {
        Statement statement = cnx.createStatement();
        ResultSet result = statement.executeQuery(sql);

        while (result.next()){
            nb = result.getInt("COUNT(*)");
        }
      
      } catch (SQLException ex) {
            Logger.getLogger(BabySitterService.class.getName()).log(Level.SEVERE, null, ex);}
             return (nb); 
    }    
}
    
    

