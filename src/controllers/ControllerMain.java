
package controllers;
import javax.swing.JPanel;
import views.*;
import models.*;

/**
 *
 * @author Briceyda Angeles
 */
public class ControllerMain {
    private final ViewMain view_main;
    private final ModelMain model_main;

    private final ViewLogin view_login;    
    private final ModelVerificacionUsuario model_login;
    private final ControllerVerificacionUsuario controller_login;
    
    private final View_Clientes view_clientes;
    private final ModelClientes model_clientes; 
    private final ControllerClientes controller_clientes;
    
   
    public ControllerMain(Object[] models, Object[] views, Object[] controllers){
        this.view_main = (ViewMain)views[0];
        this.model_main = (ModelMain)models[0];
        
        this.view_login = (ViewLogin)views[1];
        this.model_login = (ModelVerificacionUsuario)models[1];
        this.controller_login = (ControllerVerificacionUsuario)controllers[1];
        
        this.view_clientes = (View_Clientes)views[2];
        this.model_clientes = (ModelClientes)models[2];
        this.controller_clientes = (ControllerClientes)controllers[2];
       /* 
        this.view_historial = (View_Historial)views[3];
        this.model_historial = (ModelHistorial)models[3];
        this.controller_historial = (ControllerHistorial)controllers[3];
        */
        

        initView();
    }    
    public void initView(){
        view_main.setVisible(true);
        view_main.setResizable(false); //tamaño
        view_main.setLocationRelativeTo(null);
        view_main.setTitle("Bienvenido");
        
        view_main.jm_efectivo.setVisible(false);
        view_main.jm_menu.setVisible(false);
        view_main.jm_sistema.setVisible(false);
        view_main.jm_efectivo.setVisible(false);
        this.view_main.jmi_clientes.addActionListener(e-> jmi_clientesActionPerformed());    
        this.view_main.jmi_cerrar_sesion.addActionListener(e-> jmi_cerrar_sesionActionPerformed());
        this.view_main.jmi_iniciar_sesion.addActionListener(e -> jmi_verificacion_usuarioMouseClicked());
/*        this.view_main.jmi_historial.addActionListener(e-> jmi_historialActionPerformed());
        /*this.view_main.jmi_empleados.addActionListener(e-> jmi_empleadosActionPerformed());*/
    }
    public void jmi_clientesActionPerformed(){
        Cambiar_Interfaz(view_clientes);
    }   
    public void Cambiar_Interfaz(javax.swing.JPanel interfaz){
        view_main.setContentPane(interfaz);
        view_main.revalidate();
        view_main.repaint();
        interfaz.requestFocusInWindow();
    }   
 
    
  /*  public void jmi_historialActionPerformed(){
        CambiarInterfazHistorial(view_historial);
        
    }
    public void CambiarInterfazHistorial(javax.swing.JPanel interfaz){
        view_main.setContentPane(interfaz);
        view_main.revalidate();
        view_main.repaint();
        interfaz.requestFocusInWindow();
        
    }
    
    
    /*public void jmi_empleadosActionPerformed(){
        CambiarInterfazEmpleados(view_empleados);
    }*/
    /*public void CambiarInterfazEmpleados(javax.swing.JPanel interfaz){
        view_main.setContentPane(interfaz);
        view_main.revalidate();
        view_main.repaint();
        interfaz.requestFocusInWindow();  */      
   
    
    public void jmi_verificacion_usuarioMouseClicked(){
        view_main.setContentPane(view_login);
        view_main.revalidate();
        view_main.repaint();
        
    }
    
    
    public void jmi_cerrar_sesionActionPerformed(){
        System.exit(0);
    }    
}
