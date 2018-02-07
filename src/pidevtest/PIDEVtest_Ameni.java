/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidevtest;

import DataStorage.MyDB;
import Services.AdminService;
import Services.BabySitterService;
import Services.DemandeBabySitterService;
import Services.EvaluationBabySitterService;
import edu.entites.Admin;
import edu.entites.BabySitter;
import edu.entites.DemandeBabySitter;
import edu.entites.EvaluationBabySitter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author LENOVO
 */
public class PIDEVtest_Ameni {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MyDB.getinstance(); 
       // BabySitterService bs = new BabySitterService(); 
        
        /***********************Test babyStitter*********************/ 
        
       /*********** cin est unique ************/
        BabySitter b = new BabySitter("cv", "photo", "cin3", 6 , "nom", "prenom", "99125125", "adresse", "email", "login", "password"); 
        /*bs.ajoutBabySitter(b);
        bs.modifierBabySitter(b, new BabySitter("cv1", "photo1", "cin", 88 , "nom1", "prenom1", "99125125", "adresse1", "email1", "login1", "password1"));
         // ArrayList<BabySitter> list = bs.listerBabySitter(); 
        for( BabySitter bb : list )
        { System.out.println(b.toString());}       
        bs.supprimerBabySitter(b);
        BabySitter b2 = bs.rechercheBabySitterParCin("cin"); 
        System.out.println(b2);*/
        
         /***********************Test Admin*********************/ 
        
        /*Admin a = new Admin (7, "", "","", "", "", "", "");
        AdminService as = new AdminService(); 
        as.modifierAdmin(a);*/
        
          /***********************Test EvaluationBabySitter *********************/ 
        
        EvaluationBabySitter e = new EvaluationBabySitter(1, 5 , 7 , 6);
        EvaluationBabySitterService se = new EvaluationBabySitterService (); 
      //  se.ajoutEvaluation(e);
      //  se.modifierEvaluation(e, 10);
        ArrayList<EvaluationBabySitter> list = new ArrayList<EvaluationBabySitter>(); 
       // list = se.listerEvaluationBabySitter(); 
        list = se.rechercheEvaluationBabySitter(b); 
        for( EvaluationBabySitter ev : list )
        { System.out.println(ev.toString());}   
        
         /***********************Test DemandeBabySitter  *********************/ 
        
        DemandeBabySitterService db = new DemandeBabySitterService(); 
      //  DemandeBabySitter bb = new DemandeBabySitter(10 , 6 , "preuve1", "preuve2", null); 
       // db.ajoutDemandeBabySitter(bb);
        /*db.modifierDemandeBabySitter(bb, "accepte");
        ArrayList<DemandeBabySitter> list = db.rechercheDemandeBabySitter(b); */
        //ArrayList<DemandeBabySitter> list = db.listerDemandeBabySitter(); 
       // ArrayList<DemandeBabySitter> list1 = db.listerDemandesAttentes(); 
       // for ( DemandeBabySitter dm : list1 )
       // { System.out.println(dm.toString());} 
        
      /* int nb = db.nb_demandes_acceptes(); 
        System.out.println(nb);*/
        
        
    }   
}
