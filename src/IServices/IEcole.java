/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IServices;

import edu.entites.Ecole;
import java.util.List;

/**
 *
 * @author windows
 */
public interface IEcole {
    
    public void AjouterEcole(Ecole E);

    public void SupprimerEcole(Ecole E);
    
    public void ModifierEcole(Ecole E);
    
    public Ecole chercherProduitParNom(String nom);

    public List<Ecole> lireEcole();
    
}
