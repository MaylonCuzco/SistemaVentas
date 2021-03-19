/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

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
     
     

}
