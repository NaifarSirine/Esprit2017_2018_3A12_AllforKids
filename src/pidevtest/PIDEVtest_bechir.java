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
import Services.CommentaireService;
import Services.ParentService;
import Services.SujetService;
import edu.entites.Commentaire;
import edu.entites.Parent;
import edu.entites.Sujet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import static java.util.Collections.list;

/**
 *
 * @author LENOVO
 */
public class PIDEVtest_bechir {
     static Connection connexion;
    static Statement state;
    final static String url = "jdbc:mysql://localhost/pi_bd";
    final static String user = "root";
    final static String password = "";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MyDB.getinstance(); 
                     Parent c1=new Parent(12, "ameni","lefi", "12542648", "tunis", "ameni@gmail.com", "ameni", "lefi","sirine");
                     Parent c=new Parent(13, "ameni","lefi", "12542648", "tunis", "ameni@gmail.com", "ahmed", "lefi","sirine");
       
                 ParentService ps = new ParentService();
        
               // ps.ajouterCompte(c1);
              //  ps.modifierCompte(c);
              //  ps.supprimerCompte(c1);
             //System.out.println(ps.consulterCompte(13).toString());
                 
      Sujet s = new  Sujet(14, "probleme probleme ",1);
      Sujet s1 = new  Sujet(6, "probleme avec ameni ",9);
      SujetService ss =new SujetService();
      //ss.ajouterSujet(s1);
     // ss.supprimerSujet(s1);
     /* ArrayList<Sujet> liste=new ArrayList<Sujet>();
        liste=ss.consulterSujet();
        for(Sujet S:liste){
        System.out.println(s.toString());
                 }
        */   
        ArrayList<Sujet> list =new ArrayList<Sujet>();
    list=ss.rechercherSujets();
    for(Sujet d:list){
        System.out.println(s.toString());
    }
      
      
                Commentaire cm1 = new Commentaire(0, "merci ",1,9);

        Commentaire cm = new Commentaire(0, "merci pour votre attention",1,13);
        CommentaireService cc = new CommentaireService();
     //cc.ajouterCommentaire(cm);
     //cc.ajouterCommentaire(cm1);
   // cc.supprimerCommentaire(cm);
    
          /* ArrayList<Commentaire> liste=new ArrayList<Commentaire>();
                 liste=cc.consulterCommentaire();
                 for(Commentaire b:liste)
                 {
                     System.out.println(b.toString());
                 }
    */
  
    }
      
}
             
    


