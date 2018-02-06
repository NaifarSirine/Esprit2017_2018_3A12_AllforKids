/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IServices;

import edu.entites.Garderie;
import java.util.List;

/**
 *
 * @author PC
 */
public interface IGarderie {
    
   public void ajouterGarderie(Garderie G);
   public void modifierGarderie (Garderie G);
   public void supprimerGarderie (int id );
   public Garderie rechercheGarderie(String nom);
   public List<Garderie> consulterGarderie ();
    
}
