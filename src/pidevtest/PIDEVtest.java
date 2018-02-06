/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidevtest;

import DataStorage.MyDB;
import Services.EvaluationGarderieService;
import Services.ProprietaireGarderieService;
import edu.entites.EvaluationGarderie;
import edu.entites.ProprietaireGarderie;


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
        //(int id, String nom, String prenom, String numTel, String adresse, String email, String login, String password,String Cin)
        ProprietaireGarderie PG =new ProprietaireGarderie(0,"soso","soso","97897512","Tunis","soso@esprit.tn","soso","hellososo","11223344");
        ProprietaireGarderie PG1 =new ProprietaireGarderie(7,"sosohoho","soso","97897512","Tunis","sosohoho@esprit.tn","soso","hellososohoho","11223344");
        ProprietaireGarderieService PGS=new ProprietaireGarderieService();
        //PGS.ajouterCompte(PG);
        //PGS.modifierCompte(PG1);
        //PGS.supprimerCompte(PG1);
        // System.out.println(PGS.consulterCompte(8).toString());
        EvaluationGarderie E=new EvaluationGarderie(0,15,8,1);
        EvaluationGarderie E1=new EvaluationGarderie(2,5,8,1);
        EvaluationGarderieService ES=new EvaluationGarderieService();
       // ES.ajouterEvaluationGarderie(E);
        ES.modifierEvaluationGarderie(E1);
    }
    
}
