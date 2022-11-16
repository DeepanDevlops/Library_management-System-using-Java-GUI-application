/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jframe;
import java.sql.*;
/**
 *
 * @author deepankumar
 */
public class DBconnect {
    static Connection con=null;
    public static Connection getConnection()
    {
        try
        {
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library_ms","root","root");
        }catch(Exception e)
        {
            System.out.println(e);
        }
        return con;
    }
    
}
