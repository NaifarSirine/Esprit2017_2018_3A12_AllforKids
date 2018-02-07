/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import DataStorage.MyDB;
import IServices.IParent;
import edu.entites.Parent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author intel
 */
public class ParentService implements IParent{
      Connection cnx;
    public ParentService() {
        cnx = MyDB.getinstance().getConnexion();
    }

    @Override
    public void ajouterCompte(Parent b) {
     String sql = "INSERT INTO `user`( `nom`, `prenom`, `numTel`, `adresse`, `email`, `login`, `password`, `photo` , `role`  ) VALUES ( ? , ? , ? , ? , ? , ? , ? , ?  , 'Parent')";
       PreparedStatement statement;
        try {
       statement = cnx.prepareStatement(sql);
       statement.setString(1, b.getNom());
       statement.setString(2, b.getPrenom());
       statement.setString(3, b.getNumTel());
       statement.setString(4, b.getAdresse()); 
       statement.setString(5, b.getEmail());
       statement.setString(6, b.getLogin());
       statement.setString(7, b.getPassword());
       statement.setString(8, b.getPhoto());
       
       
       int rowsInserted = statement.executeUpdate();
        if (rowsInserted > 0) {
            System.out.println("Parent ajouté ");}
        } catch (SQLException ex) {
            Logger.getLogger(ParentService.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
    }

    @Override
    public void supprimerCompte(Parent c) {
         String sql = "DELETE FROM user WHERE id = ? ";
 try { 
        PreparedStatement statement = cnx.prepareStatement(sql);
        statement.setInt(1, c.getId());

        int rowsDeleted = statement.executeUpdate();
        if (rowsDeleted > 0) {
            System.out.println("parent supprimé");}
         } catch (SQLException ex) {
            Logger.getLogger(ParentService.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

      @Override
    public void modifierCompte(Parent c) {
 
    String sql = "UPDATE `user` SET numTel =?,`adresse`=?,`email`=?,`login`=?,`password`=?,`photo`=? WHERE id = ? ";
 
 PreparedStatement statement;
     try {
  statement = cnx.prepareStatement(sql);
    
       statement.setString(1, c.getNumTel()); 
       statement.setString(2, c.getAdresse());
       statement.setString(3, c.getEmail());
       statement.setString(4, c.getLogin());
       statement.setString(5, c.getPassword());
        statement.setString(6, c.getPhoto());
      statement.setInt(7, c.getId());
         System.out.println("modification valider");
       int rowsUpdated = statement.executeUpdate();
     } catch (SQLException ex) {
         System.out.println("echec");
     
} }
    

    
    
    /*  public List<Parent> listParents() 
    {
                List<Parent> lv=new ArrayList<>();
        try 
        {
        String select = "SELECT Id, nom, prenom, numtel, adresse, email, login, password, photo FROM user";
        Statement statement1 = cnx.createStatement();
        
        ResultSet result = statement1.executeQuery(select);
        
        while (result.next()) 
        {
            Parent c = new Parent();
            
            c.setId(result.getInt("id"));
            c.setNom(result.getString("nom"));
            c.setPrenom(result.getString("prenom"));
            c.setNumTel(result.getString("numtel"));
            c.setAdresse(result.getString("Adresse"));
            c.setEmail(result.getString("email"));
            c.setLogin(result.getString("login"));
            c.setPassword(result.getString("password"));
            c.setPhoto(result.getString("photo"));
          
            
            lv.add(c);

        } 
    }   
        catch (SQLException e)
                {
                    System.err.println("SQLException: "+e.getMessage());
                    System.err.println("SQLSTATE: "+e.getSQLState());
                    System.err.println("VnedorError: "+e.getErrorCode());
                }
        return lv;
}

    @Override
    public List<Parent> consulterParents() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/
    
      @Override
public Parent consulterCompte(int id) { 
        Parent P=new Parent();
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
                  P.setPhoto(result.getString(9));
                  
            }
        } catch (SQLException ex) {
            Logger.getLogger(ParentService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return P;
        
    } 

}

    
    

