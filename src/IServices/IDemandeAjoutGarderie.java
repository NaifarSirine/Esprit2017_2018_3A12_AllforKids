/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IServices;

import Utils.EtatDemandeAjoutGarderie;
import edu.entites.DemandeAjoutGarderie;

/**
 *
 * @author PC
 */
public interface IDemandeAjoutGarderie {
    public void modifierEtat(int id,EtatDemandeAjoutGarderie etat );
    public void ajouterDemandeAjoutGarderie(DemandeAjoutGarderie DAG);
}
