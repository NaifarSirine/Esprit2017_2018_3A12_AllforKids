/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IServices;

import edu.entites.Commentaire;
import edu.entites.Sujet;
import java.util.ArrayList;

/**
 *
 * @author intel
 */
public interface ICommentaire {
    
    
     public void ajouterCommentaire(Commentaire cm);
  public void supprimerCommentaire(Commentaire cm);
   public ArrayList<Commentaire> consulterCommentaire(); 
}
