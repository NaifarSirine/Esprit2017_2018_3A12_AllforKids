/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidevtest;

import DataStorage.MyDB;
import Services.CommentaireService;
import Services.DemandeAjoutGarderieService;
import Services.EvaluationGarderieService;
import Services.GarderieService;
import Services.ParentService;
import Services.ProprietaireGarderieService;
import Services.SujetService;
import Utils.EtatDemandeAjoutGarderie;
import edu.entites.Commentaire;
import edu.entites.DemandeAjoutGarderie;
import edu.entites.EvaluationGarderie;
import edu.entites.Garderie;
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
        
        ProprietaireGarderie PG =new ProprietaireGarderie(0,"soso","soso","97897512","Tunis","soso@esprit.tn","soso","hellososo","11223344");
        ProprietaireGarderie PG1 =new ProprietaireGarderie(7,"sosohoho","soso","97897512","Tunis","sosohoho@esprit.tn","soso","hellososohoho","11223344");
        ProprietaireGarderieService PGS=new ProprietaireGarderieService();
        //PGS.ajouterCompte(PG);
        //PGS.modifierCompte(PG1);
        //PGS.supprimerCompte(PG1);
         //System.out.println(PGS.consulterCompte(16).toString());
        EvaluationGarderie E=new EvaluationGarderie(0,15,16,1);
        EvaluationGarderie E1=new EvaluationGarderie(5,5,16,1);
        EvaluationGarderieService ES=new EvaluationGarderieService();
        //ES.ajouterEvaluationGarderie(E);
      // ES.modifierEvaluationGarderie(E1);
        DemandeAjoutGarderie D=new DemandeAjoutGarderie(0,"hello","hello2", EtatDemandeAjoutGarderie.EnTraitement,16,1);
        DemandeAjoutGarderieService DAS=new DemandeAjoutGarderieService();
        //DAS.ajouterDemandeAjoutGarderie(D);
        //DAS.modifierEtat(2, EtatDemandeAjoutGarderie.EnTraitement);
        //ArrayList<DemandeAjoutGarderie> Liste= DAS.consulterDemandeAjoutGarderie();
         //for(DemandeAjoutGarderie DAG1:Liste)
       //{
          // System.out.println(DAG1.toString());
       //}
        Garderie G=new Garderie(0,"test","test","test","test","test","test","test",6,"tunis");
        Garderie G1=new Garderie(2,"test","testallo","test","test","test","test","test",6,"Bizerte");
        GarderieService GS=new GarderieService();
         //GS.ajouterGarderie(G);
        //GS.modifierGarderie(G1);
        //GS.supprimerGarderie(G1);
        //System.out.println(GS.rechercheGarderie("test").toString());
//        ArrayList<Garderie> ListGarderie= GS.consulterGarderie();
//        for(Garderie G3:ListGarderie)
//        {
//            System.out.println(G3.toString());
//        }

    
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
                                                                                               }*/
                                                                                              
                                                         /* ArrayList<Sujet> list =new ArrayList<Sujet>();
                                                            list=ss.rechercherSujets();
                                                            for(Sujet d:list){
                                                            System.out.println(s.toString());
                                                                            }*/
      
      
                   Commentaire cm1 = new Commentaire(0, "merci ",1,9);
                   Commentaire cm = new Commentaire(0, "merci pour votre attention",1,13);
                   CommentaireService cc = new CommentaireService();

                                                         // cc.ajouterCommentaire(cm);
                                                         // cc.ajouterCommentaire(cm1);
                                                         // cc.supprimerCommentaire(cm);
    
                                                        /* ArrayList<Commentaire> liste=new ArrayList<Commentaire>();
                                                           liste=cc.consulterCommentaire();{
                                                           for(Commentaire b:liste)
                                                           System.out.println(b.toString());
                                                                              } */


}

         //System.out.println(GS.rechercheGarderie("soso").toString());
    }

    

