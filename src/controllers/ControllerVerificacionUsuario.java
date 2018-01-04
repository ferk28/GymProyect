package controllers;

import models.ModelVerificacionUsuario;
import views.ViewMain;
import views.ViewVerificacionUsuario;

/**
 *
 * @author Briceyda Angeles
 */

public class ControllerVerificacionUsuario {
    
    private final ModelVerificacionUsuario model_verificacion_usuario;
    private final ViewMain view_main;
    private final ViewVerificacionUsuario view_verificacion_usuario;
    private final ControllerMain controller_main; 
    
    public ControllerVerificacionUsuario(Object[] models, Object[] views, Object[] controllers){
        this.model_verificacion_usuario = (ModelVerificacionUsuario)models[1];
        this.view_main = (ViewMain)views[0];
        this.view_verificacion_usuario = (ViewVerificacionUsuario)views[1];
        this.controller_main = (ControllerMain)controllers[0];
        initView();
    }
    
    public void initView(){
        Definir_Action_Listeners();
    }
    
    public void Definir_Action_Listeners(){
        view_verificacion_usuario.jbtn_iniciar.addActionListener(e -> jbtn_iniciarMouseClicked());
    }
    
    public void setDatos(){
        model_verificacion_usuario.setUsuario(view_verificacion_usuario.jtf_usuario.getText());
        model_verificacion_usuario.setContraseña_usuario(view_verificacion_usuario.jpwd_contraseña.getPassword());
    }
    
    public void jbtn_iniciarMouseClicked(){
        setDatos();
        model_verificacion_usuario.Verificar_Usuario();
        model_verificacion_usuario.Verificar_Tipo_Usuario();
        if(model_verificacion_usuario.getTipo_usuario().equals("Admin")){
            view_main.jm_sistema.setVisible(true);
            view_main.jme_archivo.setVisible(true);
            view_main.jmi_verificacion_usuario.setVisible(false);
            
           
            //desbloquea jmi relacionado con el administrador
           
        }
        else{
            //desbloquea jmi's relacionado con empleado
            view_main.jme_archivo.setVisible(false);
            view_main.jm_sistema.setVisible(true);
            view_main.jmi_asistencias.setVisible(true);
            view_main.jmi_rentas.setVisible(true);
            view_main.jmi_clientes.setVisible(true);
            view_main.jmi_membrecia.setVisible(false);
            view_main.jmi_verificacion_usuario.setVisible(false);
        }
        view_verificacion_usuario.jtf_usuario.setText("");
        view_verificacion_usuario.jpwd_contraseña.setText("");
    }
}