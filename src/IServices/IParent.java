/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IServices;

import edu.entites.Parent;
import java.util.List;

/**
 *
 * @author intel
 */
public interface IParent {
    
 public void ajouterCompte(Parent c);

    public void supprimerCompte(Parent c);

   public void modifierCompte (Parent c);
 public Parent consulterCompte(int id);  
}