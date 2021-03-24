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
public class Productos {
    
    /**
     * ATRIBUTOS
     */
    
    private String codigo;
    private String nombre;
    private String detalle;
    private Double precio;
    private int stockMinimo;
    private int stockActual;
    
    /**
     * CONSTRUCTOR
     * @param codigo
     * @param nombre
     * @param detalle
     * @param precio
     * @param stockMinimo
     * @param stockActual
     */
    public Productos(String codigo, String nombre, String detalle, Double precio, int stockMinimo, int stockActual) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.detalle = detalle;
        this.precio = precio;
        this.stockMinimo = stockMinimo;
        this.stockActual = stockActual;
    }
    
    public Productos() {
        this.codigo ="";
        this.nombre = "";
        this.detalle = "";
        this.precio = 0.0;
        this.stockMinimo = 0;
        this.stockActual = 0;
    }

    /**
     * METODOS SETTERS Y GETTERS
     * @return 
     */
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public int getStockMinimo() {
        return stockMinimo;
    }

    public void setStockMinimo(int stockMinimo) {
        this.stockMinimo = stockMinimo;
    }

    public int getStockActual() {
        return stockActual;
    }

    public void setStockActual(int stockActual) {
        this.stockActual = stockActual;
    }
    
    /**
     * REGISTAR PRODUCTO
     */
    
    public boolean guardarProducto() {
		Conexion con=new Conexion();
	    Connection cn=con.conexion();
	    boolean guardado=false;
	    //EL CODIGO A�ADIDO DEBE SER DIFERENTE AL RESTO 
	    if(!buscarCodigo(this.codigo)) {
		    try{
		    	//SE GENERA UN OBJETO DE TIPO PreparedStatement EN EL CUAL HAREMOS USO DE INTERROGANTES PARA
		    	//DESPUES ESTOS SE ORGANIZARAN CON LOS METODOS SER CORRESPONDIENTES
			    PreparedStatement pps = (PreparedStatement) cn.prepareStatement("INSERT INTO productoFarmaceutico("
			            + "codigo, nombre, detalle, precio, stockMinimo, stockActual) VALUES(?,?,?,?,?,?)");
			    //SE SETEAN LOS DATOS A GUARDAR EN LA TABLA producto
			    //SE GUARDA LA INFORMACION EN LA BASE DE DATOS 
			    pps.setString(1, this.codigo);
			    pps.setString(2, this.nombre);
			    pps.setString(3, this.detalle);						    
			    pps.setString(4, this.precio.toString());			    
			    pps.setInt(5, this.stockMinimo);
			    pps.setInt(6, this.stockActual);			
			    pps.executeUpdate();
			    guardado = true;
			    //SE GENERA UN CONTROL PARA SABER SI EL CODIGO A�ADIDO ES DIFERENTE A DE OTROS
			    //SI ESTE ES IGUAL A OTRO ENVIA UN MENSAJE DE ADVERTENCIA 
		    }catch(SQLException ex){
		    	JOptionPane.showMessageDialog(null, "Error al registrar");
		    }
	    }else {
	    	JOptionPane.showMessageDialog(null, "El codigo ya ha sido registrado");
	    }
	    return guardado;
	}
	
	/**
	 * BUSCAR PRODUCTO CON UN CODIGO ESPECIFICO
	 * ES UTILIZADO PARA EL SETADO DE LA TABLA
	 * @param codigo
	 * @return
	 */
	public boolean buscarProducto(String codigo){
		//SE UTILIZA AL MOMENTOS DE BUSCAR A TRAVEZ DEL CODIGO DEL PRODUCTO
	    boolean result=false;
	    Conexion con=new Conexion();
	    Connection cn=con.conexion();
	    try{
	        Statement st=cn.createStatement();
	        ResultSet rs=st.executeQuery("SELECT * FROM  WHERE codigo='"+codigo+"'");
		        while (rs.next()) {
		        	//SE REALIZA UN SETEO EN LA TABLA PARA LA BUSQUEDA 
		            if(rs.getString(1).equals(codigo)) {
		            	this.codigo=rs.getString(1);
		            	this.nombre=rs.getString(2);
		            	this.detalle=rs.getString(3);		            		            	
		            	this.precio=rs.getDouble(6);		            
		            	this.stockMinimo=rs.getInt(8);
		            	this.stockActual=rs.getInt(9);		         
				        result=true;
		            }
		        }
	    }catch(Exception e){
	        e.printStackTrace();
	    }
	    return result;
	}
    
        
        public boolean buscarCodigo(String codigo){
		//RETORNA UN BOLEANO 
		//SI ENCUENTRA EL MISMO CODIGO NO PERMITE GUARDAR EN LA LISTA 
		//CASO CONTRARIO LO A�ADE A LA TABLA
	    boolean result=false;
	    Conexion con=new Conexion();
	    Connection cn=con.conexion();
	    try{
	        Statement st=cn.createStatement();
	        ResultSet rs=st.executeQuery("SELECT * FROM WHERE codigo='"+codigo+"'");
		        while (rs.next()) {
		            if(rs.getString(1).equals(codigo)) {
			        result=true;
		            }
		        }
	    }catch(Exception e){
	        e.printStackTrace();
	    }
	    return result;
	}
        
        public boolean eliminarProducto() {
		//MISMA ESTRUCTIRA DEL METDOD BUSCAR CON LA DIFERENCIA 
		//DE QUE CAMBIA LA SENTENCIA A ELIMINAR DE LA TABLA producto
		boolean eliminado=false;
		Conexion con=new Conexion();
	    Connection cn=con.conexion();
	    //SE ESPECIFICA QUE ES LO QUE SE NECESITA EN LA OPERACION 
	    //EN ESTE CASO SE REQUIERE ELIMINAR
	    String sql="Delete from where codigo = "+codigo;
	    try{
	        Statement st=cn.createStatement();
	        int rs=st.executeUpdate(sql);
	        if(rs>0){
	        	eliminado=true;
	        }
	    }catch(Exception e){
	        e.printStackTrace();
	    }
	    return eliminado;
	}
}
