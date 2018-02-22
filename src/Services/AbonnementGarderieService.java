/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import DataStorage.MyDB;
import IServices.IAbonnementGarderie;
import Utils.EtatAbonnement;
import edu.entites.AbonnementGarderie;
import edu.entites.Garderie;
import edu.entites.Parent;
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
public class AbonnementGarderieService implements IAbonnementGarderie{
    Connection cnx;
    public AbonnementGarderieService()
        {cnx = MyDB.getinstance().getConnexion(); }
    @Override
    public void AjoutAbonnement(AbonnementGarderie a) {
        String sql = "INSERT INTO `abonnement`(`etat`,`id_user`, `id_egc`) VALUES ('EnTraitement',?,?)";
       PreparedStatement statement;
        try {
       statement = cnx.prepareStatement(sql);
       statement.setInt(1, a.getParent().getId());
       statement.setInt(2, a.getGarderie().getId());
       
      
       int rowsInserted = statement.executeUpdate();
        if (rowsInserted > 0) {
            System.out.println("Abonnement ajouté ");}
        } catch (SQLException ex) {
            Logger.getLogger(AbonnementGarderieService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void ModifierEtat(AbonnementGarderie a, EtatAbonnement etat) {
        String sql = "UPDATE `abonnement` SET `etat`=? WHERE `id`=?";
        PreparedStatement statement;
        try {
       statement = cnx.prepareStatement(sql);
       statement.setString(1, etat.toString());
       statement.setInt(2,a.getId());
       int rowsInserted = statement.executeUpdate();
        if (rowsInserted > 0) {
            System.out.println( "Abonnement modifié  avec succées  ");}
         else{System.out.println("mechni 5edem");} 
        } catch (SQLException ex) {
            Logger.getLogger(AbonnementGarderieService.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
    }
    
    @Override
   public int Nb_AbonnementAttente(ProprietaireGarderie pg)
        {
       String sql = "SELECT COUNT(*) FROM abonnement join ecolegarderieclub on ecolegarderieclub.id=abonnement.id_egc WHERE etat ='"+EtatAbonnement.EnTraitement.toString()+"'AND ecolegarderieclub.id_prop='"+pg.getId()+"'" ; ;
       int nb = 0 ; 
       try {
        Statement statement = cnx.createStatement();
        ResultSet result = statement.executeQuery(sql);

        while (result.next()){
            nb = result.getInt("COUNT(*)");
        }
      
      } catch (SQLException ex) {
            Logger.getLogger(AbonnementGarderieService.class.getName()).log(Level.SEVERE, null, ex);}
             return (nb); 
    }

    @Override
   public int Nb_Abonnement(ProprietaireGarderie pg)
    {
      String sql = "SELECT COUNT(*) FROM abonnement join ecolegarderieclub on ecolegarderieclub.id=abonnement.id_egc WHERE etat ='"+EtatAbonnement.Acceptee.toString()+"'AND ecolegarderieclub.id_prop='"+pg.getId()+"'" ;
       int nb = 0 ; 
       try {
        Statement statement = cnx.createStatement();
        ResultSet result = statement.executeQuery(sql);

        while (result.next()){
            nb = result.getInt("COUNT(*)");
        }
      
      } catch (SQLException ex) {
             Logger.getLogger(AbonnementGarderieService.class.getName()).log(Level.SEVERE, null, ex);}
             return (nb);
    }

    @Override
     public ArrayList<Parent> ListerParentsAbonnees(Garderie g)
     {
        String sql = "SELECT * FROM `user` JOIN `abonnement` on `abonnement`.`id_user`=`user`.`id` WHERE`abonnement`.`etat`='Acceptee'and `abonnement`.`id_egc`= '"+g.getId()+"'";
        ArrayList<Parent> parents = new ArrayList<Parent>(); 
        
       try {
        Statement statement = cnx.createStatement();
        ResultSet result = statement.executeQuery(sql);
        while (result.next()){
            int id = result.getInt(1);
            String nom = result.getString("nom");
            String prenom = result.getString("prenom");
            String numTel = result.getString("numTel");
            String adresse = result.getString("adresse");
            String email = result.getString("email");
            String login = result.getString("login");
            String password = result.getString("password");
            String photo = result.getString("photo");
            parents.add(new Parent(id, nom, prenom, numTel, adresse, email, login, password, photo)); 
        }
      
      } catch (SQLException ex) {
            Logger.getLogger(AbonnementGarderieService.class.getName()).log(Level.SEVERE, null, ex);}
             return (parents); 
    }

    @Override
    public ArrayList<Parent>  ListerParentsEnattente (ProprietaireGarderie g )
    {
        String sql = "SELECT * FROM `user` JOIN `abonnement` on `abonnement`.`id_user`=`user`.`id` join ecolegarderieclub on ecolegarderieclub.id=`abonnement`.`id_egc` WHERE`abonnement`.`etat`='EnTraitement' and ecolegarderieclub.id_prop='"+g.getId()+"'";
        ArrayList<Parent> parents = new ArrayList<Parent>(); 
        
       try {
        Statement statement = cnx.createStatement();
        ResultSet result = statement.executeQuery(sql);
        while (result.next()){
            int id = result.getInt(1);
            String nom = result.getString("nom");
            String prenom = result.getString("prenom");
            String numTel = result.getString("numTel");
            String adresse = result.getString("adresse");
            String email = result.getString("email");
            String login = result.getString("login");
            String password = result.getString("password");
            String photo = result.getString("photo");
            parents.add(new Parent(id, nom, prenom, numTel, adresse, email, login, password, photo)); 
        }
      
      } catch (SQLException ex) {
            Logger.getLogger(AbonnementGarderieService.class.getName()).log(Level.SEVERE, null, ex);}
             return (parents); 
    }

    @Override
    public AbonnementGarderie RechercheParentAbonnement (Parent p ) {
      String sql = "SELECT * FROM `abonnement` JOIN `user` on `abonnement`.`id_user`=`user`.`id` WHERE `abonnement`.`id_user`= "+p.getId();
        AbonnementGarderie ag = null; 
       try {
        Statement statement = cnx.createStatement();
        ResultSet result = statement.executeQuery(sql);
        while (result.next()){
            int id = result.getInt("id");
            int id_user = result.getInt("id_user");
            int id_egc= result.getInt("id_egc");
            String etat = result.getString("etat");
            if (EtatAbonnement.Acceptee.toString().equals(etat))
            {
                ag = new AbonnementGarderie(id,EtatAbonnement.Acceptee, id_user, id_egc); 
            }
            else if (EtatAbonnement.EnTraitement.toString().equals(etat))
            {
                ag = new AbonnementGarderie(id,EtatAbonnement.EnTraitement, id_user, id_egc); 
            } 
            else if (EtatAbonnement.Refusee.toString().equals(etat))
            {
                ag = new AbonnementGarderie(id,EtatAbonnement.Refusee, id_user, id_egc); 
            } 
        }
      } catch (SQLException ex) {
            Logger.getLogger(AbonnementGarderieService.class.getName()).log(Level.SEVERE, null, ex);}
             return (ag); 
    }

   @Override
    public void supprimerDemandeAbonnement(AbonnementGarderie g) {
        
        String sql = "DELETE FROM `Abonnement` WHERE id=? ";
         PreparedStatement statement;
        try {
       statement = cnx.prepareStatement(sql);
       statement.setInt(1, g.getId());
       int rowsInserted = statement.executeUpdate();
        if (rowsInserted > 0) {
            System.out.println("Abonnement supprimé avec succées  ");}
        } catch (SQLException ex) {
            Logger.getLogger(AbonnementGarderieService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public AbonnementGarderie RechercherAbonnementGarderieParent(Parent p, Garderie g) {
        String sql = "SELECT * FROM `abonnement` WHERE `abonnement`.`id_user`= '"+p.getId()+"' AND `abonnement`.`id_egc`='"+g.getId()+"'";
        AbonnementGarderie ag = null; 
       try {
        Statement statement = cnx.createStatement();
        ResultSet result = statement.executeQuery(sql);
        while (result.next()){
            int id = result.getInt("id");
            int id_user = result.getInt("id_user");
            int id_egc= result.getInt("id_egc");
            String etat = result.getString("etat");
            if (EtatAbonnement.Acceptee.toString().equals(etat))
            {
                ag = new AbonnementGarderie(id,EtatAbonnement.Acceptee, id_user, id_egc); 
            }
            else if (EtatAbonnement.EnTraitement.toString().equals(etat))
            {
                ag = new AbonnementGarderie(id,EtatAbonnement.EnTraitement, id_user, id_egc); 
            } 
            else if (EtatAbonnement.Refusee.toString().equals(etat))
            {
                ag = new AbonnementGarderie(id,EtatAbonnement.Refusee, id_user, id_egc); 
            } 
        }
      } catch (SQLException ex) {
            Logger.getLogger(AbonnementGarderieService.class.getName()).log(Level.SEVERE, null, ex);}
             return (ag); 
    }
}
    

