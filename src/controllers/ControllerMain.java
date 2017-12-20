package controllers;

import models.*;
import views.*;

/**
 *
 * @author Briceyda Angeles
 */

public class ControllerMain {
    
    private final ModelMain model_main;
    private final ViewMain view_main;
    
    private final ModelVerificacionUsuario model_verificacion_usuario;
    private final ViewVerificacionUsuario view_verificacion_usuario;
    private final ControllerVerificacionUsuario controller_verificacion_usuario;
    
    private final ModelClientes model_clientes;
    private final View_Clientes view_clientes;
    private final ControllerClientes controller_clientes;
    
    private final View_Membresia view_membrecia;
    
    public ControllerMain(Object[] models, Object[] views, Object[] controllers){
        this.model_main = (ModelMain)models[0];
        this.view_main = (ViewMain)views[0];

        this.model_verificacion_usuario = (ModelVerificacionUsuario)models[1];
        this.view_verificacion_usuario = (ViewVerificacionUsuario)views[1];
        this.controller_verificacion_usuario = (ControllerVerificacionUsuario) controllers[1];
        
        this.model_clientes = (ModelClientes) models[2];
        this.view_clientes = (View_Clientes) views[2];
        this.controller_clientes = (ControllerClientes) controllers[2];
        
        this.view_membrecia = (View_Membresia)views[3];
        initView();
    }
    
    public void initView(){
        Definir_Action_Listeners();
        view_main.setTitle("Gym Olympus");
        view_main.setLocationRelativeTo(null);
        view_main.setVisible(true);
        view_main.jm_sistema.setVisible(false);
    } 
    
    public void Definir_Action_Listeners(){
        view_main.jmi_verificacion_usuario.addActionListener(e -> jmi_verificacion_usuarioMouseClicked());
        view_main.jmi_salir.addActionListener(e -> jmi_salirMouseClicked());
        view_main.jmi_clientes.addActionListener(e-> jmi_clientesMouseClicked());
        view_main.jmi_membrecia.addActionListener(e -> jmi_membreciaMouseClicked());
    }
    
    public void jmi_verificacion_usuarioMouseClicked(){
        view_main.setContentPane(view_verificacion_usuario);
        view_main.revalidate();
        view_main.repaint();
    }
    
    
    public void jmi_salirMouseClicked(){
        System.exit(0);
    }
    public void Interfaz(javax.swing.JPanel interfaz){
        view_main.setContentPane(interfaz);
        view_main.revalidate();
        view_main.repaint();
        interfaz.requestFocusInWindow();
    }
    public void jmi_clientesMouseClicked(){
        Interfaz(view_clientes);
    }
    
    public void jmi_membreciaMouseClicked(){
        Interfaz(view_membrecia);
    }
}