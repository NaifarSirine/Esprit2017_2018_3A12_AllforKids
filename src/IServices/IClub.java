/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IServices;

import edu.entites.Club;
import java.util.List;

/**
 *
 * @author hamma
 */
public interface IClub {
     public void ajouterClub(Club c);
    public void supprimerClub(Club c);
    public void modifierClub(Club c);
    public List<Club> consulterClubs();
    public Club chercherClubs(String nom);
}
