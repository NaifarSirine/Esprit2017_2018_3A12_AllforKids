/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IServices;

import Utils.EtatDemandeAjout;
import edu.entites.DemandeClub;
import java.util.ArrayList;
import java.util.List;
import java.util.List;


/**
 *
 * @author hamma
 */
public interface IDemandeClub {
     public void ajouterdemande(DemandeClub d);
     public void modifierEtat(int id, EtatDemandeAjout etat);
     public ArrayList<DemandeClub> consulterDemandeAjoutClub();
    
}
