/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Project;
import java.sql.*;
/**
 *
 * @author Janitha Theekshana
 */
public class Connection {
    
    public static Connection getcon()
    {
        Connection con = null;
       try
       {
           Class.forName("com.mysql.jdbc.Driver");
           con =(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/coviddb","root","");
           
       }
       catch(Exception e)
       {
       
       }
       
       return con;
    }

}
