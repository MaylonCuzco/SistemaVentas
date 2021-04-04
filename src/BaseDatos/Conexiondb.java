/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDatos;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author DELL
 */
public final class Conexiondb {
    private static final String URL = "jdbc:mysql://localhost:3306/db_ventas";
    private Connection conectado;
    private static final String user="root";
    private static final String pass="root";
    
    public Conexiondb() throws ClassNotFoundException{
        conectado=conectar();
    }
    
    public  Connection conectar() throws ClassNotFoundException{
        Connection acceso =null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            acceso=DriverManager.getConnection(URL,user,pass);
           
           System.out.println("Conexion Exitosa");
        }catch(SQLException e){
            //System.out.println("Conexion Fallida");
            System.err.println(e.getMessage());
        }return  acceso;
    }

    public Connection getConectado() {
        return conectado;
    }
    
    
    /**
     public  boolean conexionb(){
    	boolean conectado=false;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/ventas","root","");
            System.out.println("Conexion Exitosa");
            conectado=true;
        }catch(Exception e){
            System.out.println("Conexion Fallida");
            System.err.println(e.getMessage());
        }return  conectado;
    }
    * **/
    /**
    public static void main(String[] args) {
        Conexiondb conexion=new Conexiondb();
        conexion.conexion();
    }
    **/
}
