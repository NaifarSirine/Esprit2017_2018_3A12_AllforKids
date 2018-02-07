/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IServices;

import edu.entites.DemandeEcole;
import edu.entites.ProprietaireEcole;
import java.util.ArrayList;

/**
 *
 * @author windows
 */
public interface IDemandeEcole {
    
     public void AjouterDemandeEcole(DemandeEcole de);
      public void ModifierDemandeEcole(DemandeEcole de);
    public ArrayList<DemandeEcole> consulterDemandeEcole();
    
}
