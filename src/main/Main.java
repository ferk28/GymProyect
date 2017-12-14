package main;

import models.*;
import controllers.*;
import views.*;

/**
 *
 * @author Briceyda Angeles Perez 
 */

public class Main {
    
    public static void main (String bap[]){
        ModelMain model_main = new ModelMain();
        ModelVerificacionUsuario model_verificacion_usuario = new ModelVerificacionUsuario(model_main);
        
        ViewMain view_main = new ViewMain();
        ViewVerificacionUsuario view_verificacion_usuario = new ViewVerificacionUsuario();
       // ViewAdmin view_admin = new ViewAdmin();
        //ViewVendedor view_vendedor = new ViewVendedor();
        
        Object[] models = new Object[2];
        Object[] views = new Object[4];
        Object[] controllers = new Object[2];
        
        models[0] = model_main;
        models[1] = model_verificacion_usuario;
        
        views[0] = view_main;
        views[1] = view_verificacion_usuario;
        //views[2] = view_admin;
        //views[3] = view_vendedor;
        
        
        ControllerMain controller_main = new ControllerMain(models, views);
        controllers[0] = controller_main;
        
        ControllerVerificacionUsuario controller_verificacion_usuario = new ControllerVerificacionUsuario(models, views, controllers);
        controllers[1] = controller_verificacion_usuario;
        
       
    }
    
}
