/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IServices;

import edu.entites.Admin;
import edu.entites.BabySitter;
import edu.entites.DemandeBabySitter;
import edu.entites.EvaluationBabySitter;
import java.util.ArrayList;

/**
 *
 * @author LENOVO
 */
public interface IEvaluationBabySitter {
       public void ajoutEvaluation (EvaluationBabySitter e );
       public void modifierEvaluation (EvaluationBabySitter e , int nb  );
       public ArrayList<EvaluationBabySitter> rechercheEvaluationBabySitter (BabySitter b );
       public ArrayList<EvaluationBabySitter> listerEvaluationBabySitter ();
}
