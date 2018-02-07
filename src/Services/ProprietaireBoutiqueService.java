/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import DataStorage.MyDB;
import IServices.IProprietaireBoutique;
import edu.entites.Boutique;
import edu.entites.ProprietaireGarderie;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author intel
 */
public class ProprietaireBoutiqueService implements IProprietaireBoutique{
  public Connection cnx ;

  public ProprietaireBoutiqueService()
        {cnx = MyDB.getinstance().getConnexion(); }
    @Override
    public void ajouterCompte(Boutique PB) {
         String sql = "INSERT INTO `user`( `nom`, `prenom`, `numTel`, `adresse`, `email`, `login`, `password`, `cin`, `role`  ) VALUES ( ? , ? , ? , ? , ? , ? , ? , ? , 'PGarderie')";
       PreparedStatement statement;
        try {
       statement = cnx.prepareStatement(sql);
       statement.setString(1, PB.getNom());
       statement.setString(2, PB.getPrenom());
       statement.setString(3, PB.getNumTel());
       statement.setString(4, PB.getAdresse()); 
       statement.setString(5, PB.getEmail());
       statement.setString(6, PB.getLogin());
       statement.setString(7, PB.getPassword());
       statement.setString(8, PB.getCin());
       int rowsInserted = statement.executeUpdate();
        if (rowsInserted > 0) {
            System.out.println("Propriétaire Boutique ajouté ");}
        } catch (SQLException ex) {
            System.out.println("echec");
        }
    }

    @Override
    public void modifierCompte(Boutique PB) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void supprimerCompte(Boutique PB) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boutique consulterCompte(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
