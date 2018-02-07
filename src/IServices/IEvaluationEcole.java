/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IServices;

import edu.entites.EvaluationEcole;
import edu.entites.ProprietaireEcole;

/**
 *
 * @author windows
 */
public interface IEvaluationEcole {
    
     public void AjouterEvaluationEcole(EvaluationEcole ee);
     public void ModifierEvaluationEcole(EvaluationEcole ee);
     public EvaluationEcole ConsulterEvaluationEcole(int id_egc);
}
