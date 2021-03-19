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
public class Administrador {
    
    /**
     * ATRIBUTOS
     */
    private String usuario;
    private String contrasenia;

    /**
     * CONSTRUCTOR
     * @param usuario
     * @param contrasenia 
     */
    public Administrador(String usuario, String contrasenia) {
        this.usuario = usuario;
        this.contrasenia = contrasenia;
    }
    public Administrador() {
        this.usuario = "";
        this.contrasenia = "";
    }

    /**
     * METODOS SETTERS Y GETTERS
     * @return 
     */
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
    
    
    
}
