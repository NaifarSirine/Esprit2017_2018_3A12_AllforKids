/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IServices;

import edu.entites.EvaluationGarderie;
import edu.entites.Garderie;
import java.util.ArrayList;

/**
 *
 * @author PC
 */
public interface IEvaluationGarderie {
    public void ajouterEvaluationGarderie(EvaluationGarderie E) ;
    public void modifierEvaluationGarderie(EvaluationGarderie E);
    public ArrayList<EvaluationGarderie> consulterEvaluationGarderie(int id_egc);
    public float CalculerMoyenneNote(int id_garderie);
    public EvaluationGarderie RechercheEvaluationParent(edu.entites.Parent p,Garderie g);
    
}
