/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDatos;

import java.sql.*;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.*;

/**
 *
 * @author steevenE
 */
public class SqlUsuario {
    
    
    
    
    public Boolean SqlLoguear(String nombre,String clave) throws ClassNotFoundException, SQLException{
        
    PreparedStatement ps= null;
    ResultSet rs=null;
    Conexiondb con= new Conexiondb();
    Connection conSql=con.getConectado();
    boolean coincide=false;
    String conClave="";
    String conNombre="";
    
    
    String sql ="SELECT * FROM tab_login where nombre=?";
  
    
    try{
        ps=conSql.prepareStatement(sql);
        ps.setString(1,nombre);
        rs=ps.executeQuery();
        
        while(rs.next()){
            
            coincide=true;
            
        }       
        conSql.close();
       
        
    }catch(SQLException ex){
        ex.printStackTrace();
        
    }/**
    if(conNombre!="" && conClave!=""){
        coincide=true;
    }
    **/
    System.out.println(""+conNombre+ conClave);
    
  
   
    
    
    return coincide;
    
    
  
    }
}
    
