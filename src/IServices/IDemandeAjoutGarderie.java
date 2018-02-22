/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IServices;

import Utils.EtatDemandeAjout;
import edu.entites.DemandeAjoutGarderie;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PC
 */
public interface IDemandeAjoutGarderie {
    public void modifierEtat(int id,EtatDemandeAjout etat );
    public void ajouterDemandeAjoutGarderie(DemandeAjoutGarderie DAG);
    public ArrayList<DemandeAjoutGarderie> consulterDemandeAjoutGarderie();
    public int compterNombreDemandeEnTraitement();
    public List<DemandeAjoutGarderie> consulterDGarderie(int id_p);
    public DemandeAjoutGarderie consulterDemandeGarderie(int idGarderie);
}
