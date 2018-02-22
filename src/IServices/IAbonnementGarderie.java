/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IServices;

import Utils.EtatAbonnement;
import com.mysql.jdbc.exceptions.DeadlockTimeoutRollbackMarker;
import edu.entites.AbonnementGarderie;
import edu.entites.Garderie;
import edu.entites.Parent;
import edu.entites.ProprietaireGarderie;
import java.util.ArrayList;


/**
 *
 * @author LENOVO
 */
public interface IAbonnementGarderie {
        public void AjoutAbonnement ( AbonnementGarderie a);
        public void ModifierEtat (AbonnementGarderie a , EtatAbonnement etat);
        public ArrayList<Parent>  ListerParentsEnattente (ProprietaireGarderie g );
        public ArrayList<Parent> ListerParentsAbonnees(Garderie g);
        public AbonnementGarderie RechercheParentAbonnement (Parent p );
        public int Nb_AbonnementAttente(ProprietaireGarderie pg);
        public int Nb_Abonnement(ProprietaireGarderie pg);
        public void supprimerDemandeAbonnement(AbonnementGarderie g); 
        public AbonnementGarderie RechercherAbonnementGarderieParent(Parent p,Garderie g);
}
