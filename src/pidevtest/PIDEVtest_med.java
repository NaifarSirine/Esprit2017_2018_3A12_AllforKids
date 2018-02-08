/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidevtest;
import Services.DemandeClubService;
import edu.entites.DemandeClub;
import DataStorage.MyDB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import edu.entites.ProprietaireClub;
import edu.entites.Club;
import Services.ClubService;
import Services.ProprietaireService;
import edu.entites.EvaluationClub;
import Services.EvaluatioClubService;
import Utils.EtatDemandeAjout;
import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author LENOVO
 * 
 */
public class PIDEVtest_med {
 
   static Connection connexion;
    static Statement state;
    final String url = "jdbc:mysql://localhost:3306/pi_bd"; 
    final String login = "root";
   final String pwd = "";
   
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MyDB.getinstance(); 
        //           ********* ProprietaireClub*************
        ProprietaireClub P=new ProprietaireClub(21, "med", "hammami", "551" , "ruekhayredine", "med@gmail.com", "rafael", "rafael","club");
         ProprietaireClub P2=new ProprietaireClub(21, "heni", "hammami", "22254145", "ruekhayredine", "med@gmail.com", "rafael", "rafael","prof");
        ProprietaireClub P1=new ProprietaireClub(32, "bech", "bachbouch", "93554145", "rue", "bech@gmail.com", "bechir", "bechir","club");
        ProprietaireService ps= new ProprietaireService();
    /* ps.ajouterCompte(P1);
       ps.ajouterCompte(P2);
      ps.supprimerCompte(P1);
     ps.modifierCompte( P1);*/
        System.out.println(ps.consulterProprietaireClubs(2).toString());
                
        //     ***********Club*************
        
        /*Club c =new Club(2, "ahmed", "logos", "jeux", "dfghjklh", "44545", "", "", "", "", 16, "");
       ClubService cs=new ClubService();
       cs.ajouterClub(c);
       cs.supprimerClub(c);
       cs.modifierClub(c);
       cs.consulterClubs().forEach(s -> System.out.println(s));
       System.out.println(cs.chercherClubs("ahmed").toString());
             //***********EvaluatioClub************
      EvaluationClub d =new EvaluationClub(1, 9, 16, 18);
       EvaluatioClubService es=new EvaluatioClubService();
       es.AjouterEvaluationClub(d);
       es.ModifierEvaluationClub(d);
       es.supprimerEvaluationClub(d);
       // ****************demande*************
       DemandeClub k=new DemandeClub(0, "cin", "carte",EtatDemandeAjout.EnTraitement, 16, 1);
      DemandeClubService dd=new DemandeClubService();
      dd.ajouterdemande(k);
      dd.modifierEtat(1, EtatDemandeAjout.Refusee);
      dd.consulterDemandeAjoutClub().forEach(s -> System.out.println(s));*/
      
        
       
    }
    
}
