/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidevtest;

import DataStorage.MyDB;
import Services.ProprietaireBoutiqueService;
import edu.entites.Boutique;
/**
 *
 * @author intel
 */
public class PIDEVtest_bechir {
    
    
      public static void main(String[] args) {
        MyDB.getinstance(); 
        
          Boutique b1=new Boutique(0, "hajer", "harbaoui", "25145214", "sfax", "hajer@gmail.com", "hajer", "harbaoui", "113254784");
    ProprietaireBoutiqueService PBS = new ProprietaireBoutiqueService();
    PBS.ajouterCompte(b1);
    
    
      }
}
