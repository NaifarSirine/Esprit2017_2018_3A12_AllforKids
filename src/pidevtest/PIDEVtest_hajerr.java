/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidevtest;

import DataStorage.MyDB;
import Services.DemandeEcoleService;
import Services.EcoleService;
import Services.EvaluationEcoleService;
import Services.ProprietaireEcoleService;
import edu.entites.DemandeEcole;
import edu.entites.Ecole;
import edu.entites.EvaluationEcole;
import edu.entites.ProprietaireEcole;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author LENOVO
 */
public class PIDEVtest_hajerr {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MyDB.getinstance(); 
        
       // Ecole E1 = new Ecole("test","test","test","test","test","test","test","test", 100,"test");
//Ecole E1 = new Ecole("test","test");
       // Ecole E1 = new Ecole(0,"test","test","test","test","test","test","test", 100,"test");

       // EcoleService ae= new EcoleService();
       // ae.AjouterEcole(E1);
       
       //pop Ecole
       ProprietaireEcole pr1=new ProprietaireEcole(0, "bichou", "prenom" , "numTel" , "adresse ", "email", "login", "password", "5677");
               ProprietaireEcole pr2=new ProprietaireEcole(9, "hohososo", "prenom" , "numTel" , "ameni ", "email", "login", "password", "cin");
               ProprietaireEcole pr3=new ProprietaireEcole(8, "nom2", "hajer" , "hoho" , "soso ", "email", "login", "password", "cin");
       ProprietaireEcole pr4=new ProprietaireEcole(0, "nom", "prenom" , "numTel" , "adresse ", "email", "login", "password", "cin");

       
       //Evaluation
       EvaluationEcole eve= new EvaluationEcole(5,5,6,1);
             ProprietaireEcoleService apr=  new ProprietaireEcoleService();
          EvaluationEcoleService ees=new EvaluationEcoleService();
     //Ecole
       Ecole e=new Ecole(0, "sosololo", "logo","sosololo", "numTel", "email", "adresse", "site", 19, "ville");
       EcoleService es =new EcoleService();
       
       //Demande
        DemandeEcole de=new DemandeEcole(0, "preuve1", "preuve2","etat222", 19, 1);
         DemandeEcoleService des= new DemandeEcoleService();
        

//****************************
          // apr.AjouterProprietaireEcole(pr1);
          //  apr.AjouterProprietaireEcole(pr2);
           // apr.SupprimerProprietaireEcole(pr4);
          //apr.ModifierProprietaireEcole(pr2);
       // System.out.println(apr.consulterCompte(10));
        //*****
          //********
        // ees.AjouterEvaluationEcole(eve);
             //ees.ModifierEvaluationEcole(eve);
             
              //*****
          //********
        // es.AjouterEcole(e);
         // es.SupprimerEcole(e);
       // es.ModifierEcole(e);
    //System.out.println(es.ConsulterEvaluationEcole(10)).toString();
          
              //*****
          //********
        //  des.AjouterDemandeEcole(de);
//des.AjouterDemandeEcole(de);
          //des.ModifierDemandeEcole(de);
      ArrayList <DemandeEcole> list=new ArrayList<DemandeEcole>();
            list=des.consulterDemandeEcole();
            for(DemandeEcole b:list)
            {
                System.out.println(b.toString());
            }
          
    }     
    
}
