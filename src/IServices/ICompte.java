/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IServices;

import java.util.List;

import edu.entites.ProprietaireClub;
import java.util.List;



/**P
 *
 * @author hamma
 */
public interface ICompte {
    
    public void ajouterCompte(ProprietaireClub p);
    public void supprimerCompte(ProprietaireClub p);
    public void modifierCompte(ProprietaireClub p);
     public ProprietaireClub consulterProprietaireClubs(int id);
    
    
}
