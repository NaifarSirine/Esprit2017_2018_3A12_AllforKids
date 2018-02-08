/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IServices;

import edu.entites.Boutique;
import edu.entites.ProprietaireGarderie;

/**
 *
 * @author intel
 */
public interface IProprietaireBoutique {
       public void ajouterCompte(Boutique PB );
   public void modifierCompte (Boutique PB );
   public void supprimerCompte (Boutique PB  );
   public Boutique consulterCompte (int id);
}
