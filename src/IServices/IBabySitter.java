/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IServices;

import edu.entites.BabySitter;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public interface IBabySitter {
   public void ajoutBabySitter(BabySitter b );
   public void modifierBabySitter (BabySitter b1 , BabySitter b2 );
   public void supprimerBabySitter (BabySitter b );
   public BabySitter rechercheBabySitterParCin(String cin );
   public List<BabySitter> listerBabySitter ();
}
