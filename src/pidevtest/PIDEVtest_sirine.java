/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidevtest;

import DataStorage.MyDB;
import Services.DemandeAjoutGarderieService;
import Services.EvaluationGarderieService;
import Services.GarderieService;
import Services.ProprietaireGarderieService;
import Utils.EtatDemandeAjout;
import edu.entites.DemandeAjoutGarderie;
import edu.entites.EvaluationGarderie;
import edu.entites.Garderie;
import edu.entites.ProprietaireGarderie;
import java.util.ArrayList;



/**
 *
 * @author Pc
 */
public class PIDEVtest_sirine {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MyDB.getinstance(); 
//        ProprietaireGarderie PG =new ProprietaireGarderie(0,"soso","soso","97897512","Tunis","soso@esprit.tn","soso","hellososo","11223344");
//        ProprietaireGarderie PG1 =new ProprietaireGarderie(7,"sosohoho","soso","97897512","Tunis","sosohoho@esprit.tn","soso","hellososohoho","11223344");
//        ProprietaireGarderieService PGS=new ProprietaireGarderieService();
//        PGS.ajouterCompte(PG);
//        PGS.modifierCompte(PG1);
//        PGS.supprimerCompte(PG1);
//         System.out.println(PGS.consulterCompte(16).toString());
//        EvaluationGarderie E=new EvaluationGarderie(0,15,16,1);
//        EvaluationGarderie E1=new EvaluationGarderie(5,5,16,1);
//        EvaluationGarderieService ES=new EvaluationGarderieService();
//        ES.ajouterEvaluationGarderie(E);
//       ES.modifierEvaluationGarderie(E1);
//        DemandeAjoutGarderie D=new DemandeAjoutGarderie(0,"hello","hello2", EtatDemandeAjoutGarderie.EnTraitement,16,1);
//        DemandeAjoutGarderieService DAS=new DemandeAjoutGarderieService();
//        DAS.ajouterDemandeAjoutGarderie(D);
//        DAS.modifierEtat(2, EtatDemandeAjoutGarderie.EnTraitement);
//        ArrayList<DemandeAjoutGarderie> Liste= DAS.consulterDemandeAjoutGarderie();
//         for(DemandeAjoutGarderie DAG1:Liste)
//       {
//           System.out.println(DAG1.toString());
//       }
//       Garderie G=new Garderie(0,"test","test","test","test","test","test","test",6,"tunis");
//        Garderie G1=new Garderie(2,"test","testallo","test","test","test","test","test",6,"Bizerte");
//       GarderieService GS=new GarderieService();
//       GS.ajouterGarderie(G);
//        GS.modifierGarderie(G1);
//        GS.supprimerGarderie(G1);
//        System.out.println(GS.rechercheGarderie("test").toString());
//        ArrayList<Garderie> ListGarderie= GS.consulterGarderie();
//        for(Garderie G3:ListGarderie)
//        {
//            System.out.println(G3.toString());
//        }

    }}

    

