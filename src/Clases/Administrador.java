/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

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
    
    public boolean administrar() {
		boolean a=false;
        JTextField usuariot = new JTextField("");
        JTextField contraseniat = new JTextField("");
        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(new JLabel("Usuario:"));
        panel.add(usuariot);
        panel.add(new JLabel("Contraseña:"));
        panel.add(contraseniat);
        
        int opcion = JOptionPane.showConfirmDialog(null, panel, "Login",
            JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (opcion == JOptionPane.OK_OPTION) {
        	if(this.usuario.equals(usuariot.getText()) && this.contrasenia.equals(contraseniat.getText())) {
        		a=true;
        	}
        } else {
            System.exit(0);
        }
       return a; 
    }
    
}
