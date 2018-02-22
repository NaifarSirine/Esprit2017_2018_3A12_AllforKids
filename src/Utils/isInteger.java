/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

/**
 *
 * @author PC
 */
public class isInteger {
    public static boolean isInteger(String input)
    {
        
   try
   {
      Integer.parseInt( input );
      if (input.length()==8)
      {return true;}
      else 
      {
          return false;
      }
   }
   catch( NumberFormatException e )
   {
      return false;
   }
    }
}
