/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidevtest;

import DataStorage.MyDB;
import Services.CommentaireService;
import Services.DemandeAjoutGarderieService;
import Services.DemandeEcoleService;
import Services.EcoleService;
import Services.EvaluationEcoleService;
import Services.EvaluationGarderieService;
import Services.GarderieService;

import Services.ProprietaireEcoleService;

import Services.ParentService;

import Services.ProprietaireGarderieService;
import Services.SujetService;
import Utils.EtatDemandeAjoutGarderie;
import edu.entites.Commentaire;
import edu.entites.DemandeAjoutGarderie;
import edu.entites.DemandeEcole;
import edu.entites.Ecole;
import edu.entites.EvaluationEcole;
import edu.entites.EvaluationGarderie;
import edu.entites.Garderie;
import edu.entites.ProprietaireEcole;

import edu.entites.Parent;

import edu.entites.ProprietaireGarderie;
import edu.entites.Sujet;
import java.util.ArrayList;



/**
 *
 * @author LENOVO
 */
public class PIDEVtest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MyDB.getinstance(); 
        
////        ProprietaireGarderie PG =new ProprietaireGarderie(0,"soso","soso","97897512","Tunis","soso@esprit.tn","soso","hellososo","11223344");
//        ProprietaireGarderie PG1 =new ProprietaireGarderie(7,"sosohoho","soso","97897512","Tunis","sosohoho@esprit.tn","soso","hellososohoho","11223344");
//        ProprietaireGarderieService PGS=new ProprietaireGarderieService();
//        //PGS.ajouterCompte(PG);
//        //PGS.modifierCompte(PG1);
//        //PGS.supprimerCompte(PG1);
//         //System.out.println(PGS.consulterCompte(16).toString());
//        EvaluationGarderie E=new EvaluationGarderie(0,15,16,1);
//        EvaluationGarderie E1=new EvaluationGarderie(5,5,16,1);
//        EvaluationGarderieService ES=new EvaluationGarderieService();
//        //ES.ajouterEvaluationGarderie(E);
//      // ES.modifierEvaluationGarderie(E1);
//        DemandeAjoutGarderie D=new DemandeAjoutGarderie(0,"hello","hello2", EtatDemandeAjoutGarderie.EnTraitement,16,1);
//        DemandeAjoutGarderieService DAS=new DemandeAjoutGarderieService();
//        //DAS.ajouterDemandeAjoutGarderie(D);
//        //DAS.modifierEtat(2, EtatDemandeAjoutGarderie.EnTraitement);
//        //ArrayList<DemandeAjoutGarderie> Liste= DAS.consulterDemandeAjoutGarderie();
//         //for(DemandeAjoutGarderie DAG1:Liste)
//       //{
//          // System.out.println(DAG1.toString());
//       //}
//        Garderie G=new Garderie(0,"test","test","test","test","test","test","test",6,"tunis");
//        Garderie G1=new Garderie(2,"test","testallo","test","test","test","test","test",6,"Bizerte");
//        GarderieService GS=new GarderieService();
//         //GS.ajouterGarderie(G);
//        //GS.modifierGarderie(G1);
//        //GS.supprimerGarderie(G1);
//        //System.out.println(GS.rechercheGarderie("test").toString());
////        ArrayList<Garderie> ListGarderie= GS.consulterGarderie();
////        for(Garderie G3:ListGarderie)
////        {
////            System.out.println(G3.toString());
////        }
//
//    //***************************bech
//                     Parent c1=new Parent(12, "ameni","lefi", "12542648", "tunis", "ameni@gmail.com", "ameni", "lefi","sirine");
//                     Parent c=new Parent(13, "ameni","lefi", "12542648", "tunis", "ameni@gmail.com", "ahmed", "lefi","sirine");
//                     ParentService ps = new ParentService();
//        
//                                                         // ps.ajouterCompte(c1);
//                                                         //  ps.modifierCompte(c);
//                                                         //  ps.supprimerCompte(c1);
//                                                         //System.out.println(ps.consulterCompte(13).toString());
//                 
//                     Sujet s = new  Sujet(14, "probleme probleme ",1);
//                     Sujet s1 = new  Sujet(6, "probleme avec ameni ",9);
//                     SujetService ss =new SujetService();
//
//                                                         //ss.ajouterSujet(s1);
//                                                         // ss.supprimerSujet(s1);
//
//                                                         /* ArrayList<Sujet> liste=new ArrayList<Sujet>();
//                                                            liste=ss.consulterSujet();
//                                                            for(Sujet S:liste){
//                                                            System.out.println(s.toString());
//                                                                                               }*/
//                                                                                              
//                                                         /* ArrayList<Sujet> list =new ArrayList<Sujet>();
//                                                            list=ss.rechercherSujets();
//                                                            for(Sujet d:list){
//                                                            System.out.println(s.toString());
//                                                                            }*/
//      
//      
//                   Commentaire cm1 = new Commentaire(0, "merci ",1,9);
//                   Commentaire cm = new Commentaire(0, "merci pour votre attention",1,13);
//                   CommentaireService cc = new CommentaireService();
//
//                                                         // cc.ajouterCommentaire(cm);
//                                                         // cc.ajouterCommentaire(cm1);
//                                                         // cc.supprimerCommentaire(cm);
//    
//                                                        /* ArrayList<Commentaire> liste=new ArrayList<Commentaire>();
//                                                           liste=cc.consulterCommentaire();{
//                                                           for(Commentaire b:liste)
//                                                           System.out.println(b.toString());
//                                                                              } */
//
//
//}
//
//         //System.out.println(GS.rechercheGarderie("soso").toString());
//        //*********************hajer**********************************
//        ProprietaireEcole pr1=new ProprietaireEcole(0, "bichou", "prenom" , "numTel" , "adresse ", "email", "login", "password", "5677");
//               ProprietaireEcole pr2=new ProprietaireEcole(9, "hohososo", "prenom" , "numTel" , "ameni ", "email", "login", "password", "cin");
//               ProprietaireEcole pr3=new ProprietaireEcole(8, "nom2", "hajer" , "hoho" , "soso ", "email", "login", "password", "cin");
//       ProprietaireEcole pr4=new ProprietaireEcole(0, "nom", "prenom" , "numTel" , "adresse ", "email", "login", "password", "cin");
//
//       
//       //Evaluation
//       EvaluationEcole eve= new EvaluationEcole(5,5,6,1);
//             ProprietaireEcoleService apr=  new ProprietaireEcoleService();
//          EvaluationEcoleService ees=new EvaluationEcoleService();
//     //Ecole
//       Ecole e=new Ecole(0, "sosololo", "logo","sosololo", "numTel", "email", "adresse", "site", 19, "ville");
//       EcoleService es =new EcoleService();
//       
//       //Demande
//       DemandeEcole de=new DemandeEcole(0, "preuve1", "preuve2","etat222", 19, 1);
      DemandeEcoleService des= new DemandeEcoleService();
//        
//
////****************************
//          // apr.AjouterProprietaireEcole(pr1);
//          //  apr.AjouterProprietaireEcole(pr2);
//           // apr.SupprimerProprietaireEcole(pr4);
//          //apr.ModifierProprietaireEcole(pr2);
//       // System.out.println(apr.consulterCompte(10));
//        //*****
//          //********
//        // ees.AjouterEvaluationEcole(eve);
//             //ees.ModifierEvaluationEcole(eve);
//             
//              //*****
//          //********
//        // es.AjouterEcole(e);
//         // es.SupprimerEcole(e);
//       // es.ModifierEcole(e);
//    //System.out.println(es.ConsulterEvaluationEcole(10)).toString();
//          
//              //*****
//          //********
//        //  des.AjouterDemandeEcole(de);
////des.AjouterDemandeEcole(de);
//          //des.ModifierDemandeEcole(de);
      ArrayList <DemandeEcole> lolo = des.consulterDemandeEcole();

  
          for (DemandeEcole demande44 : lolo)
          {System.out.println(demande44.toString());}
          
    }}

    

