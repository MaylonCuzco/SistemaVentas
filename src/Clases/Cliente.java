/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import BaseDatos.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author DELL
 */
public class Cliente {
     
    /**
     * ATRIBUTOS
     */
    private String nombre;
    private String telefono;
    private String email;
    private String direccion;
    private int cdl;

    /**
     * CONSTRUCTOR
     * @param nombre
     * @param telefono
     * @param email
     * @param direccion
     * @param cdl
     */
    
     public Cliente(String nombre, String telefono, String email, String direccion, int cdl) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        this.direccion = direccion;
        this.cdl = cdl;
    }
     
     public Cliente() {
        this.nombre = "";
        this.telefono = "";
        this.email = "";
        this.direccion = "";
        this.cdl = 0;
    }

     /**
      * METODOS SETTERS Y GETTERS
      * @return 
      */
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getCdl() {
        return cdl;
    }

    public void setCdl(int cdl) {
        this.cdl = cdl;
    }
     
     /**
	 * SE GUARDA LOS DATOS DEL CLIENTE
	 * @return
	 */
	public boolean registrarCliente() {
		Conexion con=new Conexion();
	    Connection cn=con.conexion();
	    boolean guardado=false;
	    if(!buscarCdl(this.getCdl())) {
		    try{
			    PreparedStatement pps = (PreparedStatement) cn.prepareStatement("INSERT INTO proveedor("
			            + "nombre, telefono, email, direccion, cdl) VALUES(?,?,?,?,?)");
			    pps.setString(1, this.nombre);
			    pps.setString(2, this.telefono);		
			    pps.setString(3, this.email);
			    pps.setString(4, this.direccion); 
			    pps.setInt(5, this.cdl);
			    pps.executeUpdate();
			    guardado = true;
		    }catch(SQLException ex){
		    	JOptionPane.showMessageDialog(null, "Error al registrar");
		    }
	    }else {
	    	JOptionPane.showMessageDialog(null, "El cliente ya ha sido registrado");
	    }
	    return guardado;
	}
        
        public boolean buscarCdl(int cdl){
	    boolean result=false;
	    Conexion con=new Conexion();
	    Connection cn=con.conexion();
	    try{
	        Statement st=cn.createStatement();
	        ResultSet rs=st.executeQuery("SELECT * FROM cliente WHERE cdl='"+cdl+"'");
		        while (rs.next()) {
		            if(rs.getString(1).equals(cdl)) {
			        result=true;
		            }
		        }
	    }catch(Exception e){
	        e.printStackTrace();
	    }
	    return result;
	}
        
        public boolean actualizarCliente() {
		boolean actualizado=false;
		Conexion con=new Conexion();
	    Connection cn=con.conexion();
	    if(buscarCdl(this.getCdl())) {
		    try{
		        PreparedStatement pps=cn.prepareStatement("UPDATE proveedor SET "
	        		+ "Nombre='"+this.nombre+"', "
	        		+ "telefono='"+this.telefono+"', "
	        		+ "email='"+this.email+"', "
	        		+ "direccion='"+this.direccion+"', "
	        		+ "WHERE cdl='"+this.getCdl()+"'");
		        pps.executeUpdate();
		        actualizado=true;
		    }catch(SQLException ex){
		    }
	    }else {
	    	JOptionPane.showMessageDialog(null, "No se ha encontrado al cliente con el #cdl: ");
	    }
		return actualizado;
	}

        
}
