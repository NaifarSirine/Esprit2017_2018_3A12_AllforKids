/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IServices;

import edu.entites.Parent;
import edu.entites.Sujet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author intel
 */
public interface ISujet {
  public void ajouterSujet(Sujet s);
  public void supprimerSujet(Sujet s);
  public ArrayList<Sujet> rechercherSujets();
  public ArrayList<Sujet> consulterSujet(); 
    
    
}
