
package controllers;
import views.*;
import models.*;
/**
 *
 * @author Briceyda Angeles
 */
public class ControllerMain {
    
    private final ModelMain model_main;
    private final ModelVerificacionUsuario model_verificacion_usuario;
    private final ViewMain view_main;
    private final ViewVerificacionUsuario view_verificacion_usuario;
    //private final ViewAdmin view_admin;
    //private final ViewVendedor view_vendedor;
    
    public ControllerMain(Object[] models, Object[] views){
        this.model_main = (ModelMain)models[0];
        this.model_verificacion_usuario = (ModelVerificacionUsuario)models[1];
        this.view_main = (ViewMain)views[0];
        this.view_verificacion_usuario = (ViewVerificacionUsuario)views[1];
        //this.view_admin = (ViewAdmin)views[2];
        //this.view_vendedor = (ViewVendedor)views[3];
        initView();
    }
    
    public void initView(){
        Definir_Action_Listeners();
        view_main.setTitle("PRINCIPAL");
        view_main.setLocationRelativeTo(null);
        view_main.setVisible(false);
    } 
    
    public void Definir_Action_Listeners(){
        view_main.jmi_iniciar_sesion.addActionListener(e -> jmi_verificacion_usuarioMouseClicked());
        view_main.jmi_menu.addActionListener(e -> jmi_menuMouseClicked());
       // view_main.jmi_vendedor.addActionListener(e -> jmi_vendedorMouseClicked());
        view_main.jmi_salir.addActionListener(e -> jmi_salirMouseClicked());
    }
    
    public void jmi_verificacion_usuarioMouseClicked(){
        view_main.setContentPane(view_verificacion_usuario);
        view_main.revalidate();
        view_main.repaint();
    }
    
    public void jmi_menuMouseClicked(){
        view_main.setContentPane(view_main);
        view_main.revalidate();
        view_main.repaint();
    }
    
    //public void jmi_vendedorMouseClicked(){
     //   view_main.setContentPane(view_vendedor);
       // view_main.revalidate();
    //view_main.repaint();
   // }
    
    public void jmi_salirMouseClicked(){
        System.exit(0);
    }

    
}
