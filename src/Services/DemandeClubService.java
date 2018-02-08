/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import IServices.IDemandeClub;
import edu.entites.DemandeClub;
import java.util.List;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import DataStorage.MyDB;
import Utils.EtatDemandeAjout;
import edu.entites.Club;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author hamma
 */
public class DemandeClubService implements IDemandeClub{
Connection connexion;
    public DemandeClubService() {
        connexion = MyDB.getinstance().getConnexion();
    }
    /*@Override
    public void ajouterdemande(DemandeClub d) {
        String sql = "INSERT INTO `demande`(`preuve1`,`preuve2`,`etat`,`id_user`,`id_egc`)VALUES(?,?,?,?,?)";
   PreparedStatement statement;
   
        try {
       statement = connexion.prepareStatement(sql);
 
       statement.setInt(1,d.getId());
       statement.setString(2,d.getPreuve1());
       statement.setString(3,d.getPreuve2());
       statement.setString(4,d.getEtat());
       statement.setInt(5,d.getId_user());
       statement.setInt(6,d.getId_egc());
              System.out.println(sql);
          
         int rowsInserted = statement.executeUpdate();
         if (rowsInserted > 0) {
            System.out.println("**************demande  ajouté************* ");}
        } catch (SQLException ex) {
            System.out.println("**************echec d'ajout***********");
        }}*/
//***********
     @Override
    public void ajouterdemande(DemandeClub d) {
        
       String sql = "INSERT INTO `demande`(`preuve1`, `preuve2`, `etat`, `id_user`,`id_egc`) VALUES (?,?,'EnTraitement',?,?)";
       PreparedStatement statement;
        try {
       statement = connexion.prepareStatement(sql);
       statement.setString(1, d.getPreuve1());
       statement.setString(2, d.getPreuve2());
       statement.setInt(3, d.getId_user());
       statement.setInt(4, d.getId_egc());
       int rowsInserted = statement.executeUpdate();
        if (rowsInserted > 0) {
            System.out.println("Demande Ajout Club  ajouté ");}
        } catch (SQLException ex) {
            System.out.println("echec");
        }
    }
    @Override
public void modifierEtat(int id, EtatDemandeAjout etat) {
        String sql = "UPDATE demande SET `etat`=? WHERE id=?";
        PreparedStatement statement;
        try {
       statement = connexion.prepareStatement(sql);
       String e=etat.toString();
       statement.setString(1,e);
       statement.setInt(2,id);
       int rowsInserted = statement.executeUpdate();
        if (rowsInserted > 0) {
            System.out.println("Demande Ajout Club modifié avec succées  ");}
        } catch (SQLException ex) {
            Logger.getLogger(DemandeClub.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
//**********
@Override
 public ArrayList<DemandeClub> consulterDemandeAjoutClub() { 
     String sql="SELECT * FROM demande WHERE etat='"+EtatDemandeAjout.EnTraitement+"'";
     PreparedStatement statement;
        ArrayList<DemandeClub> list = new ArrayList<DemandeClub>(); 
       try {
        statement = connexion.prepareStatement(sql);
        ResultSet result = statement.executeQuery(sql); 

        while (result.next()){
            int id = result.getInt("id");
            String preuve1 = result.getString("preuve1");
            String preuve2 = result.getString("preuve2");
            int id_user = result.getInt("id_user");
            int id_egc = result.getInt("id_egc");
            list.add(new DemandeClub(id,preuve1,preuve2,EtatDemandeAjout.EnTraitement,id_user,id_egc)); 
        }
      
      } catch (SQLException ex) {
            Logger.getLogger(DemandeClub.class.getName()).log(Level.SEVERE, null, ex);}
             return (list); 
    }
    
    }
    

