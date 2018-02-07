/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IServices;

import edu.entites.Ecole;
import edu.entites.ProprietaireEcole;
import java.util.List;

/**
 *
 * @author windows
 */
public interface IProprietaireEcole {
    
     public void AjouterProprietaireEcole(ProprietaireEcole pe);

    public void SupprimerProprietaireEcole(ProprietaireEcole pe);
    
    public void ModifierProprietaireEcole(ProprietaireEcole pe);
    
   // public ProprietaireEcole chercherProduitParNom(String nom);
    public ProprietaireEcole consulterCompte(int id) ;
    
    
    
}
