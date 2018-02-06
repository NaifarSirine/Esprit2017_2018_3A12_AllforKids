/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IServices;

import edu.entites.ProprietaireGarderie;

/**
 *
 * @author PC
 */
public interface IProprietaireGarderie {
    
   public void ajouterCompte(ProprietaireGarderie PG );
   public void modifierCompte (ProprietaireGarderie PG );
   public void supprimerCompte (ProprietaireGarderie PG  );
   public ProprietaireGarderie consulterCompte (int id);
}
