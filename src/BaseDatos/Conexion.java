/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDatos;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author DELL
 */
public class Conexion {
    Connection cn;
    
    public  Connection conexion(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/sistemaventa","root","");
            //System.out.println("Conexi�n Exitosa");
        }catch(ClassNotFoundException | SQLException e){
            //System.out.println("Conexi�n Fallida");
            System.err.println(e.getMessage());
        }return  cn;
    }
     public  boolean conexionb(){
    	boolean conectado=false;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/sistemaventa","root","");
            System.out.println("Conexi�n Exitosa");
            conectado=true;
        }catch(Exception e){
            System.out.println("Conexi�n Fallida");
            System.err.println(e.getMessage());
        }return  conectado;
    }

}
