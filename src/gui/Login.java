/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author steevenE
 */
public class Login extends JFrame implements ActionListener{
    
    private JPanel panelFormulario;
    private JPanel panelBotones;
    
    private JLabel labUsuario;
    private JLabel labClave;
    private JTextField textUsuario;
    private JPasswordField textClave;
    
    private JButton btnIngresar;
    
    private final static String INGRESAR = "ingresar";
    
    public Login(){
        setLayout(new BorderLayout());
        setTitle("Login");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500,200);
        setResizable(true);
        
        panelFormulario = new JPanel();
        panelFormulario.setLayout(new GridLayout(4,3));
        panelFormulario.setVisible(true);
        
        labUsuario = new JLabel("Usuario");
        labClave = new JLabel("Clave");
        
        textUsuario = new JTextField();
        textUsuario.setEditable(true);
        
        textClave = new JPasswordField();
        textClave.setEditable(true);
        
        btnIngresar = new JButton("Ingresar");
        btnIngresar.setActionCommand(INGRESAR);
        btnIngresar.addActionListener((ActionListener) panelFormulario);
        
        panelFormulario.add(new JLabel(""));
        panelFormulario.add(new JLabel(""));
        panelFormulario.add(new JLabel(""));
        
        panelFormulario.add(labUsuario);
        panelFormulario.add(textUsuario);
        panelFormulario.add(new JLabel(""));
        
        panelFormulario.add(labClave);
        panelFormulario.add(textClave);
        panelFormulario.add(new JLabel(""));
        
        panelFormulario.add(new JLabel(""));
        panelFormulario.add(new JLabel(""));
        panelFormulario.add(new JLabel(""));
        
        panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(1,3));
        panelBotones.setVisible(true);
        panelBotones.add(new JLabel(""));
        panelBotones.add(btnIngresar);
        panelBotones.add(new JLabel(""));
        
        
    }
    
    
    
    public static void main(String args[]){
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
