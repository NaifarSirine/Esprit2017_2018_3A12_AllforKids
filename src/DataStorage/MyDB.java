/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStorage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author LENOVO
 */
public class MyDB {
   final String url = "jdbc:mysql://localhost:3306/pi_bd"; 
   final String login = "root";
   final String pwd = "";
   private static MyDB instabne = null ; 
   private  Connection cnx; 
   
    public MyDB()
    {  
        try {
            cnx = DriverManager.getConnection(url,login,pwd);
            System.out.println("connexion établie ! ");           
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } }

    public static MyDB getinstance()
    {if(instabne == null)
    instabne = new MyDB();  
    return instabne; 
    }
   
    public Connection getConnexion()
    {return cnx ; }

}
