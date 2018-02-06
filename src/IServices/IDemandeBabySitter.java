/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IServices;


import edu.entites.BabySitter;
import edu.entites.DemandeBabySitter;
import edu.entites.EvaluationBabySitter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public interface IDemandeBabySitter {
        public void ajoutDemandeBabySitter (DemandeBabySitter e );
        public void modifierDemandeBabySitter (DemandeBabySitter d , String etat);
        public ArrayList<DemandeBabySitter> rechercheDemandeBabySitter (BabySitter b );
        public ArrayList<DemandeBabySitter> listerDemandeBabySitter ();
}
