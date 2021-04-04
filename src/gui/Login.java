/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import BaseDatos.Conexiondb;
import BaseDatos.SqlUsuario;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.JOptionPane.*;

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
        setResizable(false);
        
        panelFormulario = new JPanel();
        panelFormulario.setLayout(new GridLayout(4,3));
        panelFormulario.setVisible(true);
        add(panelFormulario,BorderLayout.CENTER);
        
        labUsuario = new JLabel("Usuario: ");
        labClave = new JLabel("Clave: ");
        
        textUsuario = new JTextField();
        textUsuario.setEditable(true);
        
        textClave = new JPasswordField();
        textClave.setEditable(true);
        
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
        panelBotones.setLayout(new FlowLayout());
        panelBotones.setVisible(true);
        add(panelBotones,BorderLayout.SOUTH);
        
        btnIngresar = new JButton("Ingresar");
        btnIngresar.setActionCommand(INGRESAR);
        btnIngresar.addActionListener (this);
        
        panelBotones.add(new JLabel(""));
        panelBotones.add(btnIngresar);
        panelBotones.add(new JLabel(""));
        
        
    }
    
    
    
    public static void main(String args[]) throws ClassNotFoundException{
        Conexiondb con = new Conexiondb();
        Login login = new Login();
        login.setVisible(true);
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String  comando =e.getActionCommand();
        if(comando.equals(INGRESAR)){
            SqlUsuario user = new SqlUsuario();
            
            String clave=String.valueOf(textClave);
         
            if(!textUsuario.getText().equals("")&& !clave.equals("")){
                try {
                    
                    if(user.SqlLoguear(textUsuario.getText(), clave)){
                        JOptionPane.showMessageDialog(null,"Bienvenido", "Login", INFORMATION_MESSAGE);
                    }else{
                        JOptionPane.showMessageDialog(null,"Datos no válidos", "Login", ERROR_MESSAGE);
                    }
                    
                } catch (ClassNotFoundException | SQLException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else{
                JOptionPane.showMessageDialog(null, "Debe ingresar datos");
            }
        }        
    }
}
